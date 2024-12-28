package play;

import java.util.Scanner;

public class GameRepository {

    private BoardModifier boardModifier = new BoardModifier();

    public int getGameType() {
        Scanner sc = new Scanner(System.in);
        int gameType = -1;
        
        System.out.println("What game type do you want to play?\n" +
                "Enter 1 for person vs person\n" +
                "Enter 2 for person vs computer\n" +
                "Enter 3 for computer vs computer");
        
        while (true) {
            if (sc.hasNextInt()) {
                gameType = sc.nextInt();

                if (gameType >= 1 && gameType <= 3) {
                    break;
                } 
                else {
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        return gameType;
    }

    public int getSize() {
        Scanner sc = new Scanner(System.in);
        int size = 0;

        System.out.println("What size board do you want?");

        while (true) {
            if (sc.hasNextInt()) {
                size = sc.nextInt();

                if (size >= 3 && size <= 20) {
                    break;
                } 
                else {
                    System.out.println("Invalid option (3 - 20).");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        return size;
    }

    public int getWinningLength(int boardSize) {

        Scanner sc = new Scanner(System.in);
        int winningLength = 0;

        System.out.println("How many markers in a straight line are needed to win the game?");

        while (true) {
            if (sc.hasNextInt()) {
                winningLength = sc.nextInt();

                if (winningLength <= boardSize) {
                    break;
                } 
                else {
                    System.out.println("The winning length must be less than or equal to the board size.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        return winningLength;

    }

    public void printInstructions(int boardSize) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Players take turns entering a number to mark a spot on the board.");
        System.out.println("The board layout is as follows:");
    
        int label = 1;
    
        StringBuilder rowDivider = new StringBuilder();
        for (int k = 0; k < boardSize; k++) {
            rowDivider.append("----");
            if (k < boardSize - 1) rowDivider.append("|");
        }
    
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.printf(" %2d ", label);
                if (j < boardSize - 1) System.out.print("|");
                label++;
            }
            System.out.println();
            if (i < boardSize - 1) System.out.println(rowDivider.toString());
        }
    
        System.out.println("To make a move, enter the number corresponding to an empty spot on the board.");
    }
    
    

    public boolean checkWin(char symbol, int winningLength, char[][] board) {
        //boolean win = false;
        int size = board.length;

        for(int i = 0; i < size - winningLength; i++) {
            for(int j = 0; j < size - winningLength; j++) {

                if (boardModifier.checkSubBoard(symbol, boardModifier.getSubBoard(board, i, j, winningLength))) {
                    return true;
                }

            }
        }

        return false;
    }
}
