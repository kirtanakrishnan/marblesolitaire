package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents the common operations offered by the marble solitaire
 * model. One object of the model represents one game of marble solitaire.
 */
public class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected ArrayList<ArrayList<SlotState>> board = new ArrayList<ArrayList<SlotState>>();
  protected int sRow;
  protected int sCol;
  protected int armThickness;


  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;
    if ((!(this.validMove(fromRow, fromCol, toRow, toCol))) ||
            board.get(toRow).get(toCol) != MarbleSolitaireModelState.SlotState.Empty) {
      throw new IllegalArgumentException("Invalid Move");
    } else {
      board.get(fromRow).set(fromCol, MarbleSolitaireModelState.SlotState.Empty);
      board.get(middleRow).set(middleCol, MarbleSolitaireModelState.SlotState.Empty);
      board.get(toRow).set(toCol, MarbleSolitaireModelState.SlotState.Marble);
    }
  }

  // determines if a move is valid
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;
    int size = this.getBoardSize();
    return ((fromRow >= 0 && fromRow < size) && (toRow >= 0 && toRow < size) &&
            (fromCol >= 0 && fromCol < size) && (toCol >= 0 && toCol < size) &&
            (board.get(fromRow).get(fromCol) == MarbleSolitaireModelState.SlotState.Marble) &&
            (((Math.abs(fromRow - toRow)) == 2 && (Math.abs(fromCol - toCol)) == 0) ||
                    ((Math.abs(fromCol - toCol)) == 2 && (Math.abs(fromRow - toRow)) == 0)) &&
            (board.get(middleRow).get(middleCol) == MarbleSolitaireModelState.SlotState.Marble) &&
            (board.get(toRow).get(toCol) == MarbleSolitaireModelState.SlotState.Empty) &&
            (board.get(toRow).get(toCol) != MarbleSolitaireModelState.SlotState.Invalid));
  }


  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    int size = this.getBoardSize();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if ((this.canMove(i, j)) && board.get(i).get(j).equals(SlotState.Marble)) {
          return false;
        }
      }
    }
    return true;
  }

  // determines whether a marble can still move
  protected boolean canMove(int row, int col) {
    int size = this.getBoardSize();
    return ((row > 1 && this.validMove(row, col, row - 2, col)) ||
            (col > 1 && this.validMove(row, col, row, col - 2)) ||
            (row < (size - 1) && this.validMove(row, col, row + 2, col)) ||
            (col < (size - 1) && this.validMove(row, col, row, col + 2)));
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  public int getBoardSize() {
    return (this.armThickness * 3) - 2;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row > getBoardSize() || col > getBoardSize()) {
      throw new IllegalArgumentException("there is no slot state at (" + row + col + ")");
    } else {
      SlotState state = board.get(row).get(col);
      return state;
    }
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  public int getScore() {
    int size = this.getBoardSize();
    int count = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if ((board.get(i).get(j)) == SlotState.Marble) {
          count++;
        }
      }
    }
    return count;
  }
}
