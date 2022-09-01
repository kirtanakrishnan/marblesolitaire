package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The {@code EuropeanSolitaireModel} represents and initializes the european
 * internal model of the board.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {
  private int sideLength;


  /**
   * Constructs a {@code EuropeanSolitaireModel} with the sideLength, sRow, sCol initialized
   * to 3 and the board initialized to those parameters.
   */
  public EuropeanSolitaireModel() {
    this.sideLength = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.board = this.drawBoard();
  }

  /**
   * Constructs a {@code EuropeanSolitaireModel} with the given sideLength and sRow, sCol
   * initialized according to the sideLength.
   * @param sideLength the given sideLength.
   * @throws IllegalArgumentException when the sideLength is not positive and odd.
   */
  public EuropeanSolitaireModel(int sideLength) {
    if ((sideLength < 0) || (sideLength % 2 == 0)) {
      throw new IllegalArgumentException("arm thickness is not a positive odd number");
    } else {
      this.sideLength = sideLength;
      this.sRow = 3 * sideLength / 2 - 1;
      this.sCol = 3 * sideLength / 2 - 1;
      this.board = this.drawBoard();
    }
  }

  /**
   * Constructs a (@code EuropeanSolitaireModel} with the given sRow, sCol, and sideLength
   * initialized to 3.
   * @param sRow the empty row.
   * @param sCol the empty column.
   * @throws IllegalArgumentException if the empty cell position is invalid.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this.sideLength = 3;
    if (sRow < 0 || sCol < 0 || sRow > this.getBoardSize() - 1 || sCol > this.getBoardSize() - 1 ||
            (sRow + sCol < sideLength - 1) || (sRow > sCol + 2 * sideLength - 2) ||
            (sRow + sCol >= 5 * sideLength - 4) || (sCol > sRow + 2 * sideLength - 2)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + " , " + sCol
              + ")" );
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
      this.board = this.drawBoard();
    }
  }



  /**
   * Constructs {@code EuropeanSolitaireModel} with the given sideLength, sRow, sCol.
   * @param sideLength the given sideLength.
   * @param sRow the given empty row position.
   * @param sCol the given empty column position.
   * @throws IllegalArgumentException if sideLength or (sRow, sCol) is invalid.
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sCol) {
    if ((sideLength < 0) || (sideLength % 2 == 0)) {
      throw new IllegalArgumentException("arm thickness is not a positive odd number");
    }
    this.sideLength = sideLength;
    if (sRow < 0 || sCol < 0 || sRow >= this.getBoardSize() || sCol >= this.getBoardSize() ||
            (sRow + sCol < sideLength - 1) || (sRow > sCol + 2 * sideLength - 2) ||
            (sRow + sCol >= 5 * sideLength - 4) || (sCol > sRow + 2 * sideLength - 2)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + " , " + sCol
              + ")" );
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
      this.board = this.drawBoard();
    }
  }

  // initializes the board to SlotStates
  private ArrayList<ArrayList<SlotState>> drawBoard() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      ArrayList<SlotState> boardRow = new ArrayList<SlotState>();
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (i < 0 || j < 0 || i >= (this.sideLength * 3) - 2 || j >= (this.sideLength * 3 - 2) ||
                (i + j < sideLength - 1) || (i > j + 2 * sideLength - 2) ||
                (i + j >= 5 * sideLength - 4) || (j > i + 2 * sideLength - 2)) {
          boardRow.add(MarbleSolitaireModelState.SlotState.Invalid);
        } else if (i == sRow && j == sCol) {
          boardRow.add(MarbleSolitaireModelState.SlotState.Empty);
        } else {
          boardRow.add(MarbleSolitaireModelState.SlotState.Marble);
        }
      }
      board.add(boardRow);
    }
    return board;
  }


  /**
   * Overrides the abstract method and
   * returns the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return (this.sideLength * 3) - 2;
  }


}
