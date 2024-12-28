package play;

public class ComputerPlayer extends Player {

    private ComputerService computerService = new ComputerService();

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(char[][] board, int winningLength) {

        char symbol = getSymbol();

        int[][] moveChecks = {
            computerService.checkWin(symbol, board, winningLength), 
            computerService.blockOpponent(symbol, board, winningLength),
            computerService.checkCenter(board), 
            computerService.checkCorners(board)
        };

        for (int[] move : moveChecks) {
            if (move != null) {
                return move;
            }
        }

        return computerService.findAvailableIndex(board);  
    }
    
}
