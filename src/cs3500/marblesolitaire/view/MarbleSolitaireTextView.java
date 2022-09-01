package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The {@code MarbleSolitaireTextView} represents the visual output of the board.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView  {

  private MarbleSolitaireModelState model;
  public Appendable app;

  /**
   * Constructs {@code MarbleSolitaireTextView} according to the given model.
   * @param model the given MarbleSolitaireModelState.
   * @throws IllegalArgumentException if the model is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("model cannot be null");
    } else {
      this.model = model;
      this.app = System.out;
    }
  }

  /**
   * Constructs {@code MarbleSolitaireTextView} according to the given model.
   * @param model the given MarbleSolitaireModelState.
   * @param app the appendable given to the constructor.
   * @throws IllegalArgumentException if the model or is null.
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable app) {
    if (model == null || app == null ) {
      throw new IllegalArgumentException("model or appendable cannot be null");
    } else {
      this.model = model;
      this.app = app;
    }
  }



  @Override
  public String toString() {
    StringBuilder initial = new StringBuilder();
    int size = model.getBoardSize();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          initial.append("  ");
        }
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          initial.append("O ");
        }
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          initial.append("_ ");
        }
      }
      while (initial.charAt(initial.length() - 1) == ' ') {
        initial.deleteCharAt(initial.length() - 1);
      }
      initial.append("\n");
    }
    initial.deleteCharAt(initial.length() - 1);
    return initial.toString();
  }

  @Override
  public void renderBoard() throws IOException {
    try {
      app.append(this.toString());
    } catch (IOException e) {
      throw new IOException("Couldn't append");
    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      app.append(message);
    } catch (IOException e) {
      throw new IOException("Couldn't append");
    }
  }

}









