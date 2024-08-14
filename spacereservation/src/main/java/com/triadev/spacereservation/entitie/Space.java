package com.triadev.spacereservation.entitie;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "COD_SPACE")
    private UUID cod;
    @Column(name = "NAME_SPACE")
    private String name;
    @Column(name = "ADRRESS")
    private String adrress;
    
}
