package tests;

import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.getHelperUser().login("aksiomamedved@gmail.com", "AlexMed123!");
        Assert.assertTrue(app.getHelperUser().isElementPresent_buttonAccount());
        //System.out.println("start test");
    }

    @Test
    public void loginPositiveTestDTO(Method method) {
        UserDTO user = UserDTO.builder()
                .email("aksiomamedved@gmail.com")
                .password("AlexMed123!")
                .build();
        logger.info("start method " + method.getName()
                + " with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().loginDTO(user);
        app.getHelperUser().takeScreenShot();
        Assert.assertTrue(app.getHelperUser().isElementPresent_buttonAccount());
        //System.out.println("start test");
    }
}
