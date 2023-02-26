package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Repeaters {
    public static void repeatSendKeys(WebDriver driver, By by, String text) {
        String actualText;
        do{
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            actualText = driver.findElement(by).getAttribute("value");
        }while(!actualText.equals(text));
    }

    public static void repeatSendKeys(WebDriver driver, By by, String text, String expectedText) {
        String actualText;
        do{
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            actualText = driver.findElement(by).getAttribute("value");
        }while(!actualText.equals(expectedText));
    }
}