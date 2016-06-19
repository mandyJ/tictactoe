import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String [ ] args) throws IOException {

        PrintStream printStream = System.out;
        Board board = new Board(printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MoveGetter moveGetter = new MoveGetter(board, printStream,bufferedReader);
        TicTacToe tictactoe = new TicTacToe(board, moveGetter,printStream);

        tictactoe.start();


    }
}
