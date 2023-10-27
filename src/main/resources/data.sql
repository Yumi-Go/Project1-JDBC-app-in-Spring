INSERT INTO salons (salon_id, salon_name, salon_address, salon_phone, salon_open_days)
VALUES
    (1, 'Bounce Hair Salon Cork', 'UNIT 4 Washington St, Centre, Cork, T12 XD93', '0214278982', '0011111'),
    (2, 'Ikon Hair Cork', '42 Marlboro St, Centre, Cork, T12 V1YX', '0214274588', '1111100'),
    (3, 'The Edge Hair Design', '1B Emmett Pl, Centre, Cork, T12 XN63', '0214222793', '0011100'),
    (4, 'Kopper Hair Salon', '3 Half Moon St, Centre, Cork', '0214820692', '0111111'),
    (5, 'Edit Hair Club', '36/37 MacCurtain Street, Victorian Quarter, Cork, T23 FW14', '0214518121', '1111110'),
    (6, 'Sobe Brown', 'Morrison''s Quay, Centre, Cork, T12 H7NY', '0214222407', '1111000'),
    (7, 'Carbon Hair Design', '35 S Mall, Centre, Cork, T12 X211', '0214222898', '0001111'),
    (8, 'Darcys Hairdressing', '27-28 Paul St, Centre, Cork, T12 NX02', '0214277216', '0110000'),
    (9, 'Hair Passion Art Salon', '8 Cross St, Centre, Cork, T12 HT91', '0862463189', '1110000'),
    (10, 'Goldirocks Hair Salon', '3 Oliver Plunkett St, Centre, Cork, T12 W653', '(021) 427 9098', '1111111');




-- CREATE TABLE stylists (
--                           stylist_id          INT PRIMARY KEY,
--                           stylist_name        VARCHAR(255) NOT NULL,
--                           stylist_phone       VARCHAR(20),
--                           stylist_salary      INT



INSERT INTO stylists (stylist_id, stylist_name, stylist_phone, stylist_salary, salon_id)
VALUES
    (1, 'Andrew Kerr', '0834215015', 50000, 3),
    (2, 'Eric Graham', '3948294858', 23000, 8),
    (3, 'Fiona Walker', '8059374858', 80300, 2),
    (4, 'Jane Harris', '1774857384', 39000, 10),
    (5, 'Keith Bailey', '9384829492', 62800, 7),
    (6, 'Julia Sanderson', '0637285938', 44700, 4),
    (7, 'Victoria Clarkson', '0572928112', 29000, 6),
    (8, 'James North', '2940503929', 41100, 10),
    (9, 'Emma Newman', '0423394828', 33300, 8),
    (10, 'Jacob Duncan', '5030202003', 28600, 6),
    (11, 'Frankie Healy', '0834215015', 50000, 3),
    (12, 'Willow Roche', '3948294858', 23000, 8),
    (13, 'Mary Robinson', '0493829593', 25000, 2),
    (14, 'Cillian Brady', '0324928495', 30000, 10),
    (15, 'Max Roche', '8820304050', 74200, 7),
    (16, 'Noah Buckley', '0839294959', 18000, 4),
    (17, 'Ellie Sweeney', '0673738182', 60000, 6),
    (18, 'Lucas Kavanagh', '4939294969', 35000, 1),
    (19, 'Lara Mullan', '2003040506', 28700, 1),
    (20, 'Robyn Fitzgerald', '4467723467', 22000, 9),
    (21, 'Ella Hughes', '9395949394', 66500, 3),
    (22, 'Éabha Brady', '0659493050', 88000, 8),
    (23, 'Lily Bell', '0440503838', 54500, 2),
    (24, 'Mary OShea', '0219394859', 64000, 10),
    (25, 'Ollie Walsh', '5539293949', 44000, 7),
    (26, 'Alexander Griffin', '8382949596', 28200, 4),
    (27, 'Nina Brown', '0748374837', 31000, 6),
    (28, 'Cillian MacLaughlin', '0219296737', 56000, 1),
    (29, 'Sean Campbell', '0339495827', 32100, 7),
    (30, 'James Collins', '5938495857', 27500, 2);
