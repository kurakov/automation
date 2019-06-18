import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Checkbox {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

    //TODO: find a different of checking if checkbox is selected

    //TODO: add more scenarios
    @Test
    public void test002() {

    }


    //TODO: REFACTOR into user actions stepsid-copyy

    @Test
    public void test001() {
        openCheckboxesPage();

        List<WebElement> listOfInputs = driver.findElements(By.tagName("input"));

        int listSize = listOfInputs.size();

        WebElement checkBox1 = listOfInputs.get(0);
        WebElement checkBox2 = listOfInputs.get(1);

        String attributeValue1 = checkBox1.getAttribute("checked");
        String attributeValue2 = checkBox2.getAttribute("checked");

        Assert.assertNull(attributeValue1);
        Assert.assertNotNull(attributeValue2);

        checkBox1.click();

        attributeValue1 = checkBox1.getAttribute("checked");
        Assert.assertNotNull(attributeValue1);


        String expectedAttributeValue = "true";
        Assert.assertEquals(expectedAttributeValue, attributeValue1);

    }

    private void openCheckboxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
