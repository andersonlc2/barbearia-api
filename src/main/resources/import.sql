INSERT INTO tb_equipe (id, lider, nome) VALUES (nextval('EQUIPE_SEQ'), 'Maria', 'Equipe11');
INSERT INTO tb_equipe (id, lider, nome) VALUES (nextval('EQUIPE_SEQ'), 'Joao', 'Equipe01');
INSERT INTO tb_equipe (id, lider, nome) VALUES (nextval('EQUIPE_SEQ'), 'Pedro', 'Equipe05');

INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:00');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:05');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:10');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:15');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:20');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:25');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:30');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:35');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:40');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:45');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:50');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 09:55');
INSERT INTO tb_horario VALUES (nextval('HORARIO_SEQ'), '2022-04-01 10:00');



INSERT INTO tb_barbeiro VALUES (nextval('BARBEIRO_SEQ'), true,'2022-04-03','afonso@gmail.com','Rua Qualr, qd 16 lt 344 Santa Maria', 'Afonso Ciriaco', '134545', 1);
INSERT INTO tb_barbeiro VALUES (nextval('BARBEIRO_SEQ'), true,'2022-04-15','anderson@gmail.com','Rua Pedro Ludovico, qd 23 lt 5 Canedo', 'Anderson Correia', 'asdfasdf', 1);
INSERT INTO tb_barbeiro VALUES (nextval('BARBEIRO_SEQ'), true,'2022-04-16','airton@gmail.com','Rua Semn, qd 34 lt 2 Res Buriti', 'Airton Senna', '23412@34', 2);
INSERT INTO tb_barbeiro VALUES (nextval('BARBEIRO_SEQ'), true,'2022-04-30','pedro@gmail.com','Rua Kamasi, qd 6 lt 21 Agua Santa', 'Pedro Primeiro', '24444443', 2);
INSERT INTO tb_barbeiro VALUES (nextval('BARBEIRO_SEQ'), true,'2022-04-08','usman@gmail.com','Rua Sabe, qd 23 lt 21 Santarem', 'Usman Tmson', '123123', 1);

INSERT INTO tb_horario_barbeiro VALUES (1, 1, 10001);
INSERT INTO tb_horario_barbeiro VALUES (1, 2, 10001);
INSERT INTO tb_horario_barbeiro VALUES (1, 3, 10001);
INSERT INTO tb_horario_barbeiro VALUES (1, 4, 10001);
INSERT INTO tb_horario_barbeiro VALUES (1, 5, 10001);
INSERT INTO tb_horario_barbeiro VALUES (1, 6, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 7, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 8, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 9, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 10, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 11, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 12, 10001);
INSERT INTO tb_horario_barbeiro VALUES (3, 13, 10001);

INSERT INTO tb_horario_barbeiro VALUES (2, 1, 10000);
INSERT INTO tb_horario_barbeiro VALUES (2, 2, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 3, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 4, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 5, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 6, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 7, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 8, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 9, 10000);
INSERT INTO tb_horario_barbeiro VALUES (1, 10, 10000);
INSERT INTO tb_horario_barbeiro VALUES (2, 11, 10000);
INSERT INTO tb_horario_barbeiro VALUES (2, 12, 10000);
INSERT INTO tb_horario_barbeiro VALUES (2, 13, 10000);

INSERT INTO tb_categoria VALUES (nextval('CATEGORIA_SEQ'), 'FIDELIDADE');
INSERT INTO tb_categoria VALUES (nextval('CATEGORIA_SEQ'),'MENSAL');
INSERT INTO tb_categoria VALUES (nextval('CATEGORIA_SEQ'),'EVENTUAL');


INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'rogerio@gmail.com', 'Rogerio Ceni', '1234567', '21 998458898', 1);
INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'pablo@gmail.com', 'Pablo Maia', '123423567', '21 955458851', 1);
INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'arboleta@gmail.com', 'Arboleda', '1234567', '21 988458892', 1);
INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'pedro@gmail.com', 'Pedro Miranda', '1234567', '21 928458899', 1);
INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'tevez@gmail.com', 'Carlitos Tevez', '1234567', '21 988458854', 1);
INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'marcos@gmail.com', 'Marcos Cunha', '1234567', '21 991458822', 1);
INSERT INTO tb_cliente VALUES (nextval('CLIENTE_SEQ'), '2022-04-03', 'marcelo@gmail.com', 'Marclo Paraguai', '1234567', '21 948458892', 1);






