import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class MoveGetter {

    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public MoveGetter(Board board, PrintStream printStream, BufferedReader bufferedReader){
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public int getMove() throws IOException {

        int input = grabAndParseInput();

        while(board.isNotValid(input)){
            printStream.println("Location already taken. \n");
            board.drawBoard();
            input = grabAndParseInput();
        }

        return input;
    }

    private int grabAndParseInput() throws IOException {
        printStream.println("Please enter the number of a location you would like to play:");
        String input = bufferedReader.readLine();
        return parseInt(input);
    }


}
