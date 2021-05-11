import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest {
    @Test
    public void sortableDataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        assertEquals(table1, "Frank", "Invalid first name");
        String table2 = driver.findElement(By.xpath("//table//tr[4]//td[5]")).getText();
        assertEquals(table2, "http://www.timconway.com", "Invalid web site");
        String table3 = driver.findElement(By.xpath("//table[1]//tr[3]//td[4]")).getText();
        assertEquals(table3, "$100.00", "Invalid due");
        String table4 = driver.findElement(By.xpath("//table[2]//tr[4]//td[3]")).getText();
        assertEquals(table4, "tconway@earthlink.net", "Invalid email");

    }
}
