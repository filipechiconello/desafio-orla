CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    document VARCHAR(11),
    email VARCHAR(255),
    salary DECIMAL(19, 2)
);

INSERT INTO employee (id,document,email,salary) VALUES
(1,'12345678901','email@email.com.br','2000.00'),
(2,'09876543212','email2@email.com.br','2000.50');