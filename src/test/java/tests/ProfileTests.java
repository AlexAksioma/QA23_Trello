package tests;

import manager.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)

public class ProfileTests extends TestBase{

    @BeforeClass(alwaysRun = true)
    public void login() {  //"aksiomamedved@gmail.com","AlexMed123!"
        app.getHelperUser().loginDTO(user);
    }

    @Test(groups = {"positive", "smoke"})
    public void changeAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresentByWait_AvatarAdded());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        app.getHelperProfile().returnToHomePage();
    }

    @AfterClass(alwaysRun = true)
    public void logout(){
        app.getHelperUser().logout();
    }

}
