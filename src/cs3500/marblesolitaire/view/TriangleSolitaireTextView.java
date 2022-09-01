package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The {@code TriangleSolitaireTextView} represents the visual output of the triangle board.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {

  private MarbleSolitaireModelState model;
  public Appendable app;


  /**
   * Constructs {@code TriangleSolitaireTextView} according to the given model.
   * @param model the given MarbleSolitaireModelState.
   * @throws IllegalArgumentException if the model is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("model cannot be null");
    } else {
      this.model = model;
      this.app = System.out;
    }
  }

  /**
   * Constructs {@code TriangleSolitaireTextView} according to the given model.
   * @param model the given MarbleSolitaireModelState.
   * @param app the appendable given to the constructor.
   * @throws IllegalArgumentException if the model or is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable app) {
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
      for (int j = 1; j < size - i; j++) {
        initial.append(" ");
      }
      for (int j = 0; j <= i; j++) {
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          initial.append("O");
        } else {
          initial.append("_");
        }
        if (j != i) {
          initial.append(" ");
        }
      }

      if (i + 1 < size) {
        initial.append("\n");
      }
    }
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
