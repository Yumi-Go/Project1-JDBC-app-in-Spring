package ie.project1.dao.dto;


//Get all stylists along with the name of the salon for which they work - use a record.


//private int stylistId; // unique
//private String stylistName; // not blank, not unique
//private String stylistPhone; // can be blank
//private int stylistSalary; // positive number
public record StylistWithSalon(
        String stylistId,
        String stylistName,
        String stylistPhone,
        int stylistSalary,
        String salonName
) {}
