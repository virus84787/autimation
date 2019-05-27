package cucumber.steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.tests.GooglePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Steps {
    WebDriver driver;
    GooglePage googlePage;

    @Given("^user is on Google Page$")
    public void user_is_on_Google_Page(){
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);

        driver.get("http://google.com");
    }

    @When("^he search for \"([^\"]*)\"$")
    public void he_search_for(String arg1) throws Exception{
        System.out.println("Step 1: Enter search phrase");
        googlePage.enterSearchText(arg1);
        System.out.println("Step 2: Click on search button");
        Thread.sleep(1000);
        googlePage.clickSearchButton();
    }

    @When("^comparing search text with title$")
    public void comparing_search_text_with_title() {
        System.out.println("Check title");
        Assert.assertTrue(driver.getTitle().contains("trololo"));
    }

    @When("^comparing search text with url$")
    public void comparing_search_text_with_url() {
        System.out.println("Check url");
        Assert.assertTrue(driver.getCurrentUrl().contains("trololo"));
    }

    @When("^comparing search text with search results$")
    public void comparing_search_text_with_search_results() {
        System.out.println("Comparing Search Text With Search Results");
        Assert.assertTrue(googlePage.getSearchResult().toLowerCase().contains("trololo"));
    }

    @When("^comparing search text with search result source$")
    public void comparing_search_text_with_search_result_source() throws Exception {
        System.out.println("Compare Search Text With Search Result Source");
        googlePage.clickOnSecondResultLink();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains("trololo"));


    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            System.out.println("Test fall");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
        if (driver != null)
            driver.quit();
    }


}
