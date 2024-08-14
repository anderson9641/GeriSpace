package com.triadev.spacereservation.entitie;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "COD_ASSOCIATION")
    private UUID cod;
    @Column(name = "NAME_ASSOCIATION", nullable = false, length = 100)
    private String name;
    @OneToOne
    @PrimaryKeyJoinColumn(referencedColumnName = "COD_PARTICIPANT",name = "RESPONSIBLE")
    private Participants responsible;
    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "MEMBERS")
    private List<Participants> members;
}
