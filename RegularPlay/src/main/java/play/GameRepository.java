package play;

import java.util.Scanner;

public class GameRepository {

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

    public void printInstructions() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Players take turns entering a number from 1 to 9 to mark a spot on the board.");
        System.out.println("The board layout is as follows:");
    
        int label = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + label + " ");
                if (j < 2) System.out.print("|");
                label++;
            }
            System.out.println();
            if (i < 2) System.out.println("---|---|---");
        }
    
        System.out.println("To make a move, enter the number corresponding to an empty spot on the board.");
    }  

    public boolean hasThreeInRow(char symbol, char[][] board) {
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
