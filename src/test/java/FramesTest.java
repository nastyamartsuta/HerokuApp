import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest{

    @Test
    public void framesTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[contains(@href, '/iframe')]")).click();
        String message = driver.findElement(By.xpath("//h3[contains (text(), 'containing')]")).getText();
        assertEquals(message, "An iFrame containing the TinyMCE WYSIWYG Editor",
                "Переход на следующую страницу не совершен");
        driver.switchTo().frame(0);
        String checkingText = driver.findElement(By.id("tinymce")).getText();
        assertEquals(checkingText, "Your content goes here.",
                "Несоответствие текста ожиданиям");
        driver.switchTo().defaultContent();
    }
}
