package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-Turkce baskentler sutununu yazdiralim
        int sonsatir = workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum() methodu excel sayfasındaki tüm satir numarasını verir

        System.out.println("Satir sayisi :" + sonsatir);
        String turkceBaskentler = "";
        for (int i = 0; i <= sonsatir ; i++) {
            turkceBaskentler= workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString(); //herbir hucreyi soud un içinde yazdırdık.
            System.out.println(turkceBaskentler);

        }
    }
}
