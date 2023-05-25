package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeWork extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {


        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");


        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.
                getSheet("Sayfa1").
                getRow(0).
                getCell(1).
                toString());


          // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
          String birinciSatirIkinciHucre = workbook.
                  getSheet("Sayfa1").
                  getRow(0).
                  getCell(1).
                  toString();
          System.out.println(birinciSatirIkinciHucre);

          // 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
          String expectedAfganistanBaskenti = "Kabil";
          String actualAfganistanBaskenti = workbook.
                  getSheet("Sayfa1").
                  getRow(1).
                  getCell(3).
                  toString();
          Assert.assertEquals(expectedAfganistanBaskenti, actualAfganistanBaskenti);

          // Satir sayisini bulalim
          int satirSayisi = workbook.
                  getSheet("Sayfa1").
                  getLastRowNum() +1 ;
          System.out.println(satirSayisi);

          // Fiziki olarak kullanilan satir sayisini bulun
          int fizikiOlarakKullanilanSatirSayisi = workbook.
                  getSheet("Sayfa1").
                  getPhysicalNumberOfRows();
          System.out.println(fizikiOlarakKullanilanSatirSayisi);

          // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap = new HashMap<>();

        int sonSatirIndex = workbook.
                getSheet("sayfa1").
                getLastRowNum();

        for (int i = 0; i <= sonSatirIndex; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);






    }
}