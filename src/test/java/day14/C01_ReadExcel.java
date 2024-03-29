package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel extends TestBaseBeforeAfter {
    @Test
    public void readExcelTest1() throws IOException {
        //1- Dosya yolunu bir String degiskene atayalim
        String doyaYolu = "src/resources/ulkeler.xlsx";

        //2- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(doyaYolu); // oluşturdugumuz dosyayı sistemde işleme alır

        //3- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // Workbook objesiyle fis oblesi ile akışa aldığımız dosyamızla bir excell dosyası create ettik

        //4- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // Excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz ( index de kullanilabilir )

        //5- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa1'deki 3. satırı bu sekilde seceriz

        //6- Cell objesi olusturun row.getCell(index)
          Cell cell = row.getCell(3); // satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir // excel'de index 0'dan baslar !!!
         System.out.println(cell);

        //7- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
          String expectedData = "Cezayir";
          String actualData = cell.toString();

          Assert.assertEquals(expectedData,actualData);
          Assert.assertEquals(expectedData,cell.getStringCellValue());
    }
}