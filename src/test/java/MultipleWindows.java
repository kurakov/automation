import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;


    @BeforeSuite
    public void beforeSuite() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("disable-infobars");
//
//        WebDriver driver = new ChromeDriver(options);

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String linkText = "Click here";

        By linkByTExt = By.linkText("Click Here");
        WebElement linkElement = driver.findElement(linkByTExt);

        linkElement.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> allWindowHandles = driver.getWindowHandles();
        boolean isTwoWindowsOpened = allWindowHandles.size() == 2;
        Assert.assertTrue(isTwoWindowsOpened);

        String windowHandle1 = (String) allWindowHandles.toArray()[0];
        String windowHandle2 = (String) allWindowHandles.toArray()[1];

        driver.switchTo().window(windowHandle1);

    }


}
