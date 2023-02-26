import Elements.PopupContent;
import Elements.RegistrationPopup;
import Pages.EvrikaStartPage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Generators;

@Test
public class Tests {
    private static WebDriver driver;

    @BeforeSuite
    public static void oneTimeSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{{
                Generators.randomName(10),
                Generators.randomName(10),
                "(242) 424-24-25",
                "+7 (242) 424-24-25",
                Generators.randomName(10) + "@gmail.com",
                "password"
        }};
    }

    @Test(dataProvider = "data")
    public void registrationTest(String name, String surname, String phone, String expectedPhone, String email, String password) {
        var evrikaStartPage = new EvrikaStartPage(driver);
        evrikaStartPage.openPage();

        var popupContent = (PopupContent) evrikaStartPage.openPopUp();
        var registrationPopup = (RegistrationPopup) popupContent.openRegistrationPopup();

        registrationPopup.fillData(name, surname, phone, expectedPhone, email, password);
        screenshot();
        registrationPopup.submit();
    }

    @AfterSuite
    public static void oneTimeTearDown() { driver.quit(); }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}