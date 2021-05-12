import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUpLoadTest extends BaseTest {

    @Test
    public void upLoadFile() {
        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/test.html");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        String message = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(message, "test.html", "Файл не был найден");
    }
}
