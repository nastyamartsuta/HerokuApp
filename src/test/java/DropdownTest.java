import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest {
    @Test
    public void dropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Option 1");
        String message = select.getFirstSelectedOption().getText();
        assertEquals(message, "Option 1", "Option 1 не выбран");

        select.selectByVisibleText("Option 2");
        String message2 = select.getFirstSelectedOption().getText();
        assertEquals(message2, "Option 2", "Option 2 не выбран");

        List<WebElement> option = select.getOptions();
        assertEquals(option.get(0).getText(), "Please select an option");
        assertEquals(option.get(1).getText(), "Option 1");
        assertEquals(option.get(2).getText(), "Option 2");
    }
}
