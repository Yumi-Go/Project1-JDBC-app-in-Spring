package ie.project1.entities;


import lombok.*;

//The staff data are their name, personal phone number, and annual salary. A stylist's name is not unique. Choose/create your own primary key.
//name may not be blank
//phone number may be blank
//annual salary must be a positive number

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stylist {
    private String stylistId; // unique
    private String stylistName; // not blank, not unique
    private String stylistPhone; // can be blank
    private int stylistSalary; // positive number
    private String salonId; // foreign key
}
