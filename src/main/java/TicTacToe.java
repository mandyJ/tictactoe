import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class TicTacToe {

    private Board board;
    private PrintStream printStream;
    private MoveGetter moveGetter;

    public TicTacToe(Board board,  MoveGetter moveGetter, PrintStream printStream){
        this.board = board;
        this.printStream = printStream;
        this.moveGetter = moveGetter;
    }

    public void start() throws IOException {
        board.drawBoard();

        for(int i=0; i<4; i++){
            board.updateP1(moveGetter.getMove());
            board.drawBoard();
            board.checkHorizontalWin(1);

            board.updateP2(moveGetter.getMove());
            board.drawBoard();
            board.checkHorizontalWin(2);
        }

        board.updateP1(moveGetter.getMove());
        board.drawBoard();
        board.checkHorizontalWin(1);

        printStream.println("Game is draw");
    }

}
