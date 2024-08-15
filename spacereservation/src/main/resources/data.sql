/*-- Inserindo Espaços
INSERT INTO SPACE (COD_SPACE, NAME_SPACE) VALUES ("b0a1f8c3-4d5b-4b5f-9d67-1b4b9b4d5c6a", "Espaco A");
INSERT INTO SPACE (COD_SPACE, NAME_SPACE) VALUES ("b7e9f3a2-1234-5678-90ab-cdef12345678", "Espaco B");
INSERT INTO SPACE (COD_SPACE, NAME_SPACE) VALUES ("2d6a7b8c-9e01-2345-6789-abcdef123456", "Espaco C");

-- Inserindo Participantes
INSERT INTO participant (COD_PARTICIPANT, NAME_PARTICIPANT) VALUES ('bb1f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a', 'Maria Silva');
INSERT INTO participant (COD_PARTICIPANT, NAME_PARTICIPANT) VALUES ('bba9f3a2-1234-5678-90ab-cdef12345678', 'João Souza');
INSERT INTO participant (COD_PARTICIPANT, NAME_PARTICIPANT) VALUES ('2e5a7b8c-9e01-2345-6789-abcdef123456', 'Ana Costa');
INSERT INTO participant (COD_PARTICIPANT, NAME_PARTICIPANT) VALUES ('de6a7b8c-9e01-2345-6789-abcdef123456', 'Carlos Pereira');
INSERT INTO participant (COD_PARTICIPANT, NAME_PARTICIPANT) VALUES ('ff7b7b8c-9e01-2345-6789-abcdef123456', 'Luiza Ramos');

-- Inserindo Associações
INSERT INTO association (COD_ASSOCIATION, NAME_ASSOCIATION, RESPONSABLE) VALUES ('ac9f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a', 'Associação Esportiva A', 'bb1f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a');
INSERT INTO association (COD_ASSOCIATION, NAME_ASSOCIATION, RESPONSABLE) VALUES ('de4f3a24-1234-5678-90ab-cdef12345678', 'Clube Recreativo B', 'bba9f3a2-1234-5678-90ab-cdef12345678');

-- Inserindo Participantes nas Associações
INSERT INTO association_participants (association_id, participant_id) VALUES ('ac9f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a', '2e5a7b8c-9e01-2345-6789-abcdef123456'); -- Ana Costa
INSERT INTO association_participants (association_id, participant_id) VALUES ('ac9f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a', 'de6a7b8c-9e01-2345-6789-abcdef123456'); -- Carlos Pereira
INSERT INTO association_participants (association_id, participant_id) VALUES ('de4f3a24-1234-5678-90ab-cdef12345678', 'ff7b7b8c-9e01-2345-6789-abcdef123456'); -- Luiza Ramos

-- Inserindo Reservas
INSERT INTO reservation (id, association_id, space_id, day_of_week, start_time) VALUES ('1f3a24de-1234-5678-90ab-cdef12345678', 'ac9f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a', 'b0a1f8c3-4d5b-4b5f-9d67-1b4b9b4d5c6a', 1, '12:00:00'); -- Segunda-feira, 12:00, Espaço A
INSERT INTO reservation (id, association_id, space_id, day_of_week, start_time) VALUES ('2f5b24de-1234-5678-90ab-cdef12345678', 'ac9f8c34-9d5b-4b5f-9d67-1b4b9b4d5c6a', 'b7e9f3a2-1234-5678-90ab-cdef12345678', 3, '14:00:00'); -- Quarta-feira, 14:00, Espaço B
INSERT INTO reservation (id, association_id, space_id, day_of_week, start_time) VALUES ('3e6c24de-1234-5678-90ab-cdef12345678', 'de4f3a24-1234-5678-90ab-cdef12345678', 'b0a1f8c3-4d5b-4b5f-9d67-1b4b9b4d5c6a', 5, '16:00:00'); -- Sexta-feira, 16:00, Espaço A
 */