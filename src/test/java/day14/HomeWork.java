package java_tekrar.day14;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
public class HomeWork {

    @Test

    public void readExcelTest1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        int satirSayisi = (workbook.getSheet("Sayfa2").getLastRowNum()) + 1;                        // en kısa
        int sutunSayisi = workbook.getSheet("Sayfa2").getRow(satirSayisi - 1).getLastCellNum();  // cozum

        System.out.println("satirSayisi = " + satirSayisi);
        System.out.println("sutunSayisi = " + sutunSayisi);

        // int satirStunToplam = satirSayisi + sutunSayisi; // Tek Assert icin
        // Assert.assertEquals(satirStunToplam, 9);

        Assert.assertEquals(satirSayisi,6);
        Assert.assertEquals(sutunSayisi,3);
    }
}
