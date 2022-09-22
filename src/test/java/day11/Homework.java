package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Homework extends TestBaseBeforeAfter {

    //Ödev 1
//Yeni Class olusturun ActionsClassHomeWork
//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
// 2- Hover over Me First" kutusunun ustune gelin
//Link 1" e tiklayin
//Popup mesajini yazdirin
//Popup'i tamam diyerek kapatin
//"Click and hold" kutusuna basili tutun
//7-"Click and hold" kutusunda cikan yaziyi yazdirin
//8- "Double click me" butonunu cift tiklayin

    @Test
    public void test1() throws InterruptedException {

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
       actions.moveToElement(hoverOver). //mausu üzerine getir
               sendKeys(Keys.ARROW_DOWN).//klavyede asagıtusla ilerle
               click(hoverOver).//clik yap
               perform();//harekete gecir olayıg

       Thread.sleep(3000);

       //Link 1" e tiklayin
           // driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

       //Popup mesajini yazdirin
        System.out.println("PopUp Mesajı :"+ driver.switchTo().alert().getText());

      //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //"Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement basVeTut = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(basVeTut).perform();
        Thread.sleep(5000);

        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(basVeTut.getText());

        //8- "Double click me" butonunu cift tiklayin
        WebElement ciftTikla = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(ciftTikla).perform();

    }
}
