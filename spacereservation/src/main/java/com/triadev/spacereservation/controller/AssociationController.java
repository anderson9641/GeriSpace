package com.triadev.spacereservation.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triadev.spacereservation.dto.AssociationDTO;
import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.service.AssociationService;

@RestController
@RequestMapping("/association")
public class AssociationController {

    private final AssociationService associationService;

    public AssociationController(AssociationService associationService){
        this.associationService = associationService;
    }


    @GetMapping
    public List<AssociationDTO> listAssociation(){
        return associationService.getAllAssociations();    
    }

    @GetMapping("/{cod}")
    public Optional<Association> getAssociation(@PathVariable UUID cod){
        return associationService.getByUUID(cod);
    }


    
}
