CREATE TABLE accident
(
    id serial primary key,
    name varchar(2000),
    text varchar(2000),
    address varchar(2000)
);

CREATE TABLE rule
(
    id serial primary key,
    name varchar(2000)
);

CREATE TABLE accidenttype
(
    id serial primary key,
    name varchar(2000)
);

INSERT INTO accident (id, name, text, address) VALUES (1, 'Игорь', 'Велосипедимст врезался в дверь', 'г.Москва ул.Центральная 1');
INSERT INTO accident (id, name, text, address) VALUES (2, 'Федр', 'Врезался головой в столб', 'г.Москва ул.Конечная 25');
INSERT INTO accident (id, name, text, address) VALUES (3, 'Генадий', 'Помял бампер', 'г.Москва ул.Старая 11');
INSERT INTO accident (id, name, text, address) VALUES (4, 'Елена', 'Врезалась в забор', 'г.Москва ул.Начальная 3');
INSERT INTO accident (id, name, text, address) VALUES (5, 'Клаудия', 'Задела забор', 'г.Москва ул.Люблинка 132');

INSERT INTO rule (id, name) VALUES (1, 'Статья. 1');
INSERT INTO rule (id, name) VALUES (2, 'Статья. 2');
INSERT INTO rule (id, name) VALUES (3, 'Статья. 3');

INSERT INTO accidenttype (id, name) VALUES (1, 'Две машины');
INSERT INTO accidenttype (id, name) VALUES (2, 'Машина и человек');
INSERT INTO accidenttype (id, name) VALUES (3, 'Машина и велосипед');