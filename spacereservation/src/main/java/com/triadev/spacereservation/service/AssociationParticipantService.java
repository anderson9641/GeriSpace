package com.triadev.spacereservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.AssociationParticipant;
import com.triadev.spacereservation.repository.AssociationParticipantRepository;

@Service
public class AssociationParticipantService {
    
    @Autowired
    private AssociationParticipantRepository repo;

    public List<AssociationParticipant> getListAssociationParticipants(){
        return repo.findAll();
    }

    public AssociationParticipant creteParticipant(AssociationParticipant associationParticipant){
        return repo.save(associationParticipant);
    }

    public List<AssociationParticipant> getListByAssociation(Association ass){
        return repo.findByAssociation(ass);
    }
}
