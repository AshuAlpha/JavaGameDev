package tech;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        // Start
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};

        while (true) {
            // Get user choice
            System.out.println("Enter your move (rock, paper, scissors). To exit the game, type 'exit': ");
            String userMove = scanner.nextLine().toLowerCase();

            if (userMove.equals("exit")) {
                break;
            }

            // Validate user input
            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            // Get computer choice
            int computerMoveIndex = random.nextInt(3);
            String computerMove = choices[computerMoveIndex];
            System.out.println("Computer move: " + computerMove);
            printAsciiArt(computerMove);

            // Compare user and computer choices to determine winner
            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (userMove.equals("rock") && computerMove.equals("scissors") ||
                    userMove.equals("paper") && computerMove.equals("rock") ||
                    userMove.equals("scissors") && computerMove.equals("paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }

            // Display result and ask user if they want to play again
            System.out.println("Do you want to play again? (yes or no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Exit
        scanner.close();
        System.out.println("Thank you for playing!");
    }

    public static void printAsciiArt(String move) {
        String rock = """
                       _______
                    ---'   ____)
                          (_____)
                          (_____)
                          (____)
                    ---.__(___)
                    """;

        String paper = """
                        _______
                    ---'    ____)____
                               ______)
                              _______)
                             _______)
                    ---.__________)
                    """;

        String scissors = """
                        _______
                    ---'   ____)____
                               ______)
                            __________)
                           (____)
                    ---.__(___)
                    """;

        switch (move) {
            case "rock":
                System.out.println(rock);
                break;
            case "paper":
                System.out.println(paper);
                break;
            case "scissors":
                System.out.println(scissors);
                break;
        }
    }
}

