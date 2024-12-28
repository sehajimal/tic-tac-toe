package play;

import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private HashMap<Integer, int[]> indexes = new HashMap<>();
    {
        indexes.put(1, new int[] {0, 0});
        indexes.put(2, new int[] {0, 1});
        indexes.put(3, new int[] {0, 2});
        indexes.put(4, new int[] {1, 0});
        indexes.put(5, new int[] {1, 1});
        indexes.put(6, new int[] {1, 2});
        indexes.put(7, new int[] {2, 0});
        indexes.put(8, new int[] {2, 1});
        indexes.put(9, new int[] {2, 2});
    }

    
    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(char[][] board) {

        //char symbol = getSymbol();
        int move;
        int[] index = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter slot");

        while (true) {
            if (sc.hasNextInt()) {
                move = sc.nextInt();

                if (move >= 1 && move <= 9) {
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
