package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
