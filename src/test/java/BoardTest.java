import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    //Do I even need this test? Testing for functionality here
    @Test
    public void shouldDrawBoard(){
        board.drawBoard();
        verify(printStream).println(contains("1|2|3\n-----\n4|5|6\n-----\n7|8|9"));

    }

    @Test
    public void shouldDrawXonPlayerOnesLocationAfterSpacesAreUpdated(){
        board.updateP1(1);
        board.drawBoard();

        verify(printStream).println(contains("X|2|3\n-----\n4|5|6\n-----\n7|8|9"));
    }

    @Test
    public void shouldDrawOonPlayerTwosLocationAfterSpacesAreUpdated(){
        board.updateP1(1);
        board.drawBoard();

        board.updateP2(5);
        board.drawBoard();

        verify(printStream).println(contains("X|2|3\n-----\n4|o|6\n-----\n7|8|9"));

    }

    @Test
    public void shouldReturnNotValidSpaceIfSpaceAlreadyTaken(){
        board.updateP1(1);

        assertEquals(true, board.isNotValid(1));

    }







}