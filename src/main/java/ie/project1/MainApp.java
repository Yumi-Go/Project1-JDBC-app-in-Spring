package ie.project1;

import ie.project1.service.SalonService;
import ie.project1.service.StylistService;
import ie.project1.service.exceptions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SalonNotFoundException, SalonMalformedException, SalonIdAlreadyExists,
            StylistNotFoundException, StylistMalformedException, StylistIdAlreadyExists {
        System.setProperty("spring.profiles.active", "test");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        SalonService studioService = applicationContext.getBean(SalonService.class);
        StylistService cartoonService = applicationContext.getBean(StylistService.class);

        // save new studio
        System.out.println();
        System.out.println("Create new studio");
        Studio newStudio = studioService.save(new Studio(6, "My Studio", 2023));
        System.out.println(newStudio);
        studioService.findAll().forEach(System.out::println);

        // delete studio
        System.out.println();
        System.out.println("Delete studio - Before");
        System.out.println("There are " + cartoonService.count() + " cartoons.");
        studioService.findAll().forEach(System.out::println);
        studioService.deleteById(1);
        System.out.println();
        System.out.println("Delete studio - After");
        System.out.println("There are " + cartoonService.count() + " cartoons.");
        studioService.findAll().forEach(System.out::println);

        // find studio by id
        System.out.println();
        System.out.println("Find studio by id");
        System.out.println(studioService.findById(2));
        try {
            Studio studio = studioService.findById(19);
            System.out.println(studio);
        } catch (StudioNotFoundException exception) {
            System.out.println(exception.getClass().getName().toUpperCase() + ": " + exception.getMessage());
        }

        // find oldest cartoons with studios
        System.out.println();
        System.out.println("Find oldest cartoons with studios");
        cartoonService.findOldestAndStudio().forEach(System.out::println);

    }
}
