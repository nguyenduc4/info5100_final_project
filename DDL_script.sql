-- show databases;
-- 
-- -- CREATE DATABASE 
-- CREATE DATABASE hotel_management_final_project;
USE hotel_management_final_project;	-- Tells to use explicit database 

DROP TABLE Reservation;


-- CREATE TABLE
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_num VARCHAR(20),
    role ENUM('Customer', 'Receptionist', 'Staff', 'Admin') NOT NULL
);

CREATE TABLE Hotel ( 
	hotel_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	addredd VARCHAR(255),
	phone_num VARCHAR(10)
);

CREATE TABLE Room ( 
	room_id INT AUTO_INCREMENT PRIMARY KEY,
	hotel_id INT,
	name VARCHAR(255),
	type ENUM('SINGLE', 'DOUBLE', 'FAMILY'),
	status ENUM('AVAILABLE', 'OCCUPIED', 'CLEANING'),
	price FLOAT NOT NULL
);

CREATE TABLE Reservation (
	reservation_id INT AUTO_INCREMENT PRIMARY KEY,
	hotel_id INT ,
	user_id INT,
	room_id INT,
	payment_id INT,
	confirm BOOLEAN,
	check_in_date DATE NOT NULL,
	check_out_date DATE NOT NULL,
	reservation_amount FLOAT NOT NULL,
	status NUM('Empty', 'Wait Comfirm', 'Unpaid', 'Reserved', 'Checked in', 'Unclean')
);

CREATE TABLE Payment (
	payment_ID INT AUTO_INCREMENT PRIMARY KEY,
	payment_status BOOLEAN NOT NULL,
	payment_method ENUM('CREDIT_CARD', 'CASH', 'ONLINE') NOT NULL,
	amount FLOAT NOT NULL,
	date DATE NOT NULL
);

CREATE TABLE Task(
	task_id INT AUTO_INCREMENT PRIMARY KEY,
	assigned_id INT,
	descripiton TEXT NOT NULL,
	status ENUM ('PENDING', 'IN_PROGRESS', 'COMPLETE') NOT NULL,
	created_at DATE,
	due_at DATETIME GENERATED ALWAYS AS (DATE_ADD(created_at, INTERVAL 3 HOUR)) VIRTUAL
);

CREATE TABLE Advertisement(
	ad_id INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(255),
	content TEXT ,
	created_by INT,
	created_at DATE
);

-- ADD FOREIGN KEY
ALTER TABLE Room ADD CONSTRAINT ROOM_HOTELID_FK FOREIGN KEY (hotel_id) REFERENCES Hotel(hotel_id);
ALTER TABLE Reservation ADD CONSTRAINT RESERVATION_HOTELID_FK FOREIGN KEY (hotel_id) REFERENCES Hotel(hotel_id);
ALTER TABLE Reservation ADD CONSTRAINT RESERVATION_USERID_FK FOREIGN KEY (user_id) REFERENCES User(user_id);
ALTER TABLE Reservation ADD CONSTRAINT RESERVATION_ROOMID_FK FOREIGN KEY (room_id) REFERENCES Room(room_id);
ALTER TABLE Reservation ADD CONSTRAINT RESERVATION_PAYMENTID_FK FOREIGN KEY (payment_id) REFERENCES Payment(payment_id);
ALTER TABLE Task ADD CONSTRAINT Task_ASSIGNID_FK FOREIGN KEY (assigned_id) REFERENCES User(user_id);
ALTER TABLE Advertisement ADD CONSTRAINT Advertisement_CREATEID_FK FOREIGN KEY (created_by) REFERENCES User(user_id);




