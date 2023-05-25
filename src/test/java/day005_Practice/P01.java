package day005_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

public class P01 extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ali");

        //fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kaya");


        //check the gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();

        //check the experience
        driver.findElement(By.xpath("//input[@id='exp-0']")).click();

        //fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("02.02.2022");

        //choose your profession -> Automation Tester
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();

        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();

        //choose your continent -> Antartica
      // WebElement dropDownContinent = driver.findElement(By.xpath("//select[@id='continents']"));
      // Select select = new Select(dropDownContinent);
      // select.deselectByVisibleText("Antartica");

        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Antartica");


        //choose your command  -> Browser Commands
       // driver.findElement(By.xpath("(//option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;'])[1]")).click();
        driver.findElement(By.xpath("//select[@id='selenium_commands']/option[1]")).click();

        //click submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

    }

}




