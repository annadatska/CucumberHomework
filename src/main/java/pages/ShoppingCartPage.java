package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private List<WebElement> deleteButtonsList;

    @FindBy(xpath = "//span[@aria-label='Quantity']//span[contains(@class,'selection__arrow')]")
    private WebElement itemQuantityDropdown;

    @FindBy(xpath = "//li[@class='select2-results__option']")
    private List<WebElement> itemQuantityList;

    @FindBy(xpath = "//div[contains(@class,'bag-item-edit-slideropen')]")
    private WebElement editItemButtons;

    @FindBy(xpath = "//button[@class='bag-item-edit-update']")
    private WebElement itemQuantityUpdateButton;

    @FindBy(xpath = "//span[@aria-label='Quantity']//span[contains(@class,'selection__rendered')]")
    private WebElement totalItemQuantity;

    Actions action = new Actions(driver);

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteButton() {
        for (WebElement delete : deleteButtonsList) {
            delete.click();
        }
    }

    public boolean isEmpty() {
        return deleteButtonsList.isEmpty();
    }

    public WebElement getItemQuantityDropdown() {
        return itemQuantityDropdown;
    }

    public void clickItemQuantityDropdown() {
        itemQuantityDropdown.click();
    }

    public void clickSecondElementOfQuantityList() {
        itemQuantityList.get(1).click();
    }

    public void clickItemQuantityUpdateButton() {
        action.moveToElement(itemQuantityUpdateButton).build().perform();
        itemQuantityUpdateButton.click();
    }

    public WebElement getEditItemButtons() {
        return editItemButtons;
    }

    public WebElement getTotalItemQuantity() {
        return totalItemQuantity;
    }

    public String getTotalItemQuantityText() {
        return totalItemQuantity.getText();
    }
}
