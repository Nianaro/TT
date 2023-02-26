package Elements;

import Pages.EvrikaHomePage;
import Pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Repeaters;

public class RegistrationPopup extends Element {
    public RegistrationPopup(Page page) {
        super(page);
    }

    @Step("Fill registration data")
    public void fillData(String name, String surname, String phone, String expectedPhone, String email, String password) {
        var d = container.driver;
        new Actions(d).moveToElement(d.findElement(By.cssSelector("._mb-df input"))).moveByOffset(1, 1).click().perform();

        Repeaters.repeatSendKeys(d, By.name("password"), password);
        Repeaters.repeatSendKeys(d, By.xpath("//label[.='Повторите пароль']/../input"), "password");

        Repeaters.repeatSendKeys(d, By.name("name"), name);
        Repeaters.repeatSendKeys(d, By.name("surname"), surname);
        Repeaters.repeatSendKeys(d, By.cssSelector(".popup__view .form-control [name=phone]"), phone, expectedPhone);
        Repeaters.repeatSendKeys(d, By.name("email"), email);
    }

    @Step("Submit registration data")
    public EvrikaHomePage submit() {
        container.driver.findElement(By.xpath("//button[.=\"Регистрация\"]")).click();
        container.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[.='Личные данные']")));
        return new EvrikaHomePage(container.driver);
    }
}