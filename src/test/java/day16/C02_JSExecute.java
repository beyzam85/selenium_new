package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecute extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");

       //Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim

        WebElement carrers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);//scrollIntoView maus ın tekerleği gibi
                                                                              // java script careers Web elementini
                                                                              // gorene kadar arka planda sayfayı
                                                                              //asagıya sürükler

        // Carrers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",carrers);






        //odev
//Yeni bir class olusturun : ScroolInto
//hotelmycamp anasayfasina gidin
//2 farkli test method'u olusturarak actions classi ve
// Js Executor kullanarak asagidaki oda turlerinden
// ust sira ortadaki odayi tiklayin
//istediginiz oda inceleme sayfasi acildigini test  edin
    }

}



