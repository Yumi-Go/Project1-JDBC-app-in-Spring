package ie.project1.service;

import ie.project1.entities.Salon;
import ie.project1.service.exceptions.SalonIdAlreadyExists;
import ie.project1.service.exceptions.SalonMalformedException;
import ie.project1.service.exceptions.SalonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SalonService {
    List<Salon> getAll();

    void create(Salon salon) throws SalonMalformedException, SalonIdAlreadyExists;;

    List<Salon> findByName(String name);

    Salon findById(int id) throws SalonNotFoundException;

    boolean editOpenDays(String newOpenDays, int id);

    void deleteById(int id) throws SalonNotFoundException;

    List<Salon> findAllDaysOpen();
}
