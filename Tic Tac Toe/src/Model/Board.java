package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingPeice[][] board;

    Board(int size) {
        this.size = size;
        board = new PlayingPeice[size][size];
    }

    public boolean addPeice(int row, int col, PlayingPeice playingPeice) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = playingPeice;
        return true;
    }

    public boolean getFreeCell() {
        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                if (board[i][j] == null) return true;
            }
        }
        return false;
    }

    public boolean isWinner(int row, int col, PlayingPeice playingPeice) {
        boolean rowCheck = true;
        boolean colCheck = true;
        boolean diagCheck = true;
        boolean antDiagCheck = true;

        // Check Row
        for (int i = 0 ; i < size ; i++) {
            if (board[row][i] == null || board[row][i] != playingPeice) {
                rowCheck = false;
                break;
            }
        }

        // Check Column
        for (int i = 0 ; i < size ; i++) {
            if (board[i][col] == null || board[i][col] != playingPeice) {
                colCheck = false;
                break;
            }
        }

        // Check Diagonal
        if (row == col) {
            for (int i = 0 ; i < size ; i++) {
                if (board[i][i] == null || board[i][i] != playingPeice) {
                    diagCheck = false;
                    break;
                }
            }
        } else {
            diagCheck = false;
        }

        // Check Anti Diag
        if (row+col == size-1) {
            for (int i=0,j=size-1 ; i < size ; i++,j--) {
                if (board[i][j] == null || board[i][j] != playingPeice) {
                    antDiagCheck = false;
                    break;
                }
            }
        } else {
            antDiagCheck = false;
        }

        return rowCheck || colCheck || diagCheck || antDiagCheck;
    }

    void printBoard() {
        for (int  i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                System.out.print("|   ");
                if (board[i][j] != null) {
                    System.out.print(board[i][j].peiceType.toString());
                } else {
                    System.out.print(" ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }
}
