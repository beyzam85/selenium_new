package javaTekrar.day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test1() throws IOException {

        //Yeni bir Class olusturalim WriteExcel
        // Yeni bir test method olusturalim writeExcelTest()
        String dosyaYolu ="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        // Adimlari takip ederek 1.satira kadar gidelim
        //5.hucreye yeni bir cell olusturalim
        // Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");

        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        workbook.write(fos);//dosyayı kaydetmek gerekir yadırırız write methodu ile

        // Excel dosyamıza veri girişi yaptıktan sonra dosyayı akışa aldığımız gibi sonlandırmamız gerekir.
        // Sonrasında da workbook objemize kayıt etmemiz gerekir

        // 10)Dosyayi kapatalim
        fis.close();//dosyaya ulaşma yayınını kapattık
        fos.close();//dosyaya veri girişi yayınını kapattık
        workbook.close();// workbook u kapattık.

    }

}
