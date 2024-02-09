package tests;

import dataproviders.DataProviderBoard;
import manager.TestNGListener;
import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Random;

@Listeners(TestNGListener.class)

public class BoardTests extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void login() {  //"aksiomamedved@gmail.com","AlexMed123!"
        logger.info("start method before class --> with data -->" + user.getEmail() + " " + user.getPassword());
        app.getHelperUser().loginDTO(user);
    }

    @Test(dataProvider = "dataProvider_deleteBoardPositiveTest", dataProviderClass = DataProviderBoard.class)
    public void addNewBoardPositiveTest(Method method, BoardDTO board) {
//        int i = new Random().nextInt(1000) + 1000;
//        BoardDTO board = BoardDTO.builder()
//                .boardTitle("board" + i)
//                .build();
        logger.info("start test method --> " + method.getName()
                + " with board title --> " + board.getBoardTitle());
        app.getHelperBoards().createNewBoard(board);
        Assert.assertTrue(app.getHelperBoards().isBoardTitlePresent(board.getBoardTitle()));
    }

    @Test(groups = {"positive"},
            dataProvider = "dataProvider_deleteBoardPositiveTestFile", dataProviderClass = DataProviderBoard.class)
    public void deleteBoardPositiveTest(BoardDTO board) {
//        int i = new Random().nextInt(1000) + 1000;
//        BoardDTO board = BoardDTO.builder()
//                .boardTitle("board_del" + i)
//                .build();
        logger.info("test method with data --> " + board.getBoardTitle());
        app.getHelperBoards().createNewBoard(board);
        app.getHelperBoards().clickButtonBoards();

        app.getHelperBoards().deleteBoard(board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoards().isTextMessagePresentByText());

    }

    @Test(enabled = false)
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
    public void deleteAllBoards() {
        app.getHelperBoards().deleteElementList();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("start after method ");
        if (app.getHelperBoards().isElementPresent_buttonBoards())
            app.getHelperBoards().clickButtonBoards();
    }

    @AfterClass(alwaysRun = true)
    public void logout(){
        app.getHelperUser().logout();
    }
}
