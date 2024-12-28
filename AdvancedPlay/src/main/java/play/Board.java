package play;

public class Board {

    private char[][] board;
    private int size;

    public Board(int n) {
        if (n > 20 || n < 3) {
            throw new IllegalArgumentException("Board size must be between 3 and 20.");
        }
        
        this.size = n;
        this.board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
    
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("___");
                    if (k < size - 1) {
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return this.size;
    } 

    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
}
