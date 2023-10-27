package ie.project1.service;

import ie.project1.dao.SalonDao;
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


//    private int salonId; // unique
//    private String salonName; // not blank, not unique
//    private String salonAddress; // not blank
//    private String salonPhone; // not blank, no validation is required
//    private String salonOpenDays; // at least 1 day per week. e.g. string representing each day "MTWTFSS" so "0111110" might mean closed Monday and Sunday but open all other days.
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
        return salonDao.findById(salon.getStylistId()).get();
    }



    여기서부터 할 차례!!!!!!!!!!!!!!!!!

    @Override
    public List<Salon> findByName(String name) {
        return
    }

    @Override
    public Salon findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean editOpenDays(String newOpenDays, int id) {
        return false;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Salon> findAllDaysOpen() {
        return null;
    }
}
