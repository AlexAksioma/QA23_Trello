package tests;

import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardTests extends TestBase {

    @BeforeClass
    public void login() {  //"aksiomamedved@gmail.com","AlexMed123!"
        app.getHelperUser().loginDTO(user);
    }

    @Test
    public void addNewBoardPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("board" + i)
                .build();
        app.getHelperBoards().createNewBoard(board);
        Assert.assertTrue(app.getHelperBoards().isBoardTitlePresent(board.getBoardTitle()));
    }

    @Test
    public void deleteBoardPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("board_del" + i)
                .build();
        app.getHelperBoards().createNewBoard(board);
        app.getHelperBoards().clickButtonBoards();

        app.getHelperBoards().deleteBoard(board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoards().isTextMessagePresentByText());

    }

    @Test
    public void deleteBoardPositiveTest1() {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("board_del" + i)
                .build();
        app.getHelperBoards().createNewBoard(board);
        app.getHelperBoards().clickButtonBoards();

        app.getHelperBoards().deleteBoard(board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoards().isTextMessagePresentByText());

    }

    @AfterMethod
    public void afterMethod() {
        if (app.getHelperBoards().isElementPresent_buttonBoards())
            app.getHelperBoards().clickButtonBoards();
    }
}
