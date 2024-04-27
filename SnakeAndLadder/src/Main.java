import Model.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Starting the Game. Please enter Board size and Dice count: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(",");
        Game game = new Game(Integer.valueOf(inputs[0]), Integer.valueOf(inputs[1]));
        System.out.println("And the Winner is Player No: " + game.startGame().getId());
    }
}