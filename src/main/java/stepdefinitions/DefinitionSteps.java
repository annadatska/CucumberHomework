package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CategoryPage categoryPage;
    SavedItemsPage savedItemsPage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens Home page")
    public void openHomePage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage();
    }

    @When("User make a search by a keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks search result page with more than zero results")
    public void userChecksSearchResultPageWithMoreThanZeroResults() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.checkThatSearchResultsListContainsMoreThanZero());
    }

    @When("User clicks on women category button")
    public void userClicksOnWomenCategoryButton() {
        homePage.clickWomenCategoryButton();
    }

    @And("User opens women bags category in Product Catalog")
    public void userOpensWomenBagsCategory() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.moveToAccessorizesCategoryButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getBagsAndPursesCategoryButton());
        homePage.clickBagsAndPursesCategoryButton();
    }

    @And("User clicks on first product on category page")
    public void userClicksOnFirstProductOnCategoryPage() {
        categoryPage = pageFactoryManager.getCategoryPage();
        categoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        categoryPage.clickFirstProductInList();
    }

    @And("User clicks add to cart button on product page")
    public void userClicksAddToCartButtonOnProductPage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickAddToCartButton();
    }

    @Then("User should see the product in the shopping cart")
    public void userChecksThatProductIsInTheShoppingCart() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getFilledShoppingCart());
        assertTrue(productPage.getFilledShoppingCart().isDisplayed());
    }

    @When("User clicks save for later button on first product")
    public void userClicksSaveForLaterButtonOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickSaveForLaterButtonOnFirstProduct();
    }

    @Given("User opens Saved Items page")
    public void userOpensSavedItemsPage() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickSavedItemsPageButton();
    }

    @Then("User checks that {string} is appeared on Saved Items page")
    public void checkThatItemIsAppearedOnSavedItemsPage(String amount) {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getAmountOfSavedItemsList());
        assertEquals(amount, savedItemsPage.getTextOfAmountOfSavedItems());
    }

    @And("User clears saved items list")
    public void userClearsSavedItemsList() {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        savedItemsPage.clickDeleteButtonOnAllItems();
    }

    @Then("User checks that there is no saved items on the page")
    public void checkThatThereIsNoSavedItemsOnThePage() {
        savedItemsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(savedItemsPage.isEmpty());
    }

    @And("User clicks view shopping cart button in popup")
    public void userClicksViewShoppingCartButtonInPopup() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getViewShoppingCartButton());
        productPage.clickViewShoppingCartButton();
    }

    @And("User removes product from shopping cart")
    public void userRemovesProductFromShoppingCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickDeleteButton();
    }

    @Then("User checks that shopping cart is empty")
    public void userChecksThatShoppingCartIsEmpty() {
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(shoppingCartPage.isEmpty());
    }

    @And("User clicks product quantity dropdown")
    public void userClicksProductQuantityDropdown() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getItemQuantityDropdown());
        shoppingCartPage.clickItemQuantityDropdown();
    }

    @And("User selects 2")
    public void userSelects2() {
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickSecondElementOfQuantityList();
    }

    @And("User clicks update button")
    public void userClicksUpdateButton() {
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getEditItemButtons());
        shoppingCartPage.clickItemQuantityUpdateButton();
    }

    @Then("User checks that the quantity of product is {string}")
    public void userChecksThatTheQuantityOfProductIs(String totalQuantity) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getTotalItemQuantity());
        assertEquals(totalQuantity, shoppingCartPage.getTotalItemQuantityText());
    }

    @And("User clicks Sign in button in popup")
    public void userClicksSignInButtonInPopup() {
        homePage.moveToAccountIcon();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInButton());
        homePage.clickSignInButton();
    }

    @When("User fills in email field with {string}")
    public void userFillsInEmailFieldWithEmail(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.enterEmailToEmailField(email);
    }

    @And("User fills in password field with {string}")
    public void userFillsInPasswordFieldWithPassword(final String password) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.enterPasswordToPasswordField(password);
    }

    @And("User clicks Sign in button in login form")
    public void userClicksSignInButtonInLoginForm() {
        signInPage.clickSignInButton();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User is on Home page, is signed in and sees {string} in popup window")
    public void userIsSignedInAndSeesGreetingMessage(final String greetingMessage) {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getAccountIcon());
        homePage.moveToAccountIcon();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountButton());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getGreetingMessage());
        assertEquals(greetingMessage, homePage.getTextOfGreetingMessage());
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @And("User clicks Join button in popup")
    public void userClicksJoinButtonInPopup() {
        homePage.moveToAccountIcon();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getJoinButton());
        homePage.clickJoinButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks the corresponding password error message {string}")
    public void userChecksTheErrorMessage(final String errorMessage) {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getPasswordErrorMessage());
        assertEquals(errorMessage, signInPage.getTextOfPasswordErrorMessage());
    }

    @And("User clicks Join Asos button")
    public void userClicksJoinAsosButton() {
        signInPage.clickJoinAsosButton();
    }

    @And("User clicks on Password field")
    public void userClicksOnPasswordField() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickOnPasswordField();
    }

    @Then("User checks the corresponding login error message {string}")
    public void userChecksTheCorrespondingLoginErrorMessage(final String loginErrorMessage) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getLoginErrorMessage());
        assertEquals(loginErrorMessage, signInPage.getTextOfLoginErrorMessage());
    }
}
