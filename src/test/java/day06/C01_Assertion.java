package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertion {
    /*
    -Amazon sayfasına gidelim
    3 farklı test methodu olusturalım
    a-Url nin amazon içerdiğinitest edelim
    b-Titlee nin facebook içermediğini test edelim
    c-sol ust kosede amazon logosunun gorunduunu tes edelim
    d-Url nin www.facebook.com oldugunu test edin.
    */

//BİLGİ:  assertTrue
//beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
// Parametre olarak iki değer alır.
// İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
//assertFalse
//beklenen bir sonucun false olması durumunda kullanılır.
// İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
// assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.



     static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");//butun classlarda tek tek yazdırmamak için ilk kısımda yazıyoruz
        // BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.


    }
    @AfterClass
    public static void teardown(){
        //driver.close();
    }

    @Test
    public void test1(){
        //a-Url'nin facebook içerdiğini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //Assert.assertNotEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test2(){
        //b-Title'in facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }
}



