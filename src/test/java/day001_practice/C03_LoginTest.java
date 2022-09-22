package day001_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {
    //1)-https://www.koalaresorthotels.com/ sayfasına gidiniz

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
    public void test1(){
        driver.get("https://www.koalaresorthotels.com");

    //2)-Login button una tıkla
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();
     //3)-Log in ekranına giridğinizi 4 farklı web elementi kullanarak dogrulayınız

        //I)
        Assert.assertTrue(driver.getTitle().contains("Log in"));

        //II)
        String expectedUrl = "https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Login Ekranina giris yapılmadı", expectedUrl,actualUrl);

        //III)
        WebElement L3=driver.findElement(By.xpath("//*[@id='btnSubmit']"));
        Assert.assertTrue(L3.isDisplayed());

        //IV)
        Assert.assertTrue("URL yanliş", driver.getCurrentUrl().contains("Logon"));

/*
asserttrue --> dogruysa  onayla geç,      yanlişsa çalışma dur, hata ver, notumu goster.
assertFalse --> yanlışsa onayla geç,     doğruysa çalışma dur, hata ver, notumu goster
assertEquals --> eşitse onayla gec,    eşit değilse çalışma dur, hata ver, notumu goster
assertNotEquals --> eşit değilse onayla geç,     eşitse çalışma dur, hata ver, notumu goster.
 */



    }
}
