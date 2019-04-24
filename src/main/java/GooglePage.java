import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    private WebDriver driver;

    @FindBy(name = "q")
    WebElement searchInputField;

    @FindBy(css = ".VlcLAe input[name=\"btnK\"")
    WebElement searchButton;

    @FindBy(css = ".srg a")
    WebElement firstResultLink;

    public GooglePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchText(String text){
        searchInputField.clear();
        searchInputField.sendKeys(text);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickOnFirstResultLink(){
        firstResultLink.click();
    }


}
