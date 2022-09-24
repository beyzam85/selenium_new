package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class HomeWork03Explicitlyle extends TestBaseBeforeAfter {

    @Test
    public void test1() {


        //"Link 1" e tiklayin//1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMeFirst).perform();

        //3. "Link 1" e tiklayin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Link 1'])[1]")));
        link1.click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']")).getText());

        //8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[text()='Double Click Me!']")));

    }
}