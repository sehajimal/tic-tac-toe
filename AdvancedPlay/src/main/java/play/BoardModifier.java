package play;

public class BoardModifier {

    public char[][] getSubBoard(char[][] board, int i, int j, int m) {
    
        char[][] section = new char[m][m];
    
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                section[x][y] = board[i + x][j + y];
            }
        }
    
        return section;
    }
    

    public boolean checkSubBoard(char symbol, char[][] board) {
        int n = board.length;
    
        // check rows
        for (int i = 0; i < n; i++) {
            boolean rowMatch = true;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != symbol) {
                    rowMatch = false;
                    break;
                }
            }
            if (rowMatch) return true;
        }
    
        // check columns
        for (int j = 0; j < n; j++) {
            boolean colMatch = true;
            for (int i = 0; i < n; i++) {
                if (board[i][j] != symbol) {
                    colMatch = false;
                    break;
                }
            }
            if (colMatch) return true;
        }
    
        // check first diagonal
        boolean diagonalMatch1 = true;
        for (int i = 0; i < n; i++) {
            if (board[i][i] != symbol) {
                diagonalMatch1 = false;
                break;
            }
        }
        if (diagonalMatch1) return true;
    
        // check second diagonal
        boolean diagonalMatch2 = true;
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != symbol) {
                diagonalMatch2 = false;
                break;
            }
        }
        if (diagonalMatch2) return true;

        return false;
    }
    
}
