import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearch {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/chromedriver");
        driver = new FirefoxDriver();

    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }


    @AfterSuite
    public void afterSuite() {
        driver.close();
    }


    @Test
    public void test001() {
        String textValue = "portnov computer school";


        openMainPage();
        typeQuery();
        submitSerach();
        waitForResults();
        assertResultPage();

    }


    @Test
    public void test002() {
        String textValue = "#@#@!$!!#!@!";


        openMainPage();
        typeQuery();
        submitSerach();
        waitForResults();
        assertResultPage();

    }



    private void waitForResults() {
        By resultsStatsElement = By.id("resultStats");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsStatsElement));
    }

    //TODO: ADD meaningful assertion
    private void assertResultPage() {

        WebElement resultsStatsElement = driver.findElement(By.id("resultStats"));
        boolean isElementDisplayed = resultsStatsElement.isDisplayed();

        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);
    }

    private void submitSerach() {
        WebElement serchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
        serchInput.submit();
    }


    private void typeQuery() {

        WebElement serchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));

        serchInput.sendKeys("portnov computer school");
    }

    private void openMainPage() {
        String url = "https://google.com";
        driver.get(url);
    }
}
