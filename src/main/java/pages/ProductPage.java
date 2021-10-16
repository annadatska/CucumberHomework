package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(id = "product-add-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//button[@icontype='bagFilled']")
    private WebElement filledShoppingCart;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewShoppingCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getFilledShoppingCart() {
        return filledShoppingCart;
    }

    public void clickViewShoppingCartButton() {
        viewShoppingCartButton.click();
    }

    public WebElement getViewShoppingCartButton() {
        return viewShoppingCartButton;
    }
}
