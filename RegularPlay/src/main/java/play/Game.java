package play;

import java.util.Scanner;

public class Game {

    private GameRepository gameRepository = new GameRepository();
    private Board board = new Board();
    private Player player1;
    private Player player2;

    public void setGameType() {

        int gameType = gameRepository.getGameType();

        if (gameType == 1) {
            this.player1 = new HumanPlayer('X');
            this.player2 = new HumanPlayer('O');
        }
        else if (gameType == 2) {
            this.player1 = new HumanPlayer('X');
            this.player2 = new ComputerPlayer('O');
        }
        else if (gameType == 3) {
            this.player1 = new ComputerPlayer('X');
            this.player2 = new ComputerPlayer('O');
        }

        if (gameType == 1 || gameType == 2) {
            gameRepository.printInstructions();
        }
    }

    // public void printInstructions() {
    //     System.out.println("Welcome to Tic-Tac-Toe!");
    //     System.out.println("Players take turns entering a number from 1 to 9 to mark a spot on the board.");
    //     System.out.println("The board layout is as follows:");
    
    //     int label = 1;
    //     for (int i = 0; i < 3; i++) {
    //         for (int j = 0; j < 3; j++) {
    //             System.out.print(" " + label + " ");
    //             if (j < 2) System.out.print("|");
    //             label++;
    //         }
    //         System.out.println();
    //         if (i < 2) System.out.println("---|---|---");
    //     }
    
    //     System.out.println("To make a move, enter the number corresponding to an empty spot on the board.");
    // }    

    public void playGame() {

        int playerTurn = 1;
        Player curr_player;
        boolean gameComplete = false;
        boolean gameWon = false;

        while (!(gameComplete || gameWon)) {

            if (playerTurn == 1) {
                curr_player = player1;
                playerTurn = 2;
            }
            else {
                curr_player = player2;
                playerTurn = 1;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            board.printBoard();
            System.out.println("\nPlayer " + curr_player.getSymbol() + "'s turn\n");

            board.updateBoard(curr_player.getSymbol(), curr_player.makeMove(board.getBoard()));
            
            if (gameRepository.hasThreeInRow(curr_player.getSymbol(), board.getBoard())) {
                System.out.println("Player " + curr_player.getSymbol() + " wins!\n");
                gameWon = true;
            }
            if (board.isBoardComplete()) {
                gameComplete = true;
            }
        }

        if (gameComplete) {
            System.out.println("Tie game!\n");
        }

        board.printBoard();
        restartGame();
    }

    private void restartGame() {
        Scanner scanner = new Scanner(System.in);
        String response;

        while (true) {
            System.out.print("Do you want to restart the game? (Y/N): ");
            response = scanner.nextLine().trim().toUpperCase();

            if (response.equals("Y")) {
                board.clearBoard();
                playGame();
            } else if (response.equals("N")) {
                return;
            } else {
                System.out.println("Invalid response. Please enter 'Y' or 'N'.");
            }
        }
    }
}
