package First_Practice;

import org.junit.*;

public class C02_JUnit {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
        //Her class da 1. calısır
    }

    @Before
    public void setUp(){
        System.out.println("Before");
        //her testten once calısır
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
        //her classta en son calısır
    }

    @After
    public void tearDown(){
        System.out.println("After");
        //her testte en son calısır
    }



    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }
}











