package com.triadev.spacereservation.dto;

import java.util.List;
import java.util.UUID;

import com.triadev.spacereservation.entitie.Association;

import lombok.Getter;

@Getter
public class AssociationDTO {
    
    private UUID cod;
    private String name;
    private List<AssociationParticipantDTO> participants;

    public AssociationDTO(Association association, List<AssociationParticipantDTO> participants){
        this.cod = association.getCod();
        this.name = association.getName();
        this.participants = participants;
    }
}
