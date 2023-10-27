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
    int count();

    List<Stylist> findAllBySalon(String salonId) throws SalonNotFoundException;

    Stylist add(Stylist stylist) throws StylistMalformedException, StylistIdAlreadyExists, SalonNotFoundException;

    Stylist findById(String id) throws StylistNotFoundException;

    boolean updateSalon(String newSalonId, String id) throws SalonNotFoundException, StylistNotFoundException;

    void deleteById(String id) throws StylistNotFoundException;

    int getSalaryBySalon(String salonId) throws SalonNotFoundException ;

    List<StylistWithSalon> findAllWithSalon();
}

