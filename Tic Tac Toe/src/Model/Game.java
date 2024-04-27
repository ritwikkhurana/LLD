package Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Deque<Player> players;
    public Board board;

    public Game() {
        initializeGame();
    }

    public void initializeGame() {
        // Initializing Two Players with Peice X and O;
        players = new ArrayDeque<>();
        // Player1
        PlayingPeice crossPeice = new PlayingPeiceX();
        Player player1 = new Player("Player1", crossPeice);

        // Player 2
        PlayingPeice noughtPeice = new PlayingPeiceO();
        Player player2 = new Player("Player2", noughtPeice);

        this.players.addLast(player1);
        this.players.addLast(player2);

        // Initializing Board of Size 3
        this.board = new Board(3);

    }

    public String startGame() {

        while (true) {
            Player player = players.removeFirst();

            board.printBoard();
            // Get free cell
            boolean isFreeCell = board.getFreeCell();
            if (!isFreeCell) {
                break;
            }

            // Ask input from Player
            System.out.print("Player:" + player.name + " Enter row,column: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            String[] values = s.split(",");
            Integer row = Integer.valueOf(values[0]);
            Integer col = Integer.valueOf(values[1]);

            // Check if input is valid
            boolean peiceAddedSuccessfully = board.addPeice(row, col, player.playingPeice);
            if (!peiceAddedSuccessfully) {
                System.out.println("Invalid Input. Please select another position");
                players.addFirst(player);
                continue;
            }
            players.addLast(player);
            boolean hasWon = board.isWinner(row, col, player.playingPeice);
            if (hasWon) {
                board.printBoard();
                return player.name;
            }
        }
        return "Tie";
    }
}
