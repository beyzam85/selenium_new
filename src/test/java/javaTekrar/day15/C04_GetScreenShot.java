package javaTekrar.day15;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;


public class C04_GetScreenShot extends TestBaseBeforeAfter {


        @Test
        public void test1() throws IOException {
            //Amazon sayfasına gidelim tum sayfanın resmini alalim
            driver.get("https://bestbuy.com");

            TakesScreenshot ts = (TakesScreenshot) driver;//data casting yapıyoruz burada

        /*
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje oluşturup
        Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den getScreenShotAs
        methonu kullanarak geçici bir file oluştururuz
         */
            System.out.println(tarih);

            File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);//sayfanın goruntususnu dosya seklinde alve Output
            FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
        }
    }


