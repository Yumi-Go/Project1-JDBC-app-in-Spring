package ie.project1.service;

import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.entities.Salon;
import ie.project1.entities.Stylist;
import ie.project1.service.exceptions.SalonNotFoundException;
import ie.project1.service.exceptions.StylistIdAlreadyExists;
import ie.project1.service.exceptions.StylistMalformedException;
import ie.project1.service.exceptions.StylistNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StylistService {
    List<Stylist> findAllBySalon(int salonId) throws SalonNotFoundException;

    Stylist add(Stylist stylist) throws StylistMalformedException, StylistIdAlreadyExists, SalonNotFoundException;

    Stylist findById(int id) throws StylistNotFoundException;

    boolean updateSalon(int id, int newSalonId) throws StylistNotFoundException, SalonNotFoundException;

    void deleteById(int id) throws StylistNotFoundException;

    int getSalaryBySalon(int salonId) throws SalonNotFoundException ;

    List<StylistWithSalon> findAllWithSalon();
}

