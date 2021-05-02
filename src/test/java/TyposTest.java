import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {
    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        String message = driver.findElements(By.tagName("p")).get(1).getText();
        assertEquals(message, "Sometimes you'll see a typo, other times you won't.",
                "Несоответствие параграфа орфографии");
    }
}
