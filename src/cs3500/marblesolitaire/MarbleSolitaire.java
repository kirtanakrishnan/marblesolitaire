package cs3500.marblesolitaire;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Represents the main class which allows the user to interact with the game.
 */
public final class MarbleSolitaire {

  /**
   * Represents the main method.
   * @param args the arguments that the user inputs.
   */
  public static void main(String[] args) {

    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    MarbleSolitaireControllerImpl controller;
    int base = 3;
    int sRow = 3;
    int sCol = 3;
    String modelType = "";


    for (int i = 0; i < args.length; i++ ) {
      switch (args[i]) {
        case "english":
          modelType = "english";
          break;
        case "european":
          modelType = "european";
          break;
        case "triangular":
          modelType = "triangular";
          break;
        case "-size":
          base = (Integer.parseInt(args[i + 1]));
          sRow = 3 * base / 2 - 1;
          sCol = 3 * base / 2 - 1;
          break;
        case "-hole":
          sRow = (Integer.parseInt(args[i + 1])) - 1;
          sCol = (Integer.parseInt(args[i + 2])) - 1;
          break;
        default:
          // do nothing
          break;

      }
    }

    switch (modelType) {
      case "english":
        model = new EnglishSolitaireModel(base, sRow, sCol);
        view = new MarbleSolitaireTextView(model, new PrintStream(System.out));
        break;
      case "european":
        model = new EuropeanSolitaireModel(base, sRow, sCol);
        view = new MarbleSolitaireTextView(model, new PrintStream(System.out));
        break;
      case "triangular":
        base = 5;
        model = new TriangleSolitaireModel(base, sRow, sCol);
        view = new MarbleSolitaireTextView(model, new PrintStream(System.out));
        break;
      default:
        throw new IllegalArgumentException("Invalid model");

    }

    controller =
            new MarbleSolitaireControllerImpl(model, view,
                    new BufferedReader(new InputStreamReader(System.in)));
    controller.playGame();

  }



}




