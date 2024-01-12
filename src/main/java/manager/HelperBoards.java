package manager;

import models.BoardDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoards extends HelperBase{
    public HelperBoards(WebDriver driver) {
        super(driver);
    }
    By buttonCreateNewBoard = By.xpath("//li[@data-testid='create-board-tile']//span");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");
    By buttonCreateBoard = By.xpath("//button[@data-testid='create-board-submit-button']");
    By boardNameDisplay = By.xpath("//h1[@data-testid='board-name-display']");
    By buttonBoards = By.cssSelector("a[data-testid='open-boards-link']");

    public void createNewBoard(BoardDTO board) {
        clickBase(buttonCreateNewBoard);
        typeBase(inputBoardTitle, board.getBoardTitle());
        pause(3);
        clickBase(buttonCreateBoard);
    }

    public boolean isBoardTitlePresent(String text){
        return isTextInElementEquals(boardNameDisplay, text);
    }

    public void clickButtonBoards(){
        clickBase(buttonBoards);
    }
}
