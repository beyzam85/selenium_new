package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev01 {
    /*
    Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter’a
bastigimizda “Invalid email address” uyarisi ciktigini test edelim

     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test() {
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim.
        WebElement mailKutusu = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        mailKutusu.sendKeys("beyzagmail.com" + Keys.ENTER);
    }
}