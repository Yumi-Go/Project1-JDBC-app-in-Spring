import ie.project1.Config;
import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.entities.Stylist;
import ie.project1.service.SalonService;
import ie.project1.service.StylistService;
import ie.project1.service.exceptions.SalonNotFoundException;
import ie.project1.service.exceptions.StylistIdAlreadyExists;
import ie.project1.service.exceptions.StylistMalformedException;
import ie.project1.service.exceptions.StylistNotFoundException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTests {

    @Autowired
    StylistService stylistService;

    @Autowired
    SalonService salonService;

    @Test
    @Order(1)
    public void testStylistCount() {
        Assertions.assertEquals(20, stylistService.count());
    }

    @Test
    @Order(2)
    @SneakyThrows
    public void testStylistFindAllBySalon() {
        Assertions.assertEquals(3, stylistService.findAllBySalon("sa2").size());
        Assertions.assertThrows(SalonNotFoundException.class, ()->{
            salonService.findById("sa23");
        });
    }

    @Test
    @Order(3)
    @SneakyThrows
    public void testNewStylistOk() {
        int oldCount = stylistService.count();
        Stylist stylist = new Stylist("st33", "James Collins", "5938495857", 27500, "sa4");
        Stylist newStylist = stylistService.add(stylist);
        Assertions.assertEquals(oldCount+1, stylistService.count());
        Assertions.assertNotNull(newStylist);
        Assertions.assertEquals("st33", newStylist.getStylistId());
    }

    @Test
    @Order(4)
    @SneakyThrows
    public void testStylistBadSalonId() {
        Stylist stylist = new Stylist("st29", "Cillian MacLaughlin", "0219296737", 56000, "sa9999");
        Assertions.assertThrows(SalonNotFoundException.class, ()->{
            salonService.findById("sa9999");
        });
    }

    @Test
    @Order(5)
    @SneakyThrows
    public void testNewStylistBadId() {
        Stylist stylist = new Stylist("", "Cillian MacLaughlin", "0219296737", 56000, "sa1");
        Assertions.assertThrows(StylistMalformedException.class, ()->{
            stylistService.add(stylist);
        });
    }

    @Test
    @Order(6)
    @SneakyThrows
    public void testNewStylistBadName() {
        Stylist stylist = new Stylist("st29", "", "0339495827", 32100, "sa1");
        Assertions.assertThrows(StylistMalformedException.class, ()->{
            stylistService.add(stylist);
        });
    }

    @Test
    @Order(7)
    @SneakyThrows
    public void testNewStylistBadPhoneNumber() {
        Stylist stylist_shortPhoneNum = new Stylist("st45", "Cillian MacLaughlin", "033", 32100, "sa1");
        Assertions.assertThrows(StylistMalformedException.class, ()->{
            stylistService.add(stylist_shortPhoneNum);
        });
        Stylist stylist_longPhoneNum = new Stylist("st45", "Cillian MacLaughlin", "83859385395938599", 32100, "sa1");
        Assertions.assertThrows(StylistMalformedException.class, ()->{
            stylistService.add(stylist_longPhoneNum);
        });
    }

    @Test
    @Order(8)
    @SneakyThrows
    public void testNewStylistBadSalary() {
        Stylist stylist = new Stylist("st29", "Cillian MacLaughlin", "0339495827", -1, "sa1");
        Assertions.assertThrows(StylistMalformedException.class, ()->{
            stylistService.add(stylist);
        });
    }

    @Test
    @Order(9)
    public void testAddClashPK() {
        Stylist stylist = new Stylist("st3", "Cillian MacLaughlin", "0339495827", 30000, "sa1");
        Assertions.assertThrows(StylistIdAlreadyExists.class, ()->{
            stylistService.add(stylist);
        });
    }

    @Test
    @Order(10)
    @SneakyThrows
    public void testStylistFindByIdFound() {
        Stylist stylist = stylistService.findById("st5");
        Assertions.assertNotNull(stylist);
        Assertions.assertEquals("Keith Bailey", stylist.getStylistName());
    }

    @Test
    @Order(11)
    public void testStylistFindByIdNotFound() {
        Assertions.assertThrows(StylistNotFoundException.class, ()->{
            stylistService.findById("aabccc");
        });

    }

    @Test
    @Order(12)
    @SneakyThrows
    public void testUpdateSalonBadSalonId() {
        Assertions.assertThrows(SalonNotFoundException.class, ()->{
            stylistService.updateSalon("", "st8");
        });
    }

    @Test
    @Order(13)
    @SneakyThrows
    public void testUpdateSalonBadStylistId() {
        Assertions.assertThrows(SalonNotFoundException.class, ()->{
            stylistService.updateSalon("sa2", "");
        });
    }

    @Test
    @Order(14)
    @SneakyThrows
    public void testUpdateSalonAllOk() {
        Assertions.assertTrue(stylistService.updateSalon("sa5", "st10"));
    }

    @Test
    @Order(15)
    @SneakyThrows
    public void testDeleteByIdNotFound() {
        Assertions.assertThrows(StylistNotFoundException.class, ()->{
            stylistService.deleteById("djfewf");
        });
    }

    @Test
    @Order(16)
    @SneakyThrows
    public void testDeleteById() {
        Assertions.assertNotNull(stylistService.findById("st1"));
        stylistService.deleteById("st1");
        Assertions.assertThrows(StylistNotFoundException.class, ()->{
            stylistService.findById("st1");
        });
    }

    @Test
    @Order(17)
    @SneakyThrows
    public void testGetSalaryBySalonBadSalonId() {
        Assertions.assertThrows(SalonNotFoundException.class, ()->{
            stylistService.getSalaryBySalon("");
        });
    }

    @Test
    @Order(18)
    @SneakyThrows
    public void testGetSalaryBySalonAllOk() {
        Assertions.assertEquals(30000, stylistService.getSalaryBySalon("sa3"));
    }

    @Test
    @Order(19)
    public void testFindAllStylistsWithSalon() {
        List<StylistWithSalon> withSalonName= stylistService.findAllWithSalon();
        Assertions.assertNotNull(withSalonName.get(2).salonName());
        Assertions.assertEquals("Kopper Hair Salon", withSalonName.get(0).salonName());
    }
}

