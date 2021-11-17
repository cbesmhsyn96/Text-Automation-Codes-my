import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;
//Bu proje
//https://www.google.com adresine gider.
//Arama kutucuğuna Kitap yazar
//Arama butonuna tıklar.
//İlk siteyi seçer(Kitap|İdefix)
//Sitenin açıldığını kontrol eder
//Giriş Yap' a tıklar
//Üye Ol' a tıklar
//Üye olur.
//(idefix client a engel koydu :) Kızma idefix sadece test yapıyordum :)) )
//(Bu arada idefix in açığı var. Rastgele  harflerden oluşan mail girince üyeliği kabul ediyor.)
//NavBar' dan bir kategoriden rastgele bir ürün türü seçer.
public class BaseTest {
    @Test
    void titleControl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        element.sendKeys("Kitap");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.submit();
        List<WebElement> results=driver.findElements(By.cssSelector("a>h3[class='LC20lb DKV0Md']"));
        results.get(0).click();
        String controlSiteOpen = driver.findElement(By.cssSelector("li>a[href='https://www.idefix.com/yazarlar'] ")).getText();
        assertEquals(controlSiteOpen,"Yazarlar");
        System.out.println("Idefix sayfasina giris basarili.");
        WebElement clickToLogIn = driver.findElement(By.id("dropdownMenuLink"));
        clickToLogIn.click();
        WebElement loginPress = driver.findElement(By.cssSelector("div[class='top-items']>a[href='/register']"));
        loginPress.click();
        Thread.sleep(5000);
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("Mehmet");
        WebElement lastNameInput = driver.findElement(By.id("surNameField"));
        lastNameInput.sendKeys("Karagün");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "150");
        WebElement emailInput = driver.findElement(By.id("e-mail"));
        emailInput.sendKeys("mehmetkaragun.123@gmail.com");
        js.executeScript("window.scrollBy(0,250)", "100");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("312da312_31d2431as1Asd@");
        List<WebElement> checkBoxElements = driver.findElements(By.cssSelector("div[class='form-group']>p>div"));
        checkBoxElements.get(0).click();
        checkBoxElements.get(1).click();
        checkBoxElements.get(2).click();
        WebElement submitButton = driver.findElement(By.id("btnAddNewCustomer"));
        submitButton.click();
        //Burada sıkıntı var.
        /*List<WebElement> navSubElements = driver.findElements(By.cssSelector("div[class='container navMenuTop']>div>div>ul>li"));
        Random randomSubElementsGet = new Random();
        int randomSubElementsGetIndex = randomSubElementsGet.nextInt(navSubElements.size());
        navSubElements.get(randomSubElementsGetIndex).click();*/
    }
}