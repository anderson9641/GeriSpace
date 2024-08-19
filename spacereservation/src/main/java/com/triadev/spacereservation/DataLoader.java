package com.triadev.spacereservation;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.Participants;
import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.entitie.Role;
import com.triadev.spacereservation.entitie.Space;
import com.triadev.spacereservation.entitie.Week;
import com.triadev.spacereservation.service.AssociationService;
import com.triadev.spacereservation.service.ParticipantService;
import com.triadev.spacereservation.service.ReservationService;
import com.triadev.spacereservation.service.SpaceService;

@Configuration
public class DataLoader {

    @Autowired
    private SpaceService spaceService;

    @Autowired
    private AssociationService associationService;

    @Autowired
    private ParticipantService participantsService;

    @Autowired
    private ReservationService reservationService;

    @Bean
    public ApplicationRunner loadData() {
        return args -> {
            // Criando e salvando um Space
            Space space = new Space();
            space.setName("Space A");
            space.setAdrress("123 Street");
            space.setStartOperation(LocalTime.of(8, 1, 1));
            space.setEndOperation(LocalTime.of(22, 14, 59));
            spaceService.createSpace(space);

             // Crie a associação 
             Association association = new Association();
             association.setName("Toque de bola");
             Association association2 = new Association();
             association2.setName("Bola Murcha");
             // Salve a associação
             Association newAssociation = associationService.createAssociation(association);
             associationService.createAssociation(association2);

            // Crie e salve o participante 
            Participants responsible = new Participants();
            responsible.setName("Olavo do santo");
            responsible.setCpf("12345678900");
            responsible.setEmail("responsavel@example.com");
            responsible.setFone("123456789");

            participantsService.createParticipant(responsible);          

            // Exemplo de membros a serem adicionados
            Participants member1 = new Participants();
            member1.setName("Joao ");
            member1.setCpf("12345678900");
            member1.setEmail("responsavel@example.com");
            member1.setFone("123456789");
            participantsService.createParticipant(member1);

            Participants member2 = new Participants();
            member2.setName("Carlos");
            member2.setCpf("12345678900");
            member2.setEmail("responsavel@example.com");
            member2.setFone("123456789");
            participantsService.createParticipant(member2);           

            // Adiciona os membros na Associação
            associationService.addMembersToAssociation(newAssociation.getCod(), responsible, Role.RESPONSIBLE);
            associationService.addMembersToAssociation(newAssociation.getCod(), member1, Role.MEMBER);
            associationService.addMembersToAssociation(newAssociation.getCod(), member2, Role.MEMBER);
            
            // Criando e salvando uma Reservation
            Reservation reservation = new Reservation();
            reservation.setAssociation(association);
            reservation.setSpace(space);
            reservation.setStartTime(LocalTime.of(10, 0));
            reservation.setEndTime(reservation.getHoraFim());
            reservation.setStartDate(LocalDate.of(2024, 8, 15));
            reservation.setEndDate(LocalDate.of(2024, 12, 31));
            reservation.setDayReservation(Week.SEGUNDA);
            reservationService.createReservation(reservation);
        };
    }
}
