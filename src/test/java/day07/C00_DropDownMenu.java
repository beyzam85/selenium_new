package day07;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C00_DropDownMenu {

    /*
    amazona gidip
    dropdown dan books seceneğni secip
    Java aratalım
    ve arama sonuclarının Java içerdiğini test edelim
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
    public void test(){
        driver.get("https://amazon.com");

        //dropdown dan bir option secnek iöçin 3 adım vardır
        //1- dropdown i locate edelim

        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2- bir select onjesini olusturalım
        // parametre olarak bir onceki adımda locate ettiğimiz ddm yı girelim

        Select select = new Select(dropDownMenu);

        //3- dropdown da var olan optionlardan istediğimiz bir taneyi secelim

        //select.selectByIndex(5);
        //select.deselectByValue("search-alias=stripbooks-intl-ship");
        select.deselectByVisibleText("Books");

        //arama kutusuna Java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small'])[1]"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));







    }
}
