import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    private WebDriver driver;

    @FindBy(name = "q")
    WebElement searchInputField;

    public GooglePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String text){
        searchInputField.clear();
        searchInputField.sendKeys(text);
        searchInputField.sendKeys(Keys.RETURN);
    }


}
