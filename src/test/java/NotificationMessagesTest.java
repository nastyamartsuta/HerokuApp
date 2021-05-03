import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NotificationMessagesTest extends BaseTest {
    @Test
    public void notificationMessages() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        String message = driver.findElement(By.id("flash")).getText();
        assertEquals(message, "Action successful\n" + "×",
                "Несоответствие текста ожиданиям");
    }
}
