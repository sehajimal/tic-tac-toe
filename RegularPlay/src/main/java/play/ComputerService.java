package play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ComputerService {

    private HashMap<Character, Character> oppositeSymbols = new HashMap<Character, Character>() {{
        put('X', 'O');
        put('O', 'X');
    }};


    private ComputerRepository computerRepository = new ComputerRepository();

    public int[] checkWin(char symbol, char[][] board) {

        int[][] winChecks = {
            computerRepository.checkDiagonal(symbol, board), 
            computerRepository.checkRow(symbol, board),
            computerRepository.checkColumn(symbol, board)
        };

        for (int[] winCheck : winChecks) {
            if (winCheck != null) {
                return winCheck;
            }
        }
        return null;
    }

    public int[] blockOpponent(char symbol, char[][] board) {

        symbol = oppositeSymbols.get(symbol);

        int[][] blockChecks = {
            computerRepository.checkDiagonal(symbol, board), 
            computerRepository.checkRow(symbol, board),
            computerRepository.checkColumn(symbol, board)
        };

        for (int[] blockCheck : blockChecks) {
            if (blockCheck != null) {
                return blockCheck;
            }
        }
        return null;
    }

    public int[] checkCenter(char[][] board) {

        int middleIndex = board.length / 2;

        if (computerRepository.checkForEmptyIndex(board, middleIndex, middleIndex)) {
            return new int[]{middleIndex, middleIndex};
        }
        return null;
    }

    public int[] checkCorners(char[][] board) {

        int n = board.length;

        int[][] corners = {{0, 0}, {0, n - 1}, {n - 1, 0}, {n - 1, n - 1}};

        for (int[] corner : corners) {
            int row = corner[0];
            int col = corner[1];
            if (computerRepository.checkForEmptyIndex(board, row, col)) {
                return new int[]{row, col};
            }
        }
        
        return null;
    }

    public int[] findAvailableIndex(char[][] board) {
        int n = board.length;
        List<int[]> emptySlots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computerRepository.checkForEmptyIndex(board, i, j)) {
                    emptySlots.add(new int[]{i, j});
                }
            }
        }

        if (emptySlots.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(emptySlots.size());
        return emptySlots.get(randomIndex);
    }
    
}
