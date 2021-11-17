import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.lang.model.type.NullType;
import java.rmi.activation.ActivationSystem;
import java.sql.Driver;
import java.util.List;
import java.util.TreeMap;

//******************Page Object mantığı kullanılmadı

public class BaseTest {
    final By manyUnit_Dropdown_CssLocate = By.cssSelector("select[class='l84FKc R9zNe vk_bk Uekwlc']");
    private static WebDriver webDriver1(){
    System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    return driver;
    }
    private static WebDriver webDriver2(){
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
        driver2.manage().window().maximize();
        return driver2;
    }
    //WebDriverWait wait = new WebDriverWait(driver,20,2000);
    WebDriverWait wait2 = new WebDriverWait(driver2,5,2000);
    //private static WebDriver driver = webDriver1();
    private static WebDriver driver2 = webDriver2();
    @Test
    void testGoogle() throws InterruptedException {
        /*
        WebElement searchOnGoogle = driver.findElement(By.name("q"));
        searchOnGoogle.sendKeys("dolar tl");
        WebElement searchButtonGoogle = driver.findElement(By.name("btnK"));
        searchButtonGoogle.submit();
        WebElement element = driver.findElement(By.cssSelector("a[href='https://www.haberturk.com/ekonomi/piyasa/88-dolar']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "100");
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='logo']>img")));
        WebElement signIn_signUpButton = driver.findElement(By.cssSelector("span[class='link login-btn']"));
        signIn_signUpButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("ÜYE OL")));
        WebElement signUpArea = driver.findElement(By.linkText("ÜYE OL"));
        signUpArea.click();
        List<WebElement> elements = driver.findElements(By.className("ha-tab"));
        int index=0;
        for (WebElement elementNow:elements){
            if (elementNow.getText().equals("ÜYE OL")){
                elements.get(index).click();
                break;
            }
        }
        driver.quit(); */




        
        //radiobutton tıklama testi için List ve get(index) kullanımı
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("iframeResult")));
        driver2.switchTo().frame(driver2.findElement(By.id("iframeResult")));
        List<WebElement> radioButtonList = driver2.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement radioButton: radioButtonList){
            wait2.until(ExpectedConditions.elementToBeClickable(radioButton));
            Assert.assertFalse(radioButton.isSelected());
            radioButton.click();
            Thread.sleep(2000);
        }

        //radiobutton tıklama testi kodu
        /*driver2.switchTo().frame(driver2.findElement(By.id("iframeResult")));
        WebElement radioButton1 = driver2.findElement(By.cssSelector("input[value='HTML']"));
        Assert.assertFalse(radioButton1.isSelected());
        radioButton1.click();
        Thread.sleep(2000);
        WebElement radioButton2 = driver2.findElement(By.cssSelector("input[value='CSS']"));
        Assert.assertFalse(radioButton2.isSelected());
        radioButton2.click();
        Thread.sleep(2000);
        WebElement radioButton3 =driver2.findElement(By.cssSelector("input[value='JavaScript']"));
        radioButton3.click();*/
        //checkbox ları seçmek için iki yol.
        /*
        //Bu kod ilk checkbox ı seçer ve seçimi kaldırır.
        Assert.assertFalse(driver.findElement(By.id("confirmed")).isSelected());
        driver.findElement(By.id("confirmed")).click();
        Assert.assertTrue(driver.findElement(By.id("confirmed")).isSelected());
        driver.findElement(By.id("confirmed")).click();*/

        /*Assert.assertTrue(driver.findElement(By.id("bulten_none")).isSelected());
        driver.findElement(By.id("bulten_none")).click();*/
        //aşağıdaki kod checkboxları sırayla seçiyor.
        /*WebElement checkBox1 = driver.findElement(By.id("confirmed"));
        if (!(checkBox1.isSelected()))checkBox1.click();
        WebElement checkBox2 = driver.findElement(By.id("bulten_none"));
        if (!(checkBox2.isSelected()))checkBox2.click();*/



        //SELECT (Dropdownlist' te seçim yapma)
        /*wait.until(ExpectedConditions.elementToBeClickable(manyUnit_Dropdown_CssLocate));
        Select select = new Select(driver.findElement(manyUnit_Dropdown_CssLocate));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(manyUnit_Dropdown_CssLocate));
        //Bu da kullanılabilir.
        select.selectByIndex(10);
        select.selectByValue("valuedegeri");
        select.selectByVisibleText("Görünen seçim ne olsun");*/


        /*//getTagName kullanımı
        WebElement webElement = driver.findElement(By.className("MWvIVe"));
        System.out.println(webElement.getTagName());*/
    }
}