package day005_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class P02 extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

// 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//span[@id='button1']")).click();

// 3. Açılır metni alın
        String actualText = driver.switchTo().alert().getText();

// 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedText = "I am an alert box!";

        Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue(actualText.contains(expectedText));



// 5. Açılır pencereyi kabul edin
     driver.switchTo().alert().accept();

    }

}
