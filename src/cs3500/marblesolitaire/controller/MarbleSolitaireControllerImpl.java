package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Represents a MarbleSolitaireControllerImpl, which helps the user interact with the board.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  protected MarbleSolitaireModel model;
  protected MarbleSolitaireView view;
  protected Readable input;


  /**
   * Constructs a {@code MarbleSolitiareControllerImpl} with its fields initialized to themselves.
   * @param model the model given.
   * @param view the view given.
   * @param input the input given.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable input) {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("model, view, or input cannot be null");
    } else {
      this.model = model;
      this.view = view;
      this.input = input;
    }
  }


  /**
   * Represents the controller, which allows the user to play the game.
   * @throws IllegalStateException if transmission to the view failed or if inputs ran out.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scanner = new Scanner(this.input);

    try {
      while (!model.isGameOver()) {
        view.renderBoard();
        view.renderMessage("\nScore: " + model.getScore() + "\n");

        String next = scanner.next();

        while (!isValid(next)) {

          view.renderMessage(" Invalid move. Play again. Input must be a positive integer, " +
                  "q, or Q\n");
          next = scanner.next();

        }

        int fromRow = 0;
        int fromCol = 0;
        int toRow = 0;
        int toCol = 0;

        if (isValid(next)) {

          if (!isItInteger(next)) {

            view.renderMessage("\nGame quit!\n" + "State of game when quit:\n");
            view.renderBoard();
            view.renderMessage("\nScore: " + model.getScore());
            return;
          }
          if (isItInteger(next)) {
            fromRow = Integer.parseInt(next) - 1;
            String colTemp = scanner.next();
            if (isItInteger(colTemp)) {
              fromCol = Integer.parseInt(colTemp) - 1;
            } else {
              if (!(colTemp.equals("q") || colTemp.equals("Q"))) {
                view.renderMessage("\nInvalid move. Play again. Input must be a positive" +
                          " integer, q, or Q\n");
                continue;
              }
              if (colTemp.equals("Q") || colTemp.equals("q")) {

                view.renderMessage("\nGame quit!\n" + "State of game when quit:\n");
                view.renderBoard();
                view.renderMessage("\nScore: " + model.getScore());


                break;
              }
            }
            String rowTemp2 = scanner.next();
            if (isItInteger(rowTemp2)) {
              toRow = Integer.parseInt(rowTemp2) - 1;
            } else {
              if (!(rowTemp2.equals("q") || rowTemp2.equals("Q"))) {
                view.renderMessage("\nInvalid move. Play again. Input must be a positive" +
                          " integer, q, or Q\n");
                continue;
              }
              if (rowTemp2.equals("Q") || rowTemp2.equals("q")) {

                view.renderMessage("\nGame quit!\n" + "State of game when quit:\n");
                view.renderBoard();
                view.renderMessage("\nScore: " + model.getScore());


                break;
              }
            }
            String colTemp2 = scanner.next();
            if (isItInteger(colTemp2)) {
              toCol = Integer.parseInt(colTemp2) - 1;
            } else {
              if (!(colTemp2.equals("q") || colTemp2.equals("Q"))) {

                view.renderMessage("\nInvalid move. Play again. Input must be a positive" +
                          " integer, q, or Q\n");

                continue;
              }
              if (colTemp2.equals("Q") || colTemp2.equals("q")) {

                view.renderMessage("\nGame quit!\n" + "State of game when quit:\n");
                view.renderBoard();
                view.renderMessage("\nScore: " + model.getScore());


                break;
              }
            }
          } else {
            view.renderMessage("\nGame quit!\n" + "State of game when quit:\n");
            view.renderBoard();
            view.renderMessage("\nScore: " + model.getScore());

          }

        }
        try {
          model.move(fromRow, fromCol, toRow, toCol);
        } catch (IllegalArgumentException e) {
          view.renderMessage("Couldn't move.\n");

          continue;


        }


      }

      if (model.isGameOver()) {
        view.renderMessage("Game over!\n");
        view.renderBoard();
        view.renderMessage("\nScore: " + model.getScore());

      }

    } catch (IOException e) {
      throw new IllegalStateException("Couldn't transmit");
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("Ran out of input");
    }


  }



  private boolean isItInteger(String string) {
    try {
      int i = Integer.parseInt(string);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }


  private boolean isValid(String string) {
    if (string.equals("q") || string.equals("Q")) {
      return true;
    }
    try {
      int i = Integer.parseInt(string);
      return (i > 0);
    } catch (NumberFormatException n) {
      return false;
    }
  }


}





