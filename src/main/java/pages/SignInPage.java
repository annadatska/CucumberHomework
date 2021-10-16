package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(id = "signin")
    private WebElement signInButton;

    @FindBy(id = "register")
    private WebElement joinAsosButton;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[@class='error-block']//li[@id='loginErrorMessage']")
    private WebElement loginErrorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPasswordField() {
        passwordField.click();
    }

    public void enterEmailToEmailField(final String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPasswordToPasswordField(final String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", signInButton);
    }

    public void clickJoinAsosButton() {
        try{
            joinAsosButton.click();
        } catch (ElementClickInterceptedException e){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", joinAsosButton);
        }
    }

    public WebElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public String getTextOfPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public String getTextOfLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
}
