use ProductManagement;

DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS ProductType;
CREATE TABLE ProductType (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) DEFAULT NULL,
	description varchar(500) DEFAULT NULL
)AUTO_INCREMENT = 100;
CREATE TABLE Product (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) DEFAULT NULL,
	price double DEFAULT NULL,
	description varchar(500) DEFAULT NULL,
	status varchar(500) DEFAULT NULL,
	productType int(11) NOT NULL,
	FOREIGN KEY (productType)REFERENCES ProductType(id)
) AUTO_INCREMENT = 100;

CREATE TABLE Admin (
	id INT AUTO_INCREMENT PRIMARY KEY,
	firtName varchar(100) DEFAULT NULL,
	lastName varchar(100) DEFAULT NULL,
	email varchar(100) DEFAULT NULL,
	phone varchar(100) DEFAULT NULL,
	status boolean DEFAULT true,
	username varchar(100) DEFAULT NULL,
	password varchar(100) DEFAULT NULL
) AUTO_INCREMENT = 100;


INSERT INTO Admin (firtName, lastName,email,phone,username,password) VALUES ('Hung','Nguyen','hung@gmail.com','0355243283','hung','12345');

INSERT INTO ProductType (name, description) VALUES ('SamSung','samsung moi nhat');
INSERT INTO ProductType (name, description) VALUES ('Apple','apple moi nhat');
INSERT INTO ProductType (name, description) VALUES ('Xaomi','xaomi moi nhat');
INSERT INTO Product (name, price,description,status,productType) VALUES ('SamSungGalaxy','1000000','samsung moi nhat','fullbox',100);
INSERT INTO Product (name, price,description,status,productType) VALUES ('AppleIphone12Promax','200000','apple moi nhat','fullbox',101);
INSERT INTO Product (name, price,description,status,productType) VALUES ('XaomiMi10','1000000','xaomi moi nhat','fullbox',102);

