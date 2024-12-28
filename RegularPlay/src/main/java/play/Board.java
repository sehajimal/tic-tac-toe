package play;

public class Board {

    private char[][] board = {
        {' ', ' ', ' '}, 
        {' ', ' ', ' '}, 
        {' ', ' ', ' '}
    };

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
    
            if (i < board.length - 1) {
                for (int k = 0; k < board.length; k++) {
                    System.out.print("___");
                    if (k < board.length - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }
    }

    public void updateBoard(char symbol, int[] index) {

        this.board[index[0]][index[1]] = symbol;

    }

    public boolean isBoardComplete() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
}
