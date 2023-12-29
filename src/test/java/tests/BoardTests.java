package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTests extends TestBase{

    @BeforeClass
    public void login(){
        app.getHelperUser().login("aksiomamedved@gmail.com","AlexMed123!");
    }

    @Test
    public void addNewBoardPositiveTest(){
        System.out.println("first");
    }

    @Test
    public void deleteBoardPositiveTest(){
        System.out.println("second");
    }
}
