import java.io.PrintStream;

public class Board {

    private PrintStream printStream;
    private String[] spaces = {"1","2","3","4","5","6","7","8","9"};

    public Board(PrintStream printStream){
        this.printStream = printStream;
    }


    public void drawBoard(){
        printStream.println(spaces[0] +"|"+ spaces[1]+ "|" +spaces[2] +"\n-----\n"+ spaces[3]  +"|"+ spaces[4]  +"|"+ spaces[5]  +"\n-----\n"+ spaces[6]  +"|"+ spaces[7]  +"|"+ spaces[8]);
    }

    public void updateP1(int chosenSpace) {
        spaces[chosenSpace-1] = "X";

    }

    public void updateP2(int chosenSpace) {
        spaces[chosenSpace-1] = "o";

    }

    public boolean isNotValid(int chosenSpace) {
        boolean result = false;

        if (spaces[chosenSpace-1] == "o" || spaces[chosenSpace-1] == "X"){
            result = true;
        }

        return result;
    }

    public void checkHorizontalWin(int player) {

    }
}
