import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicAuthentification {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

//    @BeforeMethod
//    public void openBrowser(){
//        driver = new FirefoxDriver();
//    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void test001() {
        String login = "admin";
        String passw = "admin";


        openBasicAuthPage(login, passw);
        assertThatAuthenticated();
    }

    @Test
    public void test002() {
        String login = "adminnnn";
        String passw = "adminddddd";


        openBasicAuthPage(login, passw);
        assertThatAuthenticated();
    }

    @DataProvider(name = "dataForAuthTest")
    public Object[][] dataForTest() {
        return new Object[][]{
                {"admin", "admin"},
                {"wevevvr", "cweververv"},
                {"admin", "dcdwcc"},
                {"svcfev", "admin"},
        };
    }

    @Test(dataProvider = "dataForAuthTest")
    public void test003(String paramValue1, String paramValue2) {
        String login = paramValue1;
        String passw = paramValue2;

        openBasicAuthPage(login, passw);
        assertThatAuthenticated();
    }

    private void assertThatAuthenticated() {
        boolean isContainCongrats = driver.getPageSource().contains("Congrat");
        Assert.assertTrue(isContainCongrats);
    }

    private void openBasicAuthPage(String login, String password) {


        String url = "https://" + login + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(url);

    }
}
