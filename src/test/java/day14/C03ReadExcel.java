package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {

       // Belirtilen satırNo ve
        // sutunNo degerleini parametre olarak alıp
        // o cell deki data yı konsola yazdıralım
      //Sonucun konsolda yazanla aynı oldugunu doğrulayın

      int satir = 12 ;
      int sutun = 2 ;

      String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.
                getSheet("sayfa1").
                getRow(satir-1).
                getCell(sutun-1)
                .toString();

        //index 0' dan başladığı için bizden istenen satıra ulaşabilmek için bir eksiğini alırız

        System.out.println(actualData);

        String konsoldaYazan = "Baku";
        Assert.assertEquals(konsoldaYazan,actualData);

    }
}
