DROP DATABASE IF EXISTS component_service;

CREATE DATABASE component_service;

USE component_service;

CREATE TABLE technicians(
	technic_id SMALLINT(4) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
	first_name VARCHAR(50) NOT NULL,
	middle_name VARCHAR(50) NULL,
	last_name VARCHAR(50) NOT NULL,
	is_available ENUM('Y','N') NOT NULL DEFAULT 'Y',
	tel_num VARCHAR(30) NOT NULL,  
	email VARCHAR(50) NULL,
	num_of_repaired SMALLINT UNSIGNED NULL,
	num_of_being_repaired TINYINT(2) UNSIGNED NULL
	)ENGINE = InnoDB;

CREATE TABLE clients(
	client_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	tel_num VARCHAR(30) NOT NULL
	)ENGINE = InnoDB;
	
CREATE TABLE components(
	order_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	type VARCHAR(255) NOT NULL,
	model VARCHAR(255) NOT NULL,
	order_price FLOAT(4,2) UNSIGNED NULL,
	diagnostic_results TEXT NULL,
	status ENUM('not_started','in_progress','ready') NOT NULL DEFAULT 'not_started',
	entry_date DATE	NOT NULL, 
	ready_date DATE NULL,
	client_id INT UNSIGNED NOT NULL,
	FOREIGN KEY(client_id) 
		REFERENCES clients(client_id)
		ON DELETE CASCADE,
	technic_id SMALLINT(4) UNSIGNED NULL,
	FOREIGN KEY (technic_id)
		REFERENCES technicians(technic_id)
		ON DELETE SET NULL
		)ENGINE = InnoDB;

CREATE TABLE parts(
	part_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	quantity SMALLINT UNSIGNED NULL,
	price_per FLOAT(7,2) UNSIGNED NULL
	)ENGINE = InnoDB;
		
CREATE TABLE replaced_components_parts(
	comp_id INT UNSIGNED NOT NULL,
	part_id INT UNSIGNED NOT NULL,
	qty SMALLINT UNSIGNED NOT NULL,
	UNIQUE(comp_id,part_id),
	FOREIGN KEY(comp_id)
		REFERENCES components(order_id)
		ON DELETE CASCADE,
	FOREIGN KEY(part_id)
		REFERENCES parts(part_id)
		ON DELETE CASCADE
	)ENGINE = InnoDB;
		

		
		--INSERTS
INSERT INTO technicians(first_name,middle_name,last_name,tel_num)
	VALUES('Georgi','Valentinov','Chelenkov','+359 89 23 43 999'),
		  ('Ivan','Draganov','Petkov','+359 11 23 43 222');
INSERT INTO technicians(first_name,last_name,email,tel_num)
	VALUES('Gencho','Hadjigenchov','ghadjigenchov@gmail.com','089 25 32 123'),
		  ('Petko','Baipetkov','baipetko@abv.bg','087 25 32 777');
		  
INSERT INTO clients(first_name,last_name,tel_num)
	VALUES('Ahmed','Dogan','00 245 913'),
		  ('Sergei','Stanishev','956 4040'),
		  ('Boiko','Borisov','1234'),
		  ('Nikolay','Barekov','048 155 11'),
		  ('Meglena','Kuneva','386 115');
	
INSERT INTO parts(name,quantity,price_per)
	VALUES('Air flow filter K&N',3,78.99),
		  ('DDR 2 RAM Memory 4GB',250,50),
		  ('Wireless mouse 3200 DPI Razer Naga',NULL,250), 
		  ('Screwdriver Jewish Star',327,NULL), 
		  ('LED DISPLAY 80 inches',2,500);
		  
INSERT INTO components(type,model,entry_date,client_id,technic_id)
	VALUES('Automobile','VW Polo 6n2 1998','2015-04-21 15:00:00',1,1),
		  ('TV','Panasonic Viera QRE2341','2015-04-20 18:30:00',2,1),
		  ('Avtomobil','VW Polo 6n2 1998','2015-04-21 15:00:00',3,2),
		  ('PC','Lenovo ZR 2337','2015-04-15 17:25:00',2,1),
		  ('Air conditioner','Daikin ULTIMA+','2015-03-30 10:45:00',4,3);

/* INSERT INTO replaced_components_parts(comp_id,part_id,qty)
	VALUES(1,2,4),
		  (2,4,1),
		  (2,5,150),
		  (3,1,50),
		  (4,2,20),
		  (4,3,10),
		  (5,1,1); */
		  
