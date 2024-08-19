package com.triadev.spacereservation.dto;

import java.util.UUID;

import com.triadev.spacereservation.entitie.Role;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AssociationParticipantDTO {
    private UUID codParticipant;
    private String nameParticipant;
    private Role role;

    public AssociationParticipantDTO(UUID codParticipant, String nameParticipant, Role role){
        this.codParticipant = codParticipant;
        this.nameParticipant = nameParticipant;
        this.role = role;

    }
}
