package com.triadev.spacereservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triadev.spacereservation.entitie.Participants;
import com.triadev.spacereservation.repository.ParticipantsRepository;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantsRepository repo;


    public Optional<Participants> getParticipantByID(UUID cod){
        return repo.findById(cod);
    }

    public List<Participants> getAllParticipants(){
        return repo.findAll();
    }

    public Participants createParticipant(Participants participant){
        return repo.save(participant);
    }

    public void deleteParticipant(UUID cod){
        repo.deleteById(cod);
    }

    public Participants updateParticipant(UUID id, Participants participantDetails) {
        return repo.findById(id)
            .map(participant -> {
                participant.setName(participantDetails.getName());
                participant.setCpf(participantDetails.getCpf());
                participant.setEmail(participantDetails.getEmail());
                participant.setFone(participantDetails.getFone());
                // Atualize outros campos conforme necessário
                return repo.save(participant);
            })
            .orElseThrow(() -> new RuntimeException("Participant not found"));
    }
}
