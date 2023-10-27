INSERT INTO salons (salon_id, salon_name, salon_address, salon_phone, salon_open_days)
VALUES
    ('sa1', 'Bounce Hair Salon Cork', 'UNIT 4 Washington St, Centre, Cork, T12 XD93', '0214278982', '0011111'),
    ('sa2', 'Ikon Hair Cork', '42 Marlboro St, Centre, Cork, T12 V1YX', '0214274588', '1111111'),
    ('sa3', 'The Edge Hair Design', '1B Emmett Pl, Centre, Cork, T12 XN63', '0214222793', '0011100'),
    ('sa4', 'Kopper Hair Salon', '3 Half Moon St, Centre, Cork', '0214820692', '0111111'),
    ('sa5', 'Edit Hair Club', '36/37 MacCurtain Street, Victorian Quarter, Cork, T23 FW14', '0214518121', '1111111'),
    ('sa6', 'Edit Hair Club', '20 Shandon Street, Cork, T23 FW30', '0219999121', '1110011');


INSERT INTO stylists (stylist_id, stylist_name, stylist_phone, stylist_salary, salon_id)
VALUES
    ('st1', 'Andrew Kerr', '0834215015', 50000, 'sa4'),
    ('st2', 'Eric Graham', '3948294858', 23000, 'sa4'),
    ('st3', 'Fiona Walker', '8059374858', 80300, 'sa5'),
    ('st4', 'Jane Harris', '1774857384', 36000, 'sa3'),
    ('st5', 'Keith Bailey', '9384829492', 62800, 'sa1'),
    ('st6', 'Julia Sanderson', '0637285938', 44700, 'sa2'),
    ('st7', 'Victoria Clarkson', '0572928112', 29000, 'sa5'),
    ('st8', 'James North', '2940503929', 41100, 'sa2'),
    ('st9', 'Emma Newman', '0423394828', 30000, 'sa3'),
    ('st10', 'Jacob Duncan', '5030202003', 28600, 'sa4'),
    ('st11', 'Frankie Healy', '0834215015', 50000, 'sa5'),
    ('st12', 'Willow Roche', '3948294858', 23000, 'sa1'),
    ('st13', 'Mary Robinson', '0493829593', 25000, 'sa4'),
    ('st14', 'Cillian Brady', '0324928495', 30000, 'sa5'),
    ('st15', 'Max Roche', '8820304050', 74200, 'sa4'),
    ('st16', 'Noah Buckley', '0839294959', 18000, 'sa1'),
    ('st17', 'Ellie Sweeney', '0673738182', 60000, 'sa5'),
    ('st18', 'Lucas Kavanagh', '4939294969', 35000, 'sa1'),
    ('st19', 'Lara Mullan', '2003040506', 24000, 'sa3'),
    ('st20', 'Robyn Fitzgerald', '4467723467', 22000, 'sa2');
