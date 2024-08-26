package com.triadev.spacereservation.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triadev.spacereservation.entitie.Space;
import com.triadev.spacereservation.service.SpaceService;

@RestController
@RequestMapping("/space")
public class SpaceController {
    
    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService){
        this.spaceService = spaceService;
    }

    @GetMapping
    public List<Space> getAllSpace(){
        return spaceService.getAllSpaces();
    }

    @GetMapping("/{cod}")
    public Optional<Space> getSpace(@PathVariable UUID cod){
        return spaceService.getSpaceById(cod);
    }

    @PostMapping
    public Space createdSpace(@RequestBody Space space){
        return spaceService.createSpace(space);
    }

    @DeleteMapping
    public ResponseEntity<Space> deleteSpace(@PathVariable UUID cod){
        spaceService.deleteSpace(cod);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cod}")
    public ResponseEntity<Space> updateSpace(@PathVariable UUID cod, @RequestBody Space spaceDetail){
        Space newSpace = spaceService.updateSpace(cod, spaceDetail);
        return ResponseEntity.ok().body(newSpace);
    }


}
