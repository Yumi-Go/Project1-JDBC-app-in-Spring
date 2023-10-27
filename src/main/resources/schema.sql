

-- The salon data are name, address, phone number, and days open. A salon's name is not unique. Choose/create your own primary key.
-- name may not be blank but does not have to be unique
-- address may not be blank
-- phone number may not be blank but no validation is required beyond this ( you would use regular expressions but I am not interested in those right now)
-- days open (must be open at least 1 day per week)
-- There are several ways to handle how to store the days of the week on which the salon is open.
-- For example, you could have a string representing each day "MTWTFSS" so "0111110" might mean closed Monday and Sunday but open all other days.
CREATE TABLE salons (
    salon_id            INT PRIMARY KEY,
    salon_name          VARCHAR(255) NOT NULL,
    salon_address       VARCHAR(255) NOT NULL,
    salon_phone         VARCHAR(20) NOT NULL,
    salon_open_days     CHAR(7)
);

-- The staff data are their name, personal phone number, and annual salary. A stylist's name is not unique. Choose/create your own primary key.
-- name may not be blank
-- phone number may be blank
-- annual salary must be a positive number
CREATE TABLE stylists (
    stylist_id          INT PRIMARY KEY,
    stylist_name        VARCHAR(255) NOT NULL,
    stylist_phone       VARCHAR(20),
    stylist_salary      INT,
    salon_id            INT,
    FOREIGN KEY (salon_id) REFERENCES salons(salon_id) ON DELETE CASCADE
);