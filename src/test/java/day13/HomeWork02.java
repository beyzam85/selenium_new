package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class HomeWork02 extends TestBaseBeforeAfter {
//    Bir Class olusturun D19_WebtablesHomework
//   “https://demoqa.com/webtables” sayfasina gidin
//    Headers da bulunan department isimlerini yazdirin
//    sutunun basligini yazdirin
//    Tablodaki tum datalari yazdirin
//    Tabloda kac cell (data) oldugunu yazdirin
//    Tablodaki satir sayisini yazdirin
//    Tablodaki sutun sayisini yazdirin
//    Tablodaki 3.kolonu yazdirin
//    Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
//    Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin


        @Test
        public void test1() {
            // odev01
            // Bir class oluşturun : D18_WebTables
            // login( ) metodun oluşturun ve oturum açın.

            //Username : manager
            //Password : Manager1!
            driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin ");
            Actions actions = new Actions(driver);
            driver.findElement(By.xpath("//*[@id='details-button']")).click();
            driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
            WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
            actions.click(userName).sendKeys("manager").
                    sendKeys(Keys.TAB).sendKeys("Manager1!").
                    sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();

            // table( ) metodu oluşturun
            // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
            List<WebElement> sutunSayisiList = driver.findElements(By.xpath("//tbody//tr[1]//td"));
            int sutunSayisi = sutunSayisiList.size();
            System.out.println("sutunSayisi = " + sutunSayisi);

            // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
            WebElement tumBasliklar = driver.findElement(By.xpath("//thead//tr[1]"));
            System.out.println(tumBasliklar.getText()); // tablonun baslik kismini yazdirir
            System.out.println("========================= :) (: ===========================================");
            WebElement tumBody = driver.findElement(By.xpath("//tbody"));
            System.out.println(tumBody.getText()); // tablonun body kismini yazdirir

            System.out.println("imlec kontrol!!!!!!!!!!!");

            // printRows( ) metodu oluşturun //tr
            // table body’sinde bulunan toplam satir(row) sayısını bulun.
            List<WebElement> satirListi = driver.findElements(By.xpath("//tbody//tr"));
            int satirSayisi = satirListi.size();
            System.out.println("satirSayisi = " + satirSayisi);

            // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            for (WebElement w : satirListi) {
                System.out.println(w.getText());
                System.out.println("========================= :) (: ==================================");
            }
            // 4.satirdaki(row) elementleri konsolda yazdırın.
            System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());
            // printCells( ) metodu oluşturun //td
            // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
            List<WebElement> cellsList = driver.findElements(By.xpath("//tbody//tr//td"));
            int hucreSayisi = cellsList.size();
            System.out.println("hucreSayisi = " + hucreSayisi);
            // Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
            for (WebElement w : cellsList) {
                System.out.println(w.getText());
            }
            // table body’sinde bulunan toplam sutun(column) sayısını bulun.
            List<WebElement>columnList = driver.findElements(By.xpath("//tbody//td"));
            int columnSayisi = columnList.size();
            System.out.println("columnSayisi = " + columnSayisi);
            // Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
            for (WebElement each: cellsList) {
                System.out.println(each.getText());

            }

            // 5.column daki elementleri konsolda yazdırın.

        }
    }

