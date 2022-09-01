package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * The {@code EnglishSolitaireModel} represents and initializes the internal model of the board.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {



  /**
   * Constructs a {@code EnglishSolitaireModel} with the armThickness, sRow, sCol initialized
   * to 3 and the board initialized to those parameters.
   */
  public EnglishSolitaireModel() {
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.board = this.drawBoard();
  }

  /**
   * Constructs a (@code EnglishSolitaireModel} with the given sRow, sCol, and armThickness
   * initialized to 3.
   * @param sRow the empty row.
   * @param sCol the empty column.
   * @throws IllegalArgumentException if the empty cell position is invalid.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this.armThickness = 3;
    if (sRow < 0 || sCol < 0 || (sRow <= armThickness - 2 && sCol <= armThickness - 2) ||
            (sRow <= armThickness - 2 && sCol >= (armThickness * 2) - 1) ||
            (sRow >= (armThickness * 2) - 1 && sCol <= armThickness - 2) ||
            (sRow >= (armThickness * 2) - 1 && sCol >= (armThickness * 2) - 1)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + " , " + sCol
              + ")" );
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
      this.board = this.drawBoard();
    }
  }


  /**
   * Constructs a {@code EnglishSolitaireModel} with the given armThickness and sRow, sCol
   * initialized according to the armThickness.
   * @param armThickness the given armThickness.
   * @throws IllegalArgumentException when the armThickness is not positive and odd.
   */
  public EnglishSolitaireModel(int armThickness) {
    if ((armThickness < 0) || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("arm thickness is not a positive odd number");
    } else {
      this.armThickness = armThickness;
      this.sRow = 3 * armThickness / 2 - 1;
      this.sCol = 3 * armThickness / 2 - 1;
      this.board = this.drawBoard();
    }
  }

  /**
   * Constructs {@code EnglishSolitaireModel} with the given armThickness, sRow, sCol.
   * @param armThickness the given armThickness.
   * @param sRow the given empty row position.
   * @param sCol the given empty column position.
   * @throws IllegalArgumentException if armThickness or (sRow, sCol) is invalid.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    if ((armThickness < 0) || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("arm thickness is not a positive odd number");
    } else if (sRow < 0 || sCol < 0 || (sRow <= armThickness - 2 && sCol <= armThickness - 2) ||
            (sRow <= armThickness - 2 && sCol >= (armThickness * 2) - 1) ||
            (sRow >= (armThickness * 2) - 1 && sCol <= armThickness - 2) ||
            (sRow >= (armThickness * 2) - 1 && sCol >= (armThickness * 2) - 1)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + " , " +
              sCol + ")" );
    } else {
      this.armThickness = armThickness;
      this.sRow = sRow;
      this.sCol = sCol;
      this.board = this.drawBoard();
    }
  }



  // initializes the board to SlotStates.
  private ArrayList<ArrayList<SlotState>> drawBoard() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      ArrayList<SlotState> boardRow = new ArrayList<SlotState>();
      for (int j = 0; j < this.getBoardSize(); j++) {
        if ((i <= (armThickness - 2) && j <= (armThickness - 2))
                || (i <= (armThickness - 2) && j >= (this.getBoardSize() - (armThickness - 1)))
                || (i >= (this.getBoardSize() - (armThickness - 1)) && j <= (armThickness - 2))
                || (i >= (this.getBoardSize() - (armThickness - 1))
                        && j >= (this.getBoardSize() - (armThickness - 1)))) {
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


}