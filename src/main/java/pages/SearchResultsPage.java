package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> searchResultsTitlesList;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> saveForLaterButtonsList;

    @FindBy(xpath = "//a[@aria-label='Saved Items']")
    private WebElement savedItemsPageButton;

    Actions action = new Actions(driver);

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkThatSearchResultsListContainsMoreThanZero() {
        return !searchResultsTitlesList.isEmpty();
    }

    public void clickSaveForLaterButtonOnFirstProduct() {
        saveForLaterButtonsList.get(0).click();
    }

    public void clickSavedItemsPageButton() {
        try{
            savedItemsPageButton.click();
        } catch (ElementClickInterceptedException e){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", savedItemsPageButton);
        }
    }
}
