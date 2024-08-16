package com.triadev.spacereservation.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.AssociationParticipant;
import com.triadev.spacereservation.entitie.Participants;

public interface AssociationParticipantRepository extends JpaRepository<AssociationParticipant,UUID>{
    List<AssociationParticipant> findByParticipant(Participants participanteId);
    List<AssociationParticipant> findByAssociation(Association associacaoId);
    Optional<AssociationParticipant> findByAssociationAndParticipant(Association associacaoId, Participants participanteId);
}
