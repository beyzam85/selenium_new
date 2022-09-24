package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class HomeWork01Explicitlyle extends TestBaseBeforeAfter {

    @Test
    public void test1() {

// 1."http://webdriveruniversity.com/Actions" adresine gidin
        driver.get("http://webdriveruniversity.com/Actions");
//2."Login Portal" a  kadar asagi inin

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='dropbtn']")));
        actions.moveToElement(hover).perform();

//3."Login Portal" a tiklayin

//4.Diger window'a gecin
//5."username" ve  "password" kutularina deger yazdirin
//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
//8.Ok diyerek Popup'i kapatin
//Ilk sayfaya geri donun
//Ilk sayfaya donuldugunu test edin









    }
}