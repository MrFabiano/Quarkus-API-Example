DROP TABLE IF EXISTS Fruta;
DROP SEQUENCE IF EXISTS fruta_seq;

CREATE SEQUENCE fruta_seq START 1;

CREATE TABLE Fruta (
    id BIGINT NOT NULL DEFAULT nextval('fruta_seq'),
    nome VARCHAR(255),
    qtd INTEGER,
    PRIMARY KEY (id)
);

INSERT INTO Fruta (id, nome, qtd) VALUES (nextval('fruta_seq'), 'Maca', 3);
INSERT INTO Fruta (id, nome, qtd) VALUES (nextval('fruta_seq'), 'Pera', 5);
INSERT INTO Fruta (id, nome, qtd) VALUES (nextval('fruta_seq'), 'Uva', 4);

--CREATE SEQUENCE hibernate_sequence;
--insert into Fruta(id, nome, qtd) values (nextval('hibernate_sequence'), 'Maca', 3);
--insert into Fruta(id, nome, qtd) values (nextval('hibernate_sequence'), 'Pera', 5);
--insert into Fruta(id, nome, qtd) values (nextval('hibernate_sequence'), 'Uva', 4);