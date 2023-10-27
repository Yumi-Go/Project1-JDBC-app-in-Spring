package ie.project1.service;

import ie.project1.dao.SalonDao;
import ie.project1.dao.StylistDao;
import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.entities.Stylist;
import ie.project1.service.exceptions.SalonNotFoundException;
import ie.project1.service.exceptions.StylistIdAlreadyExists;
import ie.project1.service.exceptions.StylistMalformedException;
import ie.project1.service.exceptions.StylistNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StylistServiceImpl implements StylistService {

    @Autowired
    private StylistDao stylistDao;

    @Autowired
    private SalonDao salonDao;


    public int count() {
        return stylistDao.count();
    }

    @Override
    public List<Stylist> findAllBySalon(String salonId) throws SalonNotFoundException {
        if (salonDao.findById(salonId).isEmpty())
            throw new SalonNotFoundException("Salon with Id " + salonId + " does not exist");
        return stylistDao.findAllBySalon(salonId);
    }

    @Override
    public Stylist add(Stylist stylist) throws StylistMalformedException, StylistIdAlreadyExists, SalonNotFoundException {
        if (salonDao.findById(stylist.getSalonId()).isEmpty())
            throw new SalonNotFoundException("Salon with ID " + stylist.getSalonId() + " does not exist.");
        if (stylist.getStylistId().isBlank())
            throw new StylistMalformedException("Stylist Id cannot be blank");
        if (stylist.getStylistName().isBlank())
            throw new StylistMalformedException("Cartoon name cannot be blank");
        if (stylist.getStylistPhone().length() < 5 || stylist.getStylistPhone().length() > 15)
            throw new StylistMalformedException("Invalid phone number");
        if (stylist.getStylistSalary() < 0)
            throw new StylistMalformedException("Invalid salary");
        if (stylistDao.findById(stylist.getStylistId()).isPresent())
            throw new StylistIdAlreadyExists("Stylist with Id " + stylist.getStylistId() + " already exists.");
        stylistDao.save(stylist);
        return stylistDao.findById(stylist.getStylistId()).get();

    }

    @Override
    public Stylist findById(String id) throws StylistNotFoundException {
        return stylistDao.findById(id).orElseThrow(()-> new StylistNotFoundException("Stylist with id " + id + "was not found."));
    }

    @Override
    public boolean updateSalon(String newSalonId, String id) throws SalonNotFoundException, StylistNotFoundException {
        if (salonDao.findById(newSalonId).isEmpty())
            throw new SalonNotFoundException("Salon with Id " + id + " does not exist");
        if (stylistDao.findById(id).isEmpty())
            throw new StylistNotFoundException("Stylist with Id " + id + " does not exist");
        return stylistDao.updateSalon(id, newSalonId);
    }

    @Override
    public void deleteById(String id) throws StylistNotFoundException {
        if (!stylistDao.deleteById(id))
            throw new StylistNotFoundException("Stylist with id " + id + " was not found.");
    }

    @Override
    public int getSalaryBySalon(String salonId) throws SalonNotFoundException {
        if (salonDao.findById(salonId).isEmpty())
            throw new SalonNotFoundException("Salon with Id " + salonId + " does not exist");
        return stylistDao.getSalaryBySalon(salonId);

    }

    @Override
    public List<StylistWithSalon> findAllWithSalon() {
        return stylistDao.findAllWithSalon();
    }
}
