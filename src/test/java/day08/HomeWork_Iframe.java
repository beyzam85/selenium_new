package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork_Iframe {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1() {
        // https://the-internet.herokuapp.com/iframe adresinegidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //"An IFrame containing…." textinin erisilebilir oldugunu test edin ve konsolda
        //yazdirin.
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        System.out.println("yazi.getText() = " + yazi.getText());
        Assert.assertTrue(yazi.isDisplayed());
    }

    @Test
    public void test2() {

        //Text Box'a "Merhaba Dunya!"yazin.
        WebElement ilkframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(ilkframe);
        WebElement yaziyeri = driver.findElement(By.tagName("p"));
        yaziyeri.sendKeys("Hello World");

    }
    @Test
    public void test3() {

        //TextBox'in altinda bulunan "Elemental Selenium" linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin.
        driver.switchTo().parentFrame();
        WebElement elemental = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());

    }

}
