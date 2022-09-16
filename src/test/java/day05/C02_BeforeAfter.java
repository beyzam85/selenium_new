package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {


    // @Before kullaniyorsak method icin istedigimiz ismi kullanabiliriz ancak genel olarak kullanımı setUp seklindedir
    //@Before kullandığımızda testlerimizden önce yapmak zorunda oldugumuz driver objelerini yazmak yerine @Before ile bir kere yazarız
    //yani her testten önce burayı calıstır, sonra testlerimizi calıstır.
    // diğer testlerimizde rahat kullanabilmek icin bunu class seviyesinde tanımlamamız gerekir.
    //driver objesini direk kullanabilmek icin class seviyesine WebDriver driver yaz!!

    WebDriver driver;

    @After
    //After notasyonu her testten sonra calısır
    public void tearDown() {
        driver.close();
    }

    @Before
    //Before notasyonu her testten once calısır
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void method1() {
        //oncesinde 1 defda before methodu calısır
        driver.get("https://amazon.com");
        //sonra 1defa da after methodu calısır
    }

    @Test
    public void method2() {
        //oncesinde 1 defda before methodu calısır
        driver.get("https://techproeducation.com");
        //sonra 1defa da after methodu calısır
    }

    @Test
    public void method3() {
        //oncesinde 1 defda before methodu calısır
        driver.get("https://hepsiburada.com");
        //sonra 1defa da after methodu calısır
    }
}

/*
    bir class da;
     -->@before ile olusturulan method class icindeki her test method'undan once ve 1 kez calisir ve
     genellikle public  void setup() seklinde yazilir
     -->@after ile olusturlan method class icindeki her test method'undan sonra ve 1 kez calisir ve
     genellikle public void tearDown() seklinde yazilir

     her testte 3 metthod calısmaktadır

     javada ki gibi değionune ne yazdıysak once o calısır asagıdan yukarı calısmaz

     */