package ie.project1.dao;

import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.entities.Salon;
import ie.project1.entities.Stylist;

import java.util.List;
import java.util.Optional;


public interface StylistDao {

    int count();

    // Get all stylists in a particular salon.
    List<Stylist> findAllBySalon(String salonId);

    // Add a stylist, ensuring you add them to a salon.
    void save(Stylist stylist);

    Optional<Stylist> findById(String id);

    // Move a stylist from one salon to another.
    boolean updateSalon(String newSalonId, String id);

    // Delete a stylist.
    boolean deleteById(String id);

    // to get average salary in particular salon in service layer
    int getSalaryBySalon(String salonId);

    //Get all stylists along with the name of the salon for which they work - use a record.
    List<StylistWithSalon> findAllWithSalon();
}
