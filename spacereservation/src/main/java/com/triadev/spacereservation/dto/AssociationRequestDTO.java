package com.triadev.spacereservation.dto;

import java.util.List;

import com.triadev.spacereservation.entitie.Association;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AssociationRequestDTO {
    private Association association;
    private List<ParticipantDTO> participants;
}
