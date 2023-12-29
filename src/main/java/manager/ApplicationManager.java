package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    HelperUser helperUser;
    HelperBoards helperBoards;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com/home");
        helperUser = new HelperUser(driver);
        helperBoards = new HelperBoards(driver);
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoards getHelperBoards() {
        return helperBoards;
    }

    public void stop() {
        driver.quit();
    }


}
