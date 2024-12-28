package play;

public class ComputerRepository {

    public int[] checkRow(char symbol, char[][] board) {

        for (int i = 0; i < board.length; i++) {
            int count = 0;
            int available = -1;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == symbol) {
                    count++;
                } 
                else if (board[i][j] == ' ') {
                    available = j;
                }
            }
            if (count == 2 && available >= 0) {
                return new int[]{i, available};
            }
        }

        return null;
    }

    public int[] checkColumn(char symbol, char[][] board) {

        for (int j = 0; j < board.length; j++) {
            int count = 0;
            int available = -1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == symbol) {
                    count++;
                } 
                else if (board[i][j] == ' ') {
                    available = i;
                }
            }
            if (count == 2 && available >= 0) {
                return new int[]{available, j};
            }
        }

        return null;
    }

    public int[] checkDiagonal(char symbol, char[][] board) {
        int n = board.length;
        int count = 0;
        int availableRow = -1;
        int availableCol = -1;

        for (int i = 0; i < n; i++) {
            if (board[i][i] == symbol) {
                count++;
            } else if (board[i][i] == ' ') {
                availableRow = i;
                availableCol = i;
            }
        }
        if (count == 2 && availableRow >= 0) {
            return new int[]{availableRow, availableCol};
        }
    
        count = 0;
        availableRow = -1;
        availableCol = -1;
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] == symbol) {
                count++;
            } else if (board[i][n - 1 - i] == ' ') {
                availableRow = i;
                availableCol = n - 1 - i;
            }
        }
        if (count == 2 && availableRow >= 0) {
            return new int[]{availableRow, availableCol};
        }
    
        return null;
    }
    
    public boolean checkForEmptyIndex(char[][] board, int rowIndex, int columnIndex) {

        if (board[rowIndex][columnIndex] == ' ') {
            return true;
        }
        return false;
    }

}
