package tech;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] board;
    private static char currentPlayer;
    private static String currentPlayerName;

    public static void main(String[] args) {
        board = new char[3][3];
        currentPlayer = 'X';
        currentPlayerName = "Player 1";
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void playGame() {
        boolean gameEnded = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {
            printBoard();
            playerMove(scanner);
            gameEnded = checkForWin() || checkForDraw();

            if (!gameEnded) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                currentPlayerName = (currentPlayerName.equals("Player 1")) ? "Player 2" : "Player 1";
            }
        }

        scanner.close();
    }

    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playerMove(Scanner scanner) {
        int row = -1;
        int col = -1;

        while (true) {
            System.out.println(currentPlayerName + " (" + currentPlayer + "), enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row < 0 || col < 0 || row > 2 || col > 2) {
                System.out.println("This move is out of bounds. Try again.");
            } else if (board[row][col] != '-') {
                System.out.println("This cell is already occupied. Try again.");
            } else {
                break;
            }
        }

        board[row][col] = currentPlayer;
    }

    private static boolean checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                printBoard();
                System.out.println(currentPlayerName + " wins!");
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                printBoard();
                System.out.println(currentPlayerName + " wins!");
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            printBoard();
            System.out.println(currentPlayerName + " wins!");
            return true;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            printBoard();
            System.out.println(currentPlayerName + " wins!");
            return true;
        }

        return false;
    }

    private static boolean checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        printBoard();
        System.out.println("The game is a draw!");
        return true;
    }
}

