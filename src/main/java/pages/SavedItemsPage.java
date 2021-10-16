package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SavedItemsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'itemCount')]")
    private WebElement amountOfSavedItemsList;

    @FindBy(xpath = "//button[contains(@class,'deleteButton')]")
    private List<WebElement> deleteButtonsList;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfAmountOfSavedItems() {
        return amountOfSavedItemsList.getText();
    }

    public WebElement getAmountOfSavedItemsList() {
        return amountOfSavedItemsList;
    }

    public void clickDeleteButtonOnAllItems() {
        for (WebElement delete : deleteButtonsList) {
            delete.click();
        }
    }

    public boolean isEmpty() {
        return deleteButtonsList.isEmpty();
    }
}
