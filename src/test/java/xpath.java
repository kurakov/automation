import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class xpath {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        String xpath1 = "";
//        WebElement element = driver.findElement(By.xpath(xpath1));
        String adsXpath = "html/body/div[1]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";
        String relativeXpath = "//form/div[1]/div/div[1]/div/div/input[1]";
        String xpath2 = "//input[@name='restaurant_id']";
    }
}
