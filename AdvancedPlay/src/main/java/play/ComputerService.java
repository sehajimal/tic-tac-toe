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

    private BoardModifier boardModifier = new BoardModifier();
    private ComputerRepository computerRepository = new ComputerRepository();

    public int[] checkWin(char symbol, char[][] board, int winningLength) {

        int size = board.length;
        int[] winningIndex = new int[2];

        for(int i = 0; i < size - winningLength; i++) {
            for(int j = 0; j < size - winningLength; j++) {

                int[][] winChecks = {
                    computerRepository.checkDiagonal(symbol, boardModifier.getSubBoard(board, i, j, winningLength)), 
                    computerRepository.checkRow(symbol, boardModifier.getSubBoard(board, i, j, winningLength)),
                    computerRepository.checkColumn(symbol, boardModifier.getSubBoard(board, i, j, winningLength))
                };

                for (int[] winCheck : winChecks) {
                    if (winCheck != null) {

                        //return winCheck;
                        winningIndex[0] = winCheck[0] + i;
                        winningIndex[1] = winCheck[1] + j;

                        return winningIndex;

                    }
                }
            }
        }
        return null;
    }

    public int[] blockOpponent(char symbol, char[][] board, int winningLength) {

        symbol = oppositeSymbols.get(symbol);
        int size = board.length;
        int[] blockIndex = new int[2];

        for(int i = 0; i < size - winningLength; i++) {
            for(int j = 0; j < size - winningLength; j++) {

                int[][] winChecks = {
                    computerRepository.checkDiagonal(symbol, boardModifier.getSubBoard(board, i, j, winningLength)), 
                    computerRepository.checkRow(symbol, boardModifier.getSubBoard(board, i, j, winningLength)),
                    computerRepository.checkColumn(symbol, boardModifier.getSubBoard(board, i, j, winningLength))
                };

                for (int[] winCheck : winChecks) {
                    if (winCheck != null) {

                        //return winCheck;
                        blockIndex[0] = winCheck[0] + i;
                        blockIndex[1] = winCheck[1] + j;

                        return blockIndex;

                    }
                }
            }
        }
        return null;
    }

    int[] checkCenter(char[][] board) {

        int middleIndex = board.length / 2;

        if (computerRepository.checkForEmptyIndex(board, middleIndex, middleIndex)) {
            return new int[]{middleIndex, middleIndex};
        }
        return null;
    }

    int[] checkCorners(char[][] board) {

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
