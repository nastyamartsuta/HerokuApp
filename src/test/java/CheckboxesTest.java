import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {
    @Test
    public void checkboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElements(By.cssSelector("[type='checkbox']")).get(0);
        Assert.assertEquals(checkbox1.getAttribute("checked"), null, "checkbox 1 checked");
        checkbox1.click();
        Assert.assertEquals(checkbox1.getAttribute("checked"), "true", "checkbox 1 unchecked");

        WebElement checkbox2 = driver.findElements(By.cssSelector("[type='checkbox']")).get(1);
        Assert.assertEquals(checkbox2.getAttribute("checked"), "true", "checkbox 1 unchecked");
        checkbox2.click();
        Assert.assertEquals(checkbox2.getAttribute("checked"), null, "checkbox 1 checked");
    }
}
