import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class TicTacToe {

    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private int usersMove;

    public TicTacToe(Board board, PrintStream printStream, BufferedReader bufferedReader){
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void start() throws IOException {
        board.drawBoard();
        //player1
        promptAndGetMove();
        board.updateP1(usersMove);
        board.drawBoard();
        //player2
        promptAndGetMove();
        board.updateP2(usersMove);
        board.drawBoard();
    }

    private void promptAndGetMove() throws IOException {
        printStream.println("Please enter number of a location you would like to play:");
        String input = bufferedReader.readLine();
        usersMove = parseInt(input);
    }

}
