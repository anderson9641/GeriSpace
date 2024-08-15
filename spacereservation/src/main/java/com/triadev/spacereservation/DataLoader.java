package com.triadev.spacereservation;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.Participants;
import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.entitie.Space;
import com.triadev.spacereservation.repository.AssociationRepository;
import com.triadev.spacereservation.repository.ParticipantsRepository;
import com.triadev.spacereservation.repository.ReservationRepository;
import com.triadev.spacereservation.repository.SpaceRepository;
import com.triadev.spacereservation.service.AssociationService;
import com.triadev.spacereservation.service.ParticipantService;
import com.triadev.spacereservation.service.ReservationService;
import com.triadev.spacereservation.service.SpaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

            // Crie e salve o participante responsável
            Participants responsible = new Participants();
            responsible.setName("Olavo do santo");
            responsible.setCpf("12345678900");
            responsible.setEmail("responsavel@example.com");
            responsible.setFone("123456789");
            // Salva o participante responsável
            responsible = participantsService.createParticipant(responsible);

            // Crie a associação e defina o responsável
            Association association = new Association();
            association.setName("Toque de bola");
            association.setResponsible(responsible);

            // Salve a associação
            Association newAssociation = associationService.createAssociation(association);

             // Adiciona o responsável a lista de membros
             responsible.setAssociation(association);
             System.out.println(responsible.getCod()+" "+responsible.getAssociation().getName());
             participantsService.updateParticipant(responsible.getCod(), responsible);
 

            // Exemplo de membros a serem adicionados
            Participants member1 = new Participants();
            member1.setName("Joao ");
            member1.setCpf("12345678900");
            member1.setEmail("responsavel@example.com");
            member1.setFone("123456789");

            Participants member2 = new Participants();
            member2.setName("Carlos");
            member2.setCpf("12345678900");
            member2.setEmail("responsavel@example.com");
            member2.setFone("123456789");

            List<Participants> newMembers = new ArrayList<>();
            newMembers.add(member1);
            newMembers.add(member2);

            // ID da associação onde os membros serão adicionados
            UUID associationId = newAssociation.getCod();

            associationService.addMembersToAssociation(associationId, newMembers);

            

            // Criando e salvando uma Reservation
            Reservation reservation = new Reservation();
            reservation.setAssociation(association);
            reservation.setSpace(space);
            reservation.setStartTime(LocalTime.of(10, 0));
            reservation.setEndTime(reservation.getHoraFim());
            reservation.setStartDate(LocalDate.of(2024, 8, 15));
            reservation.setEndDate(LocalDate.of(2024, 12, 31));
            reservationService.createReservation(reservation);
        };
    }
}
