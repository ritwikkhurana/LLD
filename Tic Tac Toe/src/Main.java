import Model.Game;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game();
        System.out.println("So, the winner is: " + newGame.startGame());
    }
}