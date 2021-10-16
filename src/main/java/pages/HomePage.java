package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womenCategoryButton;

    @FindBy(xpath = "//button[@data-id='415ffca1-8c1a-48a7-8997-9cc4929a7134']")
    private WebElement accessorizesCategoryButton;

    @FindBy(xpath = "//a[contains(@href,'women/bags-purses/cat')]")
    private WebElement bagsAndPursesCategoryButton;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement accountIcon;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement joinButton;

    @FindBy(xpath = "//span[text()='Hi Anna']")
    private WebElement greetingMessage;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountButton;

    private static final String HOME_PAGE_URL = "https://www.asos.com/";

    Actions action = new Actions(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickWomenCategoryButton() {
        womenCategoryButton.click();
    }

    public void moveToAccessorizesCategoryButton() {
        action.moveToElement(accessorizesCategoryButton).build().perform();
    }

    public WebElement getBagsAndPursesCategoryButton() {
        return bagsAndPursesCategoryButton;
    }

    public void clickBagsAndPursesCategoryButton() {
        bagsAndPursesCategoryButton.click();
    }

    public void moveToAccountIcon() {
        action.moveToElement(accountIcon).build().perform();
    }

    public WebElement getAccountIcon() {
        return accountIcon;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void clickSignInButton() {
        action.moveToElement(signInButton).build().perform();
        signInButton.click();
    }

    public WebElement getJoinButton() {
        return joinButton;
    }

    public void clickJoinButton() {
        joinButton.click();
    }

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    public WebElement getGreetingMessage() {
        return greetingMessage;
    }

    public String getTextOfGreetingMessage() {
        return greetingMessage.getText();
    }
}
