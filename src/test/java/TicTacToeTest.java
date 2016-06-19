import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private Board board;
    private TicTacToe tictactoe;
    private PrintStream printStream;
    private MoveGetter moveGetter;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        moveGetter = mock(MoveGetter.class);
        printStream = mock(PrintStream.class);

        tictactoe = new TicTacToe(board, moveGetter, printStream);

        when(moveGetter.getMove()).thenReturn(1);
    }

    @Test
    public void shouldDrawBoardWhenStart() throws IOException {

        tictactoe.start();

        verify(board,times(3)).drawBoard();
    }

    //'After'.. we aren't testing for order in a lot of these!
    @Test
    public void shouldGetUsersMoveAfterBoardIsDrawn() throws IOException {
        tictactoe.start();

        verify(board).updateP1(1);
    }

    @Test
    public void shouldRedrawBoardAfterUserSelectsLocation() throws IOException {
        tictactoe.start();

        verify(board,times(3)).drawBoard();
        verify(board).updateP1(1);

    }

    @Test
    public void shouldRepeatAllOfTheAboveForNextPlayer() throws IOException{
        tictactoe.start();

        verify(board,times(3)).drawBoard();
        verify(board).updateP1(1);

        verify(board).updateP2(1);
    }

    @Test
    public void shouldSayGameIsDrawWhenNineValidMovesAreMade() throws IOException {

        tictactoe.start();

        verify(board,times(5)).updateP1(1);
        verify(board,times(4)).updateP2(1);

        verify(printStream).println("Game is draw");

    }

    @Test
    public void shouldCheckBoardForHorizontalWinsAfterEveryMoveMade() throws IOException {

        tictactoe.start();

        verify(board,times(5)).checkHorizontalWin(1);
        verify(board,times(4)).checkHorizontalWin(2);

    }




}