package Elements;

import Pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopupContent extends Element {

    public PopupContent(Page page) {
        super(page);
    }

    @Step("Open registration popup")
    public Element openRegistrationPopup() {
        container.driver.findElement(new By.ByCssSelector(".popup-content .popup__aside button")).click();
        container.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.=\"Регистрация\"]")));
        return new RegistrationPopup(container);
    }
}