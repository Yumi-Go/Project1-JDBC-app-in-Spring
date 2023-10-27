package ie.project1;

import ie.project1.entities.Salon;
import ie.project1.entities.Stylist;
import ie.project1.service.SalonService;
import ie.project1.service.StylistService;
import ie.project1.service.exceptions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MainApp {
    public static void main(String[] args) throws SalonNotFoundException, SalonMalformedException, SalonIdAlreadyExists,
            StylistNotFoundException, StylistMalformedException, StylistIdAlreadyExists {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        SalonService salonService = applicationContext.getBean(SalonService.class);
        StylistService stylistService = applicationContext.getBean(StylistService.class);


//        // create a new stylist
//        System.out.println();
//        System.out.println("******************** Create new Stylist ********************");
//        System.out.println("### Stylists list before Creation");
//        Stylist newStylist = stylistService.add(
//                new Stylist("st99", "Yumi Go", "08342115",50000,"sa3")
//        );
//        System.out.println("New Stylist: ");
//        System.out.println(newStylist);
//        System.out.println();

        // create a new salon
        System.out.println();
        System.out.println("Create new salon");
        Salon newSalon = salonService.save(
                new Salon("sa25", "Yumi's Hair Salon", "123 Cork city center, Cork, T12 D345",
                        "(083) 421 5015", "1111001")
        );
        System.out.println(newSalon);
        salonService.getAll().forEach(System.out::println);

        // delete salon
        System.out.println();
        System.out.println("Salons list before Deletion");
        salonService.getAll().forEach(System.out::println);
        salonService.deleteById("sa3");
        System.out.println();
        System.out.println("Salons list after Deletion");
        salonService.getAll().forEach(System.out::println);

        // find salon by id
        System.out.println();
        System.out.println("Find salon by id");
        System.out.println(salonService.findById("sa2"));
        try {
            Salon salon = salonService.findById("sa32");
            System.out.println(salon);
        } catch (SalonNotFoundException exception) {
            System.out.println(exception.getClass().getName().toUpperCase() + ": " + exception.getMessage());
        }

        // Get all stylists along with the name of the salon for which they work
        System.out.println();
        System.out.println("Get all stylists along with the name of the salon for which they work");
        stylistService.findAllWithSalon().forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

        // List all those salons open 7 days a week.
        System.out.println();
        System.out.println("All salons opened 7 days a week");
        salonService.findAllDaysOpen().forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

        // Language
        System.out.println("===================================================================");
        System.out.println(applicationContext.getMessage("hello", null, Locale.FRENCH));
        System.out.println(applicationContext.getMessage("welcome", null, Locale.ENGLISH));
        System.out.println(applicationContext.getMessage("love", null, Locale.KOREAN));
        System.out.println("===================================================================");
    }
}
