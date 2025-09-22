
CREATE TABLE person (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT CHECK (age >= 0),
    email VARCHAR(150) UNIQUE NOT NULL
);

INSERT INTO person (username, name, age, email) VALUES
('juan123', 'Juan Pérez', 28, 'juan@example.com'),
('sofia99', 'Sofía Gómez', 26, 'sofia@example.com'),
('danielx', 'Daniel Ruiz', 29, 'daniel@example.com'),
('carlos45', 'Carlos López', 30, 'carlos@example.com');