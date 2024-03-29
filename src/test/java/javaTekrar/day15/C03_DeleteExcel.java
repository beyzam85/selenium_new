package javaTekrar.day15;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //Olusturmuş olduğumuz dosyayı sistemde işleme alır
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //Workbook objesiyle fis oblesi ile akışa aldığımız dosyamızla bir excell dosyası create ettik
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); //Excel dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(2); // Sayfa bir deki 3. satırı bu şekilde seçeriz
        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(2); // Satır seçimi yapıldıktan sonra hücre seçimi bu şekilde yapılır
        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);

        /*
        Bir cell'deki veriyi silmek için row objesine ihtiyac vardır.
        row objesi ile removeCell() methodunu kullanarak cell objesi ile belirttimiz cell değerini silebiliriz
         */

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);//hucredeki bir veriyi silmek aslında o hucreye null degeri yazmak demektir
                            // yani ilk biçimine donmesi dmektir(silmek yazmak demektir)
        System.out.println(cell.toString());
    }
}