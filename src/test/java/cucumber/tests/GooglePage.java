package cucumber.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage {
    private WebDriver driver;

    @FindBy(name = "q")
    WebElement searchInputField;

    @FindBy(css = ".VlcLAe input[name=\"btnK\"")
    WebElement searchButton;

    @FindBy(css = ".srg a h3")
    List<WebElement> secondResultLink;

    @FindBy(css = ".srg")
    WebElement searchResult;

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

    public void clickOnSecondResultLink(){
        secondResultLink.get(6).click();
    }

    public String getSearchResult(){
        return searchResult.getText();
    }


}
