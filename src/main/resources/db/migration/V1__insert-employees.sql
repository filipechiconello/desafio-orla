CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    document INT,
    email VARCHAR(255),
    salary DECIMAL(19, 2)
);

INSERT INTO employee (id,document,email,salary) VALUES
(1,1233123,'email@email.com.br','2000.00'),
(2,3221321,'email2@email.com.br','2000.50');