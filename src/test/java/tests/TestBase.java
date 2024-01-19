package tests;

import manager.ApplicationManager;
import models.UserDTO;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    UserDTO user = UserDTO.builder()
            .email("aksiomamedved@gmail.com")
            .password("AlexMed123!")
            .build();

    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        //app.stop();
    }
}
