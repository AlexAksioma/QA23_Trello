package manager;

import models.BoardDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBoards extends HelperBase {
    public HelperBoards(WebDriver driver) {
        super(driver);
    }

    By buttonCreateNewBoard = By.xpath("//li[@data-testid='create-board-tile']//span");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");
    By buttonCreateBoard = By.xpath("//button[@data-testid='create-board-submit-button']");
    By boardNameDisplay = By.xpath("//h1[@data-testid='board-name-display']");
    By buttonBoards = By.cssSelector("a[data-testid='open-boards-link']");
    //===================================
    By buttonDots = By.cssSelector("button[aria-label='Show menu']");

    By buttonCloseBoard =
            By.cssSelector("a[class=\"board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board\"]");

    By buttonCloseConfirm = By.cssSelector("input[value='Close']");

    By buttonDeleteBoard = By.cssSelector("button[data-testid='close-board-delete-board-button']");

    By buttonDeleteConfirm = By.cssSelector("button[data-testid='close-board-delete-board-confirm-button']");

    By deleteMessage = By.cssSelector("div[id='FlagGroup']");
    By deleteMessageText = By.xpath("//span[text()='Board deleted.']");
    //=======================================================

    By listBoard = By.xpath("//ul[@class='boards-page-board-section-list']/li");
    //boards-page-board-section-list
    By secondElementListBoard =
            By.xpath("//ul[@class='boards-page-board-section-list']/li[2]");

    public void deleteElementList() {
        List<WebElement> listElements = driver.findElements(listBoard);
        System.out.println("size --> " + listElements.size());
        System.out.println(driver.findElement(listBoard).getTagName());
        for (int i = 0; i < listElements.size(); i++) {
            WebElement element = driver.findElement(secondElementListBoard);
            if (element.getAttribute("data-testid") == null) {
                element.click();
                clickBaseWait(buttonDots, 5);
                clickBaseWait(buttonCloseBoard, 5);
                clickBaseWait(buttonCloseConfirm, 5);
                clickBaseWait(buttonDeleteBoard, 5);
                clickBaseWait(buttonDeleteConfirm, 5);
            }
        }
    }

    public void createNewBoard(BoardDTO board) {
        clickBase(buttonCreateNewBoard);
        typeBase(inputBoardTitle, board.getBoardTitle());
        pause(5);
        clickBase(buttonCreateBoard);
    }

    public boolean isBoardTitlePresent(String text) {
        return isTextInElementEquals(boardNameDisplay, text);
    }

    public void clickButtonBoards() {
        clickBase(buttonBoards);
    }

    public void deleteBoard(String boardTitle) {
        clickBoardOnTitle(boardTitle);
        driver.navigate().refresh();
        clickBase(buttonDots);
        clickBase(buttonCloseBoard);
        clickBase(buttonCloseConfirm);
        clickBase(buttonDeleteBoard);
        clickBase(buttonDeleteConfirm);
    }

    public void clickBoardOnTitle(String boardTitle) {
        String xPathBoardTitle = "//div[@title='" + boardTitle + "']";
        clickBase(By.xpath(xPathBoardTitle));

    }

    public boolean isDeleteMessagePresent() {
        return isTextInElementEquals(deleteMessage, "Board deleted.");
    }

    public boolean isTextMessagePresentByText() {
        return isElementPresent(deleteMessageText);
    }

    public boolean isElementPresent_buttonBoards() {
        return isElementPresent(buttonBoards);
    }
}
