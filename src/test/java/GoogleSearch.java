import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch {

    WebDriver driver;

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();


        openMainPage();
        typeQuery();
        submitSerach();
        waitForResults();
        assertResultPage();

    }

    //TODO: automate search scenario on Bing.com
    @Test
    public void test002() {
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
