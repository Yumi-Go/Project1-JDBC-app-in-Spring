package ie.project1.service;

import ie.project1.dao.SalonDao;
import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.entities.Salon;
import ie.project1.entities.Stylist;
import ie.project1.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonDao salonDao;


    @Override
    public List<Salon> getAll() {
        return salonDao.getAll();
    }

    @Override
    public Salon add(Salon salon) throws SalonMalformedException, SalonIdAlreadyExists, SalonNotFoundException {
        if (salon.getSalonId() < 0)
            throw new SalonMalformedException("ID is invalid");
        if (salon.getSalonName().isBlank())
            throw new SalonMalformedException("Salon name cannot be blank");
        if (salon.getSalonAddress().isBlank())
            throw new SalonMalformedException("Salon address cannot be blank");
        if (salon.getSalonPhone().length() < 5 || salon.getSalonPhone().length() > 15)
            throw new SalonMalformedException("Invalid phone number");
        if (salon.getSalonOpenDays().contains("1")) // 여기 나중에 수정해야 함!!!
            throw new SalonMalformedException("Open day should be at least 1 day per week");
        if (salonDao.findById(salon.getSalonId()).isPresent())
            throw new SalonIdAlreadyExists("Salon with Id " + salon.getSalonId() + " already exists.");
        if (salonDao.findById(salon.getSalonId()).isEmpty())
            throw new SalonNotFoundException("Salon with ID " + salon.getSalonId() + " does not exist.");
        salonDao.create(salon);
        return salonDao.findById(salon.getSalonId()).get();
    }

    @Override
    public List<Salon> findAllByName(String name) throws SalonNotFoundException {
        if (salonDao.findAllByName(name).isEmpty())
            throw new SalonNotFoundException("Salon with Name " + name + " does not exist");
        return salonDao.findAllByName(name);
    }

    @Override
    public Salon findById(int id) throws SalonNotFoundException {
        return salonDao.findById(id).orElseThrow(()-> new SalonNotFoundException("Salon with id " + id + "was not found."));
    }

    // Update salon by modifying the days on which it is open
    @Override
    public boolean editOpenDays(String newOpenDays, int id) throws SalonMalformedException, SalonNotFoundException {
        if (newOpenDays.length() != 7)
            throw new SalonMalformedException("Invalid the length of days opened");
        if (salonDao.findById(id).isEmpty())
            throw new SalonNotFoundException("Salon with Id " + id + " does not exist");
        return salonDao.editOpenDays(newOpenDays, id);
    }

    @Override
    public void deleteById(int id) throws SalonNotFoundException {
        salonDao.deleteById(id);
        if (!salonDao.deleteById(id))
            throw new SalonNotFoundException("Salon with id " + id + " was not found.");
    }

    @Override
    public List<Salon> findAllDaysOpen() {
        return salonDao.findAllDaysOpen();
    }

}
