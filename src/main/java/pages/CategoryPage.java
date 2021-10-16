package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> categoryProductsList;


    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstProductInList() {
        categoryProductsList.get(0).click();
    }
}
