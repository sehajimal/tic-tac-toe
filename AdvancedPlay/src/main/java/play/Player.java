package play;

public abstract class Player {

    private char symbol;

    protected Player(char symbol) {
        this.symbol = symbol;
    }

    public abstract int[] makeMove(char[][] board, int winningLength);

    public char getSymbol() {
        return symbol;
    }  
}
