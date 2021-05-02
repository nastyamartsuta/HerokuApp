import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoversTest extends BaseTest {
    @Test
    public void hovers() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        int hoverSize = driver.findElements(By.cssSelector("[class='figure']")).size();
        for (int i = 0; i < hoverSize; i++) {
            driver.get("http://the-internet.herokuapp.com/hovers");
            WebElement hover = driver.findElements(By.cssSelector("[class='figure']")).get(i);
            Actions action = new Actions(driver);
            action.moveToElement(hover).click().build().perform();

            String message = hover.findElement(By.tagName("h5")).getText();
            assertEquals(message, "name: user" + (i + 1),
                    "Имя не соответсвует");

            driver.findElements(By.linkText("View profile")).get(0).click();
            String message1 = driver.findElement(By.tagName("h1")).getText();
            assertEquals(message1, "Not Found",
                    "Не перешло на страницу с ошибкой");
        }
    }
}
