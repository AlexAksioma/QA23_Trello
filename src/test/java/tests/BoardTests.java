package tests;

import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

public class BoardTests extends TestBase {

    @BeforeClass
    public void login() {  //"aksiomamedved@gmail.com","AlexMed123!"
        logger.info("start method before class --> with data -->" +user.getEmail()+ " "+ user.getPassword());
        app.getHelperUser().loginDTO(user);
    }

    @Test
    public void addNewBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("board" + i)
                .build();
        logger.info("start test method --> "+method.getName()
                +" with board title --> "+board.getBoardTitle());
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

    @Test
    public void deleteAllBoards(){
        app.getHelperBoards().deleteElementList();
    }

    @AfterMethod
    public void afterMethod() {
        logger.info("start after method ");
        if (app.getHelperBoards().isElementPresent_buttonBoards())
            app.getHelperBoards().clickButtonBoards();
    }
}
