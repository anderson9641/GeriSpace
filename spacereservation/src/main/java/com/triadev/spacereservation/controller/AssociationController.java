package com.triadev.spacereservation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triadev.spacereservation.dto.AssociationDTO;
import com.triadev.spacereservation.dto.AssociationRequestDTO;
import com.triadev.spacereservation.dto.ParticipantDTO;
import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.Participants;
import com.triadev.spacereservation.service.AssociationService;
import com.triadev.spacereservation.service.ParticipantService;

@RestController
@RequestMapping("/association")
public class AssociationController {

    private final AssociationService associationService;
    private final ParticipantService participantService;

    public AssociationController(AssociationService associationService, ParticipantService participantService){
        this.associationService = associationService;
        this.participantService = participantService;
    }


    @GetMapping
    public List<AssociationDTO> listAssociation(){
        return associationService.getAllAssociations();    
    }

    @GetMapping("/{cod}")
    public AssociationDTO getAssociation(@PathVariable UUID cod){
        return associationService.getByUUID(cod);
    }

    @PostMapping
    public ResponseEntity<Association> createAssociation(@RequestBody AssociationRequestDTO associationRequest){
        Association Association = associationRequest.getAssociation();
        List<ParticipantDTO> listParticipants =  associationRequest.getParticipants();
        System.out.println(listParticipants.get(0).getName());

        Association createdAssociation = associationService.createAssociationWithParticipants(Association, listParticipants);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssociation);
        
    }

    @DeleteMapping("/{cod}")
    public ResponseEntity<String> deleteAssociation(@PathVariable UUID cod){
        AssociationDTO association = associationService.getByUUID(cod);

        if(association == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Associação não encontrada!");
        }
        associationService.deleteAssociation(cod);
        return ResponseEntity.ok("Associação deletada com sucesso");

    }

    
    
}
