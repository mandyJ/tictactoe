import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MoveGetterTest {


    private PrintStream printStream;
    private Board board;
    private BufferedReader bufferedReader;
    private MoveGetter moveGetter;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        moveGetter = new MoveGetter(board, printStream, bufferedReader);
    }

    @Test
    public void shouldReturnIntWhenUserInputs() throws IOException {

        when(bufferedReader.readLine()).thenReturn("1");

        assertEquals(1, moveGetter.getMove());

    }

    @Test
    public void shouldKeepAskingForInputWhenUserChoosesSpaceAlreadyPlayed() throws IOException {

        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isNotValid(1)).thenReturn(true,true,false);

        moveGetter.getMove();

        verify(printStream, times(2)).println("Location already taken.");

    }

}