DELIMITER |
CREATE PROCEDURE add_technician(IN first VARCHAR(50),IN middle VARCHAR(50),IN last VARCHAR(50),
								IN tel VARCHAR(30),IN email VARCHAR(50)  )
	BEGIN
		IF first IS NULL OR first = ' '
			THEN SELECT "Invalid first name!" AS result;
			ELSE
				IF last IS NULL OR last = ' '
					THEN SELECT "Invalid last name!" AS result;
					ELSE
						IF tel IS NULL OR tel = ' '
							THEN SELECT "Invalid tel number!" AS result;
							ELSE
								IF EXISTS(SELECT * FROM technicians WHERE first_name = first AND last_name = last AND
																			tel_num = tel)
									THEN SELECT "Technician already exists!" AS result, "His Personal number is:" AS statement,
												technic_id AS id FROM technicians WHERE technicians.first_name = first AND
																					technicians.middle_name = middle AND
																					technicians.last_name = last AND
																					technicians.tel_num = tel AND
																					technicians.email = email;
									ELSE
										INSERT INTO technicians (first_name,middle_name,last_name,tel_num,email)
										VALUES(first,middle,last,tel,email);
										SELECT "Technician added successfully!" AS result,"His personal number is:" AS statement
										,technic_id AS id FROM technicians WHERE technicians.first_name = first AND
																					technicians.middle_name = middle AND
																					technicians.last_name = last AND
																					technicians.tel_num = tel AND
																					technicians.email = email;
								END IF;
						END IF;
				END IF;
		END IF;
	END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE add_client(IN first VARCHAR(50),IN last VARCHAR(50),
								IN tel VARCHAR(30))
	BEGIN
		IF first IS NULL OR first = ' '
			THEN SELECT "Invalid first name!" AS result;
			ELSE
				IF last IS NULL OR last = ' '
					THEN SELECT "Invalid last name!" AS result;
					ELSE
						IF tel IS NULL OR tel = ' '
							THEN SELECT "Invalid tel number!" AS result;
							ELSE
								IF EXISTS(SELECT * FROM clients WHERE first_name = first AND last_name = last AND
																			tel_num = tel)
									THEN SELECT "Client already exists!" AS result, "His Personal number is:" AS statement,
												client_id AS id FROM clients WHERE clients.first_name = first AND
																					clients.last_name = last AND
																					clients.tel_num = tel;
									ELSE
										INSERT INTO clients (first_name,last_name,tel_num)
										VALUES(first,last,tel);
										SELECT "Client added successfully!" AS result,"His personal number is:" AS statement
										,client_id AS id FROM clients WHERE clients.first_name = first AND
																					clients.last_name = last AND
																					clients.tel_num = tel;
								END IF;
						END IF;
				END IF;
		END IF;
	END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE create_order(IN comp_type VARCHAR(255),IN comp_model VARCHAR(255),
								IN client_id INT, IN technic_id SMALLINT(4), IN entry_date DATE)
	BEGIN
		IF comp_type IS NULL OR comp_type = ' ' OR comp_type = ''
			THEN SELECT "Invalid component type!" AS result;
			ELSE
				IF comp_model IS NULL OR comp_model = ' ' OR comp_model = ''
					THEN SELECT "Invalid component model!" AS result;
					ELSE
						IF entry_date IS NULL OR entry_date = ' ' OR entry_date =''
							THEN SELECT "Invalid entry date!" AS result;
							ELSE
								IF EXISTS(SELECT * FROM components WHERE components.type = comp_type AND components.model = comp_model AND
																			components.technic_id = technic_id AND components.client_id = client_id AND
																			components.entry_date = entry_date)
									THEN SELECT CONCAT("This component is already being repaired!
													  Order number is: ",(SELECT order_id FROM components WHERE 
																				components.type = comp_type AND
																				components.model = comp_model AND
																				components.technic_id = technic_id AND
																				components.client_id = client_id AND
																				components.entry_date = entry_date)) AS result;
									ELSE
										INSERT INTO components (type,model,entry_date,client_id,technic_id)
										VALUES(comp_type,comp_model,entry_date,client_id,technic_id);
										SELECT CONCAT("Component prepared for repairing successfully!
													  Order number is: ",(SELECT order_id FROM components WHERE 
																				components.type = comp_type AND
																				components.model = comp_model AND
																				components.technic_id = technic_id AND
																				components.client_id = client_id AND
																				components.entry_date = entry_date)) AS result;
								END IF;
						END IF;
				END IF;
		END IF;
	END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE component_info(IN id INT)
	BEGIN
		SELECT components.order_id AS id, components.type AS type, components.model AS model,
			   components.entry_date AS entry, components.ready_date AS ready, clients.first_name AS first_name,
			   clients.last_name AS last_name, clients.tel_num AS tel, components.status AS status,
			   components.order_price AS price, components.diagnostic_results AS result FROM components
					JOIN clients
						ON components.client_id = clients.client_id
				WHERE components.order_id = id;
	END
	|
DELIMITER ;
DELIMITER |
CREATE PROCEDURE component_parts_info(IN id INT)
	BEGIN
		SELECT 
			   components.ready_date AS ready,
			   components.status AS status,
			   components.order_price AS price,
			   components.diagnostic_results AS result
			   FROM components
				WHERE components.order_id = id;
	END
	|
DELIMITER ;


																		 
		

	
	