package play;

public class ComputerRepository {

    public int[] checkRow(char symbol, char[][] board) {

        int size = board.length;

        for (int i = 0; i < size; i++) {
            int count = 0;
            int available = -1;
            for (int j = 0; j < size; j++) {
                if (board[i][j] == symbol) {
                    count++;
                } 
                else if (board[i][j] == ' ') {
                    available = j;
                }
            }
            if (count == size - 1 && available >= 0) {
                return new int[]{i, available};
            }
        }

        return null;
    }

    public int[] checkColumn(char symbol, char[][] board) {

        int size = board.length;

        for (int j = 0; j < size; j++) {
            int count = 0;
            int available = -1;
            for (int i = 0; i < size; i++) {
                if (board[i][j] == symbol) {
                    count++;
                } 
                else if (board[i][j] == ' ') {
                    available = i;
                }
            }
            if (count == size - 1 && available >= 0) {
                return new int[]{available, j};
            }
        }

        return null;
    }

    public int[] checkDiagonal(char symbol, char[][] board) {

        int size = board.length;
        int count = 0;
        int availableRow = -1;
        int availableCol = -1;

        for (int i = 0; i < size; i++) {
            if (board[i][i] == symbol) {
                count++;
            } else if (board[i][i] == ' ') {
                availableRow = i;
                availableCol = i;
            }
        }
        if (count == size - 1 && availableRow >= 0) {
            return new int[]{availableRow, availableCol};
        }
    
        count = 0;
        availableRow = -1;
        availableCol = -1;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] == symbol) {
                count++;
            } else if (board[i][size - 1 - i] == ' ') {
                availableRow = i;
                availableCol = size - 1 - i;
            }
        }
        if (count == size - 1 && availableRow >= 0) {
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
