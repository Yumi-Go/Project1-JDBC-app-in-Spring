package ie.project1.dao;

import ie.project1.entities.Salon;

import java.util.List;
import java.util.Optional;


public interface SalonDao {

    // Get all salons.
    List<Salon> getAll();

    // Create a new salon providing all data and return this new salon (from service layer).
    void save(Salon salon);

    // Get all salons by name e.g. all salons called "Hair Today".
    List<Salon> findAllByName(String name);

    // Get a salon by its primary key.
    Optional<Salon> findById(String id);

    // Update salon by modifying the days on which it is open
    boolean editOpenDays(String newOpenDays, String id);

    // Delete a salon and all that salon's stylists.
    boolean deleteById(String id);

    // List all those salons open 7 days a week.
    List<Salon> findAllDaysOpen();
}
