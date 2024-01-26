package tests;

import manager.TestNGListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListener.class)

public class ProfileTests extends TestBase{
    @BeforeClass
    public void login() {  //"aksiomamedved@gmail.com","AlexMed123!"
        app.getHelperUser().loginDTO(user);
    }

    @Test
    public void changeAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar();
    }

}
