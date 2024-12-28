package play;

import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private HashMap<Integer, int[]> indexes = new HashMap<>();

    
    public HumanPlayer(char symbol, int boardSize) {
        super(symbol);

        int index = 1;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.indexes.put(index, new int[] {i, j});
                index++;
            }
        }
    }

    @Override
    public int[] makeMove(char[][] board, int winningLength) {

        int move;
        int[] index = null;
        int maxIndex = board.length * board.length;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter slot");

        while (true) {
            if (sc.hasNextInt()) {
                move = sc.nextInt();

                if (move >= 1 && move <= maxIndex) {
                    index = indexes.get(move);
                    if (board[index[0]][index[1]] == ' ') {
                        break;
                    }
                    else {
                        System.out.println("Slot already taken");
                    }
                } 
                else {
                    System.out.println("Invalid option. Please enter valid index.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        
        //sc.close();
        return index;
    }

}
