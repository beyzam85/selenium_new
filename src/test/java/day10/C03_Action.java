package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Action extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // - Amazon sayfasına gidelim
        // - Account menusundan create a list linkine tıklayalım

        driver.get("https://amazon.com");
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver); //Action mouse ile ilgili işlemleri yapmak için kullanılıyor
        actions.moveToElement(accountList).perform();//mouse accountList uzerine gidip bekle
        Thread.sleep(2000);

        //-->actions.perform();//imleci gidip account un uzerine gitmesi ve ebeklemesi
        //-->actions.moveToElement();//mouse ..üzerine gidip bekle
        //-->actions.dragAndDrop();//eleemnti surukle ve birak
        //-->actions.contextClick();//sagtus
        //-->actions.clickAndHold()//tut ve bekle

        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }

    }

