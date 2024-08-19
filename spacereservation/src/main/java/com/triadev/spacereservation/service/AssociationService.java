package com.triadev.spacereservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triadev.spacereservation.dto.AssociationDTO;
import com.triadev.spacereservation.dto.AssociationParticipantDTO;
import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.AssociationParticipant;
import com.triadev.spacereservation.entitie.Participants;
import com.triadev.spacereservation.entitie.Role;
import com.triadev.spacereservation.repository.AssociationRepository;
import com.triadev.spacereservation.repository.ParticipantsRepository;

@Service
public class AssociationService {

    @Autowired
    private AssociationRepository repo;

    @Autowired
    private ParticipantsRepository participantsRepository;

    @Autowired
    private AssociationParticipantService associationParticipantService;

    public List<AssociationDTO> getAllAssociations() {
        List<Association> list = repo.findAll();

        List<AssociationDTO> newList = new ArrayList<>();

        for (Association association : list) {

            List<AssociationParticipant> members = associationParticipantService
                    .getLiAssociationParticipantsByCod(association);
            List<AssociationParticipantDTO> membersDTO = getAllMembesToAssociation(members);
            AssociationDTO newAssociation = new AssociationDTO(association, membersDTO);
            newList.add(newAssociation);
        }
        return newList;
    }

    public Optional<Association> getByUUID(UUID cod) {
        Optional<Association> association = repo.findById(cod);
        /* Association ass = association.get();
        List<AssociationParticipant> members = associationParticipantService.getLiAssociationParticipantsByCod(ass);
        List<AssociationParticipantDTO> membersDTO = getAllMembesToAssociation(members);

        AssociationDTO newAssociation = new AssociationDTO(ass, membersDTO); */
        return association;
    }

    public Association createAssociation(Association association) {
        return repo.save(association);
    }

    public void deleteAssociation(UUID cod) {
        repo.deleteById(cod);
    }

    public void addMembersToAssociation(UUID associationId, Participants member, Role role) {
        Association association = repo.findById(associationId)
                .orElseThrow(() -> new RuntimeException("Association not found"));

        Participants participant = participantsRepository.save(member);
        AssociationParticipant associationParticipant = new AssociationParticipant();
        associationParticipant.setAssociation(association);
        associationParticipant.setParticipant(participant);
        associationParticipant.setRole(role);
        associationParticipantService.creteParticipant(associationParticipant);

    }

    public Association updateAssociation(UUID id, Association associationDetails) {
        return repo.findById(id)
                .map(association -> {
                    association.setName(associationDetails.getName());
                    association.setParticipants(associationDetails.getParticipants());
                    return repo.save(association);
                })
                .orElseThrow(() -> new RuntimeException("Association not found"));
    }

    private List<AssociationParticipantDTO> getAllMembesToAssociation(List<AssociationParticipant> participants) {
        List<AssociationParticipantDTO> newAssociationParicipants = participants.stream()
                .map(ap -> new AssociationParticipantDTO(
                        ap.getParticipant().getCod(),
                        ap.getParticipant().getName(),
                        ap.getRole()))
                .collect(Collectors.toList());
        return newAssociationParicipants;
    }

}
