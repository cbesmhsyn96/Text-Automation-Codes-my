import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/*
 * Bu proje Page Object Pattern kullanılmadan yazılmıştır.
 */
public class BaseTest {
    final By iframeForm_fullName_Id = By.id("name");
    final By headerMenu_ClassName = By.className("menuIn");
    final By headerMenu_Sub_TagName = By.tagName("a");
    final By destekButton_Name = By.className("destek");
    final By iframeForm_Id = By.id("iFrameResizer0");
    final By iframeForm_MailAddress_Id=By.id("mailAddress");
    final By iframeForm_subject_Id=By.id("subject");
    final By iframeForm_messageText_Id = By.id("text");
    final By canliIzleLink = By.linkText("Canlı İzle");
    final By forexTraderUserId = By.id("userid");
    final By getForexTraderPassword = By.xpath("//input[@placeholder='Şifre']");
    private static WebDriver pageOpen(){
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.foreks.com/");
        driver.manage().window().maximize();
        return driver;
    };
    private static WebDriver driver = pageOpen();//Tarayıcıyı ayağa kaldırma
    //Kod tek sayfadan oluştuğu için private kullanmakta sakınca yok.
    //Tarayıcıda get ile açacağımız url sabit olduğu için static
    @Test
    public void forexTest_First() throws InterruptedException {
        System.out.println(driver.getTitle());
        WebElement canliIzleForex = driver.findElement(canliIzleLink);
        canliIzleForex.click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        WebDriverWait wait = new WebDriverWait(driver,10);
        //Elementin tıklanabilir olması için maks 10 saniye bekle
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Giriş Yap"))));
        //driver.findElement(By.linkText("Mobil")).click();//fail almadan işlemi yaptık
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(forexTraderUserId).sendKeys("huseyinakcan");
        driver.findElement(getForexTraderPassword).sendKeys("sdfsd*fsaA_12413");
        System.out.println(driver.getTitle());
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Tahminler"))));
        driver.findElement(By.linkText("Tahminler")).click();
        /*
        switchTo kullanmadan bu işlemi yapamıyoruz.
        driver.findElement(By.linkText("Mobil")).click();
        //fail verir çünkü açılan sayfaya bağlanmadı.*/
        //driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
        /*
        
        //Button kodları

        */
        driver.quit();
        /*
         * foreach yazınca testi yaptı ama istenen
         * sonuç olmasına rağmen fail verdi.
         * Onun yerine formatlı for kullandım.
         * */
        //menuButtons.forEach((webElement -> {if (webElement.getText().equals("Borsa")){webElement.click();}}));
        /*
        int index=0;
        while(index<menuButtons.size()){
            if (menuButtons.get(index).getText().equals("Borsa")){
                menuButtons.get(index).click();
            }
            index++;
        }**/
    }
}
//driver.manage() altına yapıştırılacak.
/*List<WebElement> mainPageControl = driver.findElements(By.cssSelector("div[class='catTitle']>h2"));
        for (WebElement lst0 : mainPageControl) {
            if (lst0.getText().equals("Borsa")) {
                System.out.println("https://www.foreks.com/ adresine giriş yapıldı.");
                break;
            }
        }
        WebElement headerMenu = driver.findElement(headerMenu_ClassName);
        List<WebElement> menuButtons = headerMenu.findElements(headerMenu_Sub_TagName);
        for (WebElement lst : menuButtons) {
            if (lst.getText().equals("Borsa")) {
                lst.click();
                break;
            }
        }
        WebElement currentPageControl = driver.findElement(By.cssSelector("div[class='boxTit']>h2"));
        Assert.assertEquals(currentPageControl.getText(), "Borsa - En Çok İşlem Görenler");
        System.out.println("https://www.foreks.com/borsa adresine giriş yapıldı.");
        WebElement searchBox = driver.findElement(By.cssSelector("span[class='custom-combobox']>input"));
        searchBox.sendKeys("SABANCI");
        List<WebElement> searchResults = driver.findElements(By.cssSelector("ul[id='ui-id-1']>li"));
        Random randomResult = new Random();
        int resultIndex = randomResult.nextInt(searchResults.size());
        searchResults.get(resultIndex).click();
        System.out.println("Arama kutucuğuna SABANCI yazıldı ve sonuçlardan rastgele birine tıklandı.");
        List<WebElement> element = driver.findElements(By.cssSelector("div[class='tabsMW548 ng-scope']>div"));
        for (WebElement lst3:element){
            if (lst3.getText().equals("İÇ PİYASALAR")){
                System.out.println(lst3.getCssValue("font-family"));
                Assert.assertEquals(lst3.getCssValue("font-family"),"\"Source Sans Pro\", sans-serif");
                break;
            }
        }
        WebElement destekButton = driver.findElement(destekButton_Name);
        destekButton.click();
        driver.switchTo().frame(driver.findElement(iframeForm_Id));
        WebElement formFullName = driver.findElement(iframeForm_fullName_Id);
        formFullName.sendKeys("Hüseyin Akcan");
        WebElement formEmail = driver.findElement(iframeForm_MailAddress_Id);
        formEmail.sendKeys("hsynakcn96@gmail.com");
        WebElement formSubject = driver.findElement(iframeForm_subject_Id);
        formSubject.sendKeys("Test Java");
        WebElement formMessageText = driver.findElement(iframeForm_messageText_Id);
        formMessageText.sendKeys("Yazılımınızı yazdığım bir Java test otomasyonu ile test ediyorum.");
        *//*WebElement formSendButton = driver.findElement(By.id("send"));
        formSendButton.submit();//veya formSendButton.click();*//*
        //Assert.assertEquals(formFullName.getAttribute("id"),"naame"); şeklinde olunca hata verdi.
        Assert.assertEquals(formFullName.getAttribute("id"),"name");
        System.out.println(formFullName.getTagName());*/