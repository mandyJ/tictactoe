import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private Board board;
    private TicTacToe tictactoe;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        tictactoe = new TicTacToe(board, printStream, bufferedReader);
    }

    @Test
    public void shouldDrawBoardWhenStart() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        tictactoe.start();

        verify(board, times(3)).drawBoard();
    }

    //'After'.. we aren't testing for order in a lot of these!
    @Test
    public void shouldPromptForUsersMoveAfterBoardIsDrawn() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        tictactoe.start();
        verify(printStream,times(2)).println("Please enter number of a location you would like to play:");

    }

    @Test
    public void shouldGetUsersMoveAfterPrompting() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        tictactoe.start();

        verify(bufferedReader,times(2)).readLine();

    }

    @Test
    public void shouldRedrawBoardAfterUserSelectsLocation() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        tictactoe.start();

        verify(board,times(3)).drawBoard();
        verify(board).updateP1(1);

    }

    @Test
    public void shouldRepeatAllOfTheAboveForNextPlayer() throws IOException{
        when(bufferedReader.readLine()).thenReturn("1");

        tictactoe.start();

        verify(board,times(3)).drawBoard();
        verify(board).updateP1(1);
    }



}