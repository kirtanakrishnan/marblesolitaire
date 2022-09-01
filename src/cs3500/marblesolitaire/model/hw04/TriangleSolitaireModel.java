package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The {@code TriangleSolitaireModel} represents and initializes the triangle
 * internal model of the board.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  private int dimensions;



  /**
   * Constructs a {@code TriangleSolitaireModel} with the dimensions, sRow, sCol initialized
   * to 5, 0, 0, respectively and the board initialized to those parameters.
   */
  public TriangleSolitaireModel() {
    this.dimensions = 5;
    this.sRow = 0;
    this.sCol = 0;
    this.board = this.drawBoard();
  }

  /**
   * Constructs a {@code TriangleSolitaireModel} with the given dimensions and sRow, sCol
   * initialized according to the dimensions.
   * @param dimensions the given dimensions.
   * @throws IllegalArgumentException when the dimensions is not positive and odd.
   */
  public TriangleSolitaireModel(int dimensions) {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("The specified dimension is invalid (non-positive)");
    } else {
      this.dimensions = dimensions;
      this.sRow = 0;
      this.sCol = 0;
      this.board = this.drawBoard();
    }
  }

  /**
   * Constructs a (@code TriangleSolitaireModel} with the given sRow, sCol, and dimensions
   * initialized to 0, 0, and 5 respectively.
   * @param sRow the empty row.
   * @param sCol the empty column.
   * @throws IllegalArgumentException if the empty cell position is invalid.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this.dimensions = 5;
    if (sRow < 0 || sRow > dimensions || sCol < 0 || sCol > dimensions || sRow < sCol) {
      throw new IllegalArgumentException("Position is invalid");
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
      this.board = this.drawBoard();
    }
  }

  /**
   * Constructs {@code TriangleSolitaireModel} with the given dimensions, sRow, sCol.
   * @param dimensions the given dimensions.
   * @param sRow the given empty row position.
   * @param sCol the given empty column position.
   * @throws IllegalArgumentException if dimensions or (sRow, sCol) is invalid.
   */
  public TriangleSolitaireModel(int dimensions, int sRow, int sCol) {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("The specified dimension is invalid (non-positive)");
    } else if (sRow < 0 || sRow > dimensions || sCol < 0 || sCol > dimensions || sRow < sCol) {
      throw new IllegalArgumentException("Position is invalid");
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
      this.dimensions = dimensions;
      this.board = this.drawBoard();
    }
  }

  // initializes the board to SlotStates
  private ArrayList<ArrayList<SlotState>> drawBoard() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      ArrayList<SlotState> boardRow = new ArrayList<SlotState>();
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (i < 0 || i > dimensions || j < 0 || j > dimensions || i < j) {
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




  // determines if a move is valid
  @Override
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;
    int size = this.getBoardSize();

    return ((fromRow >= 0 && fromCol >= 0 && fromRow < size && fromCol <= fromRow) &&
            (toRow >= 0 && toCol >= 0 && toRow < size && toCol <= toRow) &&
            (board.get(fromRow).get(fromCol) == MarbleSolitaireModelState.SlotState.Marble) &&
            (((Math.abs(fromRow - toRow)) == 2 && (Math.abs(fromCol - toCol)) == 0) ||
                    ((Math.abs(fromCol - toCol)) == 2 && (Math.abs(fromRow - toRow)) == 0) ||
                    ((Math.abs(fromRow - toRow)) == 2 && (Math.abs(fromCol - toCol)) == 2)) &&
            (board.get(middleRow).get(middleCol) == MarbleSolitaireModelState.SlotState.Marble) &&
            (board.get(toRow).get(toCol) == MarbleSolitaireModelState.SlotState.Empty) &&
            (board.get(toRow).get(toCol) != MarbleSolitaireModelState.SlotState.Invalid));

  }


  // determines whether a marble can still move
  @Override
  protected boolean canMove(int row, int col) {
    return (this.validMove(row, col, row, col + 2) ||
            this.validMove(row, col, row, col - 2) ||
            this.validMove(row, col, row + 2, col + 2) ||
            this.validMove(row, col, row - 2, col - 2) ||
            this.validMove(row, col, row + 2, col) ||
            this.validMove(row, col, row - 2, col));
  }



  /**
   * Overrides the abstract method and
   * returns the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return dimensions;
  }



}
