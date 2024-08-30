package com.triadev.spacereservation.dto;

import com.triadev.spacereservation.entitie.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantDTO {
    private String name;
    private Role isResponsible;
    
}
