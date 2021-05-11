import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        String checkboxText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();
        assertEquals(checkboxText, "It's gone!","Несоответствие текста ожиданиям");
        assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox"))),
                "Checkbox отображается");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        String inputText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();
        assertEquals(inputText, "It's enabled!","Несоответствие текста ожиданиям");
    }
}
