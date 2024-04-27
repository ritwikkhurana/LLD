package Model;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int boardSize;
    Cell[][] cell;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        this.boardSize = boardSize;
        cell = new Cell[boardSize][boardSize];

        for (int i = 0 ; i < boardSize ; i++) {
            for (int j = 0 ; j < boardSize ; j++) {
                Cell newCell = new Cell();
                this.cell[i][j] = newCell;
            }
        }

        // Setting the Snakes
        while (numberOfSnakes > 0) {
            int snakeStart = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize-1);
            int snakeEnd = ThreadLocalRandom.current().nextInt(1, snakeStart+1);
            if (snakeStart == snakeEnd) continue;

            Jump jump = new Jump();
            jump.setStart(snakeStart);
            jump.setEnd(snakeEnd);
            Cell startCell = getCell(snakeStart);
            startCell.setJump(jump);
            numberOfSnakes--;

        }

        // Setting the Ladders
        while (numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(ladderStart-1, boardSize*boardSize);
            if (ladderStart == ladderEnd) continue;

            Jump jump = new Jump();
            jump.setStart(ladderStart);
            jump.setEnd(ladderEnd);
            Cell startCell = getCell(ladderStart);
            startCell.setJump(jump);
            numberOfLadders--;
        }
    }

    public Cell getCell(int cellNo) {
        int row = cellNo / boardSize;
        int col = row%2==0 ? (cellNo%boardSize) : (boardSize-1-(cellNo%boardSize));
        return cell[row][col];
    }
}
