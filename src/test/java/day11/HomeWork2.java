package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class HomeWork2 extends TestBaseBeforeAfter {
    //Ödev 2
 //Bir Class olusturalim KeyboardActions2
//https://html.com/tags/iframe/ sayfasina gidelim  3- video'yu gorecek kadar asagi inin
//videoyu izlemek icin Play tusuna basin
//videoyu calistirdiginizi test edin

    @Test
    public void test1() throws InterruptedException {
        //1-) https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2-) video'yu gorecek kadar asagi inin
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //3-) videoyu izlemek icin Play tusuna basin, videoyu calistirdiginizi test edin
        //List<WebElement> videoIframe = driver.findElements(By.xpath("//iframe"));
        //driver.switchTo().frame(videoIframe.get(0));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement videoButon = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        videoButon.click();
        Assert.assertFalse("Video calismadi!!!", videoButon.isDisplayed());

        //4-) videoyu calistirdiginizi test edin
        WebElement video = driver.findElement(By.xpath("//*[@class='video-stream html5-main-video']"));
        Thread.sleep(5000);
        actions.moveToElement(video).perform();
        WebElement pause = driver.findElement(By.xpath("//*[@title='Duraklat (k)']"));
        Assert.assertTrue(pause.isDisplayed());



    }
}
