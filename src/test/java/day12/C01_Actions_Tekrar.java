package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions_Tekrar extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {

        //https://automationexercise.com sitesine gidelim
        driver.get("https://www.automationexercise.com/");

        //Product bölümüne girelim
        driver.findElement(By.xpath("//*[@href='/products']")).click();

        //ilk ürüne tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

    }
}