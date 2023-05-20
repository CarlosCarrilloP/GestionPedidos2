/*SQL para crear la base de datos gestionpedidos*/
create database gestionpedidos;
USE gestionpedidos;
CREATE TABLE producto(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    precio DOUBLE,
    cantidad INT,
    stock INT,
    PRIMARY KEY (id)
);
CREATE TABLE cliente(
	nombre VARCHAR(45),
	apellidos VARCHAR(45),
	telefono VARCHAR(9) not null PRIMARY KEY,
	direccion varCHAR(45)
	
);
CREATE TABLE pedido (
    id INT AUTO_INCREMENT,
    cliente_id CHAR(11),
    producto1_id INT,
    producto2_id INT,
    importe_total DOUBLE,
    pasarela_pago VARCHAR(255),
    estado VARCHAR(255),
    codigo_pedido VARCHAR(255),
    ruta_ticket VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(telefono),
    FOREIGN KEY (producto1_id) REFERENCES producto(id),
    FOREIGN KEY (producto2_id) REFERENCES producto(id)
);
create table ticket(
id INT AUTO_INCREMENT PRIMARY KEY,
  ticket_resume varchar(800)
);

INSERT INTO cliente (nombre, apellidos, telefono, direccion)
VALUES
    ('Juan', 'Perez', '666666666', 'Calle 1 Benferri'),
    ('María', 'García', '777777777', 'Calle 2 Orihuela'),
    ('Pedro', 'Martinez', '888888888', 'Calle 3 Rojales');
INSERT INTO producto (nombre, precio, cantidad, stock)
VALUES
   ('Camiseta', 29.99, 0,30),
('Zapatos', 59.99, 0,30),
('Sombrero', 10, 0,30),
('Bufanda', 5, 0,30),
('Gorra', 14.50, 0,30);

select * from cliente;
select * from producto;
select * from ticket;
