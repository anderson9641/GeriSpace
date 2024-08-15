package com.triadev.spacereservation.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.Participants;
import com.triadev.spacereservation.repository.AssociationRepository;
import com.triadev.spacereservation.repository.ParticipantsRepository;

@Service
public class AssociationService {
 
@Autowired    
private AssociationRepository repo;

@Autowired
private ParticipantsRepository participantsRepository;

    public List<Association> getAllAssociations(){
        return repo.findAll();
    }

    public Optional<Association> getByUUID(UUID cod){
        return repo.findById(cod);
    }

    public Association createAssociation(Association association){
        return repo.save(association);
    }

    public void deleteAssociation(UUID cod){
        repo.deleteById(cod);
    }

    

    /* public void addMembersToAssociation(UUID associationId, List<Participants> newMembers) {
        Association association = repo.findById(associationId)
                .orElseThrow(() -> new RuntimeException("Association not found"));

        for (Participants member : newMembers) {
            member.setAssociation(association);
            participantsRepository.save(member);
        }

        association.getMembers().addAll(newMembers);
        repo.save(association);
    } */

    public Association updateAssociation(UUID id, Association associationDetails) {
        return repo.findById(id)
            .map(association -> {
                association.setName(associationDetails.getName());
                association.setParticipants(associationDetails.getParticipants());
                return repo.save(association);
            })
            .orElseThrow(() -> new RuntimeException("Association not found"));
    }
    
}
