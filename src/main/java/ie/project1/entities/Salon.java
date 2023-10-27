package ie.project1.entities;

import lombok.*;

//The salon data are name, address, phone number, and days open. A salon's name is not unique. Choose/create your own primary key.
//name may not be blank but does not have to be unique
//address may not be blank
//phone number may not be blank but no validation is required beyond this ( you would use regular expressions but I am not interested in those right now)
//days open (must be open at least 1 day per week)

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Salon {
    private String salonId; // unique
    private String salonName; // not blank, not unique
    private String salonAddress; // not blank
    private String salonPhone; // not blank, no validation is required
    private String salonOpenDays; // at least 1 day per week. e.g. string representing each day "MTWTFSS" so "0111110" might mean closed Monday and Sunday but open all other days.
}
