package com.triadev.spacereservation.entitie;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "COD_PARTICIPANT")
    private UUID cod;
    @Column(name = "NAME_PARTICIPANT", nullable = false, length = 150)
    private String name;
    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FONE", nullable = false)
    private String fone;
    @ManyToOne
    @JoinColumn(name = "COD_ASSOCIATION")
    private Association association;

    
}
