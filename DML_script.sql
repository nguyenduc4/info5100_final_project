USE hotel_management_final_project;	-- Tells to use explicit database 

INSERT INTO Hotel (hotel_id, name, addredd , phone_num)
VALUES
(1, 'Sunset Inn', '123 Sunset Blvd, Toronto', '4161234567'),
(2, 'Mountain View Resort', '789 Alpine Rd, Vancouver', '6049876543'),
(3, 'Ocean Breeze Hotel', '456 Seaside Ave, Halifax', '9022345678'),
(4, 'Golden Horizon Suites', '321 Golden Rd, Calgary', '4033456789');


INSERT INTO Room (room_id, hotel_id, name, type, status, price)
VALUES
(1, 1, 'Room 101', 'SINGLE', 'Empty', 120.00),
(2, 1, 'Room 102', 'SINGLE', 'Empty', 120.00),
(3, 1, 'Room 201', 'DOUBLE', 'Empty', 180.00),
(4, 1, 'Room 202', 'DOUBLE', 'Empty', 180.00),
(5, 1, 'Suite 301', 'FAMILY', 'Empty', 250.00),
(6, 2, 'Room 101', 'SINGLE', 'Empty', 140.00),
(7, 2, 'Room 102', 'SINGLE', 'Empty', 140.00),
(8, 2, 'Room 201', 'DOUBLE', 'Empty', 200.00),
(9, 2, 'Room 202', 'DOUBLE', 'Empty', 200.00),
(10, 2, 'Suite 301', 'FAMILY', 'Empty', 280.00),
(11, 3, 'Room 101', 'SINGLE', 'Empty', 130.00),
(12, 3, 'Room 102', 'SINGLE', 'Empty', 130.00),
(13, 3, 'Room 201', 'DOUBLE', 'Empty', 190.00),
(14, 3, 'Room 202', 'DOUBLE', 'Empty', 190.00),
(15, 3, 'Suite 301', 'FAMILY', 'Empty', 260.00),
(16, 4, 'Room 101', 'SINGLE', 'Empty', 150.00),
(17, 4, 'Room 102', 'SINGLE', 'Empty', 150.00),
(18, 4, 'Room 201', 'DOUBLE', 'Empty', 220.00),
(19, 4, 'Room 202', 'DOUBLE', 'Empty', 220.00),
(20, 4, 'Suite 301', 'FAMILY', 'Empty', 300.00),
(21, 4, 'Suite 302', 'FAMILY', 'Empty', 320.00),
(22, 3, 'Room 203', 'DOUBLE', 'Empty', 195.00),
(23, 2, 'Room 103', 'SINGLE', 'Empty', 145.00),
(24, 1, 'Room 103', 'SINGLE', 'Empty', 125.00),
(25, 1, 'Room 104', 'SINGLE', 'Empty', 125.00);

INSERT INTO User (user_id, username, password, phone_num, role)
VALUES
(1, 'john_doe', 'password123', '416-789-1234', 'HotelStaff'),
(2, 'jane_smith', 'securepass', '604-234-5678', 'AgencyStaff'),
(3, 'alice_jones', 'mypassword', '902-567-8910', 'AgencyAdmin'),
(4, 'bob_brown', 'pass2024', '403-890-1234', 'HotelAdmin'),
(5, 'chris_lee', 'adminpass', '416-234-9876', 'AgencyStaff');

-- Insert Reservation 1
INSERT INTO Reservation (hotel_id, user_id, room_id, payment_id, confirm, check_in_date, check_out_date, reservation_amount, status)
VALUES
(1, 1, 1, False, False, '2024-12-10', '2024-12-15', 600.00,'Wait Confirm');

-- Insert Reservation 2
INSERT INTO Reservation (hotel_id, user_id, room_id, payment_id, confirm, check_in_date, check_out_date, reservation_amount, status)
VALUES
(2, 3, 8, False, False, '2024-12-20', '2024-12-25', 1000.00, 'Wait Confirm');
TRUNCATE table Reservation; 
select * from Reservation;
select * from Room;
UPDATE Room SET name = 'Room 101.1' WHERE room_id=

SELECT r2.room_id, r2.hotel_id, r2.name, r2.type, r2.status, r2.price , r.confirm FROM Reservation r 
	INNER JOIN Hotel h ON r.hotel_id = h.hotel_id 
	INNER JOIN Room r2 ON r.room_id = r2.room_id ;
