package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class TekrarCalisması_01 extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        // - Amazon sayfasına gidelim
        // - Account menusundan create a list linkine tıklayalım


        driver.get("https://amazon");
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Create a List']"));
    }

    @Test
    public void test2(){

      /*
1-Yeni bir class olusturalim: MouseActions1
2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4-Alert'te cikan yazinin "You selected a context menu" oldugunu
  -test edelim.
5-Tamam diyerek alert'i kapatalim
6-Elemental Selenium linkine tiklayalim
7-Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
  */
        //-2
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //-3
        WebElement cizgiliAlan = driver.findElement(By.xpath("\"//*[@id='hot-spot']\""));
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        //-4
        //1.yol
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        //2.yol
        String expectedAllertYazisi = "You selected a context menu";
        String actualAllertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAllertYazisi,actualAllertYazisi);
        //-5
        driver.switchTo().alert().accept();
        //-6
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

    }
    @Test
    public void test3() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //"Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
        WebElement drogMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        //WebElement dropHere = driver.findElement(By.xpath(("//*[@id='droppable'])[1]"));
        //Actions actions = new Actions(driver);
        //Extends yaptığımız TestBase Class'da Actions clasını oluşturduğumuz için direk objeyi burda kullandık
        Thread.sleep(2000);

        //actions.dragAndDrop(dragMe,dropHere).perform();

        //"Drop here" yazisi yerine "Dropped!" oldugunu test edin
      //  driver getText());


    }

}
