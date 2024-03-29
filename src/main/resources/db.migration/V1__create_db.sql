CREATE TABLE client (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR NOT NULL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE planet (
    id VARCHAR PRIMARY KEY CONSTRAINT chk_id CHECK (id ~ '^[A-Z0-9]+$'),
    name VARCHAR NOT NULL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE ticket (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INTEGER,
    from_planet_id VARCHAR,
    to_planet_id VARCHAR,
     FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
     FOREIGN KEY (from_planet_id) REFERENCES planet(id) ON DELETE CASCADE,
     FOREIGN KEY (to_planet_id) REFERENCES planet(id) ON DELETE CASCADE
);