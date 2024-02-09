package tests;

import manager.TestNGListener;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)

public class LoginTests extends TestBase {

    @Test(enabled = false)
    public void loginPositiveTest() {
        app.getHelperUser().login("aksiomamedved@gmail.com", "AlexMed123!");
        Assert.assertTrue(app.getHelperUser().isElementPresent_buttonAccount());
        //System.out.println("start test");
    }

    @Test(groups = {"smoke"})
    public void loginPositiveTestDTO(Method method) {
        UserDTO user = UserDTO.builder()
                .email("aksiomamedved@gmail.com")
                .password("AlexMed123!")
                .build();
        logger.info("method " + method.getName()
                + " with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().loginDTO(user);
        //app.getHelperUser().takeScreenShot();
        Assert.assertTrue(app.getHelperUser().isElementPresent_buttonAccount());
        //System.out.println("start test");
    }

    @AfterClass(alwaysRun = true)
    public void logout(){
        app.getHelperUser().logout();
    }
}
