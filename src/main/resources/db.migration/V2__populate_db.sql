INSERT INTO client (name)
VALUES ('John'),
    ('Diana'),
    ('Bill'),
    ('Igor'),
    ('Josef'),
    ('Dima'),
    ('Bogdan'),
    ('Roma'),
    ('Viktoriya'),
    ('Vitaliy');

INSERT INTO planet (id, name)
VALUES ('MA1', 'Mars'),
    ('VEN2', 'Venera'),
    ('N3', 'Neptune'),
    ('JU4', 'Jupiter'),
    ('SA5', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES (1, 'MA1', 'JU4'),
(2,'MA1', 'JU4'),
(3,'MA1', 'VEN2'),
(4,'N3', 'VEN2'),
(5,'N3', 'JU4'),
(6,'SA5', 'VEN2'),
(7,'SA5', 'VEN2'),
(8,'SA5', 'JU4'),
(9,'MA1', 'N3'),
(10,'VEN2', 'SA5');
