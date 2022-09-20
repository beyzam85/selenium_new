package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AllertsTekrar02 {
     /*
    Bir class olusturun: Alerts
https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement mesaj=driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj= mesaj.getText();
        String expectudMesaj= "You successfully clicked an alert";
        Assert.assertEquals(expectudMesaj,actualMesaj);

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));

        System.out.println("2.mesajın Allert mesajı :"+ driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String actuaalMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectudMesaj ="successfuly";
        Assert.assertFalse(actuaalMesaj.contains(expectudMesaj));

    }
    @Test
    public void test3() throws InterruptedException {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK(Tamam) butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();


        //Alert üzerindeki mesajı yazdırınız
        Thread.sleep(2000);
        System.out.println("3. buttıon un alert mesajı :"+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("beyza omac");
        driver.switchTo().alert().accept();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectudMesaj = "beyza omac";
        Assert.assertTrue(actualMesaj.contains(expectudMesaj));
    }



}
