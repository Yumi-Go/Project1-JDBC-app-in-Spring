import ie.project1.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class LanguageTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testFrench() {
        String message = applicationContext.getMessage("hello", null, Locale.FRENCH);
        Assertions.assertEquals("Bonjour", message);
    }

    @Test
    public void testMessagesBean() {
        Assertions.assertNotNull(applicationContext.getBean(MessageSource.class));
    }
}
