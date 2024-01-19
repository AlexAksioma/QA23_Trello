package manager;

import org.openqa.selenium.*;


import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HelperBase {
    WebDriver driver;
    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }
    By buttonAccount = By.xpath("//button[@data-testid='header-member-menu-button']");

    private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        return driver.findElements(locator);
    }
    public void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator){
        WebElement element = findElementBase(locator);
        element.click();
    }

    public void typeBase(By locator, String text){
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
        //return driver.findElements(locator).size()>0;
    }

    public boolean isTextInElementEquals(By locator, String text){
        WebElement element = findElementBase(locator);
        return element.getText().equals(text);
    }

    public void takeScreenShot(){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scrFile, new File(createFileNameScreenShot()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String createFileNameScreenShot(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        String currentDate = formatter.format(date);
        System.out.println(currentDate);
        String fileName = currentDate.replace(":","-");
        System.out.println(fileName);
        String filePath = "src/test_logs/screenshots/screenshot_"+fileName+".png";
        return filePath;
    }


}
