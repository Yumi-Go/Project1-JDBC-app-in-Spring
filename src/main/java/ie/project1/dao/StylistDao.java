package ie.project1.dao;

import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.entities.Salon;
import ie.project1.entities.Stylist;

import java.util.List;
import java.util.Optional;


public interface StylistDao {

    // Get all stylists in a particular salon.
    List<Stylist> findAllBySalon(int salonId);

    // Add a stylist, ensuring you add them to a salon.
    void create(Stylist stylist);

    Optional<Stylist> findById(int id);

    // Move a stylist from one salon to another.
    boolean updateSalon(int id, int newSalonId);

    // Delete a stylist.
    boolean deleteById(int id);

    // to get average salary in particular salon in service layer
    int getSalaryBySalon(int salonId);

    //Get all stylists along with the name of the salon for which they work - use a record.
    List<StylistWithSalon> findAllWithSalon();
}
