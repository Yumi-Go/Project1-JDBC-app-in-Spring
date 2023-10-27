package ie.project1.service;

import ie.project1.entities.Salon;
import ie.project1.service.exceptions.SalonIdAlreadyExists;
import ie.project1.service.exceptions.SalonMalformedException;
import ie.project1.service.exceptions.SalonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalonService {
    List<Salon> getAll();

    Salon add(Salon salon) throws SalonMalformedException, SalonIdAlreadyExists, SalonNotFoundException;

    List<Salon> findAllByName(String name) throws SalonNotFoundException;

    Salon findById(int id) throws SalonNotFoundException;

    boolean editOpenDays(String newOpenDays, int id) throws SalonMalformedException, SalonNotFoundException;

    void deleteById(int id) throws SalonNotFoundException;

    List<Salon> findAllDaysOpen();
}
