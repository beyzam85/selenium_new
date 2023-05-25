package day004_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {
    @Test
    public void verify() {

        //Verify that we have pom.xml file in our project =>please try in 4 min

        //String path = "pom.xml";

        String path = "C:\\Users\\ASUS\\IdeaProjects\\Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));

    }
}
