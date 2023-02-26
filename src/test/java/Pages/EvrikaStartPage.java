package Pages;

import Elements.Element;
import Elements.PopupContent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EvrikaStartPage extends Page {
    public EvrikaStartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open pop-up page")
    public Element openPopUp() {
        var popupContent = driver.findElement(new By.ByCssSelector(".header__actions .header__actions-item_user"));
        popupContent.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".popup-content .popup__aside button")));
        return new PopupContent(this);
    }
}