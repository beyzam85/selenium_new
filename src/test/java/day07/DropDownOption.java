package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownOption {
    /*
    Amazon sayfasına gidip
    dropdown menuden books u secelim
     sectiğimiz option u yazdiralım

     dropdown daki opsiyonlarin toplam sayisinin
     23 oldugunu test edin

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
        driver.get("https://amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropDownBox]"));
        Select select = new Select(ddm);
        select.deselectByVisibleText("Books");

        //bir dopdown ile calişiyorsanız , son secilen optiona a ulaşmak isterseniz
        // select.getFirstselectedOption() method unu kullanmalısınız
        // bu method bize WebElement dondurur
        // uzerindeki yazıyı yazdırmak için getText() unutulmamalıdır
        System.out.println(select.getFirstSelectedOption().getText());


        //2. gorev--> dropdown daki opsiyonlarin toplam sayisinin
        //     23 oldugunu test edin
        List<WebElement> optionList = select.getOptions();

        int actualOptionSayisi = optionList.size();
        int expectedOptionSayisi = 23;

        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

    }

    }
