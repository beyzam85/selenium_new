package day004_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    @Test
    public void teat1() {

        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//div[@class='mdl-tabs_panel is-active']//img"));

        //  for (WebElement w: animals) {
        //     w.click();
        //  }

        animals.forEach(t -> t.click());


        driver.switchTo().defaultContent();//ıframe den cıktım

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));


        //bu Listi kullanarak herbir web elementi kolayca boxes listinde bulunan web elementlerimize gonderebileceğiz.
        List<String> text = new ArrayList<>(Arrays.asList("bu", "listi", "kullanarak", "her", "bir", "webelementi", "kolayca", "boxes", "listinde", "bulunan", "webelementlerimizi", "gonderebilecegiz"));
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).sendKeys(text.get(i));
        }


        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}