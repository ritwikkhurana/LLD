package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    Board board;
    Deque<Player> players;
    Dice dice;
    Player winner;

    public Game(int size, int diceCount) {
        initializeGame(size, diceCount);
    }

    public void initializeGame(int size, int diceCount) {
        board = new Board(size, 5, 4);
        dice = new Dice(diceCount);
        winner = null;
        players = new ArrayDeque<>();
        Player player1 = new Player(1, 0);
        Player player2 = new Player(2, 0);
        players.addLast(player1);
        players.addLast(player2);
    }

    public Player startGame() {
        while (winner == null) {
            Player currPlayer = getPlayerTurn();
            System.out.println("Player Turn is: " + currPlayer.getId() + " and current position is: " + currPlayer.getCurrPos());
            int posToSkip = dice.rollDice();
            System.out.println("Dice Rolled Value: " + posToSkip);
            jumpToPos(currPlayer, posToSkip);
            System.out.println("Player: " + currPlayer.getId() + " new position is: " + currPlayer.getCurrPos());
            if (currPlayer.currPos >= board.boardSize*board.boardSize) winner = currPlayer;
        }
        return winner;
    }

    public Player getPlayerTurn() {
        Player currPlayer = players.removeFirst();
        players.addLast(currPlayer);
        return  currPlayer;
    }

    public void jumpToPos(Player player, int posToSkip) {
        player.currPos += posToSkip;
        if (player.currPos >= board.boardSize* board.boardSize) return;
        Cell currCell = board.getCell(player.currPos);
        if (currCell.getJump() != null && currCell.getJump().getStart() == player.currPos) {
            System.out.println("Jump By: " + (currCell.getJump().getStart() < currCell.getJump().getEnd() ? "Ladder" : "Snake"));
            player.currPos = currCell.getJump().getEnd();
        }
    }
}
