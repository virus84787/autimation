import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTest {
    WebDriver driver;
    GooglePage googlePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);

        driver.get("http://google.com");

        System.out.println("Step 1: Enter search phrase");
        googlePage.searchFor("trololo");
    }


    @Test
    public void SimpleTest(){
        System.out.println("Check title");
        Assert.assertTrue(driver.getTitle().contains("trololo"));
    }

    @Test
    public void SecondSimpleTest(){
        System.out.println("Check url");
        Assert.assertTrue(driver.getCurrentUrl().contains("trololo"));
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
