import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BingSearch {
    WebDriver driver;

    @Test
    public void test1() throws Exception {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();

        openBingPage();
        typeQuery();
        clickSearchSubmit();
        waitForResult();
        verifyResult();

    }

    private void waitForResult() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='b_tween']/..//span[@class='sb_count']")));
    }

    private void verifyResult() {
        WebElement result = driver.findElement(By.xpath("//div[@id='b_tween']/..//span[@class='sb_count']"));
        boolean resultIsDisplayed = result.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(resultIsDisplayed, expectedResult);

        driver.close();
    }

    private void clickSearchSubmit() {
        driver.findElement(By.xpath("//*[@id='sb_form_go']")).click();
    }

    private void typeQuery() {
        driver.findElement(By.id("sb_form_q")).sendKeys("testNG");
    }

    private void openBingPage() {
        driver.get("https://www.bing.com/");
    }

}