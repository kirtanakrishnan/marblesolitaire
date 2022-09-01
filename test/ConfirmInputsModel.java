import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a mock of the MarbleSolitaireModel for testing purposes.
 */
public class ConfirmInputsModel implements MarbleSolitaireModel {
  final StringBuilder log;

  /**
   * Contructs the mock with the given string builder.
   * @param log the string builder supplied to the mock.
   */
  public ConfirmInputsModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    // do nothing
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}


