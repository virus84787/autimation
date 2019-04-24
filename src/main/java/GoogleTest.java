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
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);

        driver.get("http://google.com");

        System.out.println("Step 1: Enter search phrase");
        googlePage.enterSearchText("trololo");
        System.out.println("Step 2: Click on search button");
        Thread.sleep(1000);
        googlePage.clickSearchButton();
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

    @Test
    public void CompareSearchTextWithRearchResultSourse(){
        System.out.println("Compare Search TextWith Rearch Result Sourse");
        googlePage.clickOnFirstResultLink();
        Assert.assertTrue(driver.getPageSource().contains("trololo"));
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
