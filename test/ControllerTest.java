import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Represents the test class.
 */
public class ControllerTest {

  EnglishSolitaireModel m1;
  EnglishSolitaireModel m2;
  EnglishSolitaireModel m3;
  EnglishSolitaireModel m4;
  EnglishSolitaireModel m5;
  EnglishSolitaireModel m6;
  EnglishSolitaireModel m7;
  EnglishSolitaireModel m8;
  EnglishSolitaireModel m9;
  EnglishSolitaireModel m10;
  MarbleSolitaireTextView v1;
  MarbleSolitaireTextView v2;
  MarbleSolitaireTextView v3;
  MarbleSolitaireTextView v4;
  MarbleSolitaireTextView v5;
  MarbleSolitaireTextView v6;
  MarbleSolitaireTextView v7;
  MarbleSolitaireTextView v8;
  MarbleSolitaireTextView v9;
  MarbleSolitaireTextView v10;

  /**
   * Represents the initialization of test cases.
   */
  @Before
  public void init() {
    this.m1 = new EnglishSolitaireModel(3, 3, 3);
    this.m2 = new EnglishSolitaireModel();
    this.m3 = new EnglishSolitaireModel(3, 0, 2);
    this.m5 = new EnglishSolitaireModel(5, 6, 6);
    this.m6 = new EnglishSolitaireModel(7, 17, 12);
    this.m7 = new EnglishSolitaireModel(15, 17, 17);
    this.m9 = new EnglishSolitaireModel(3);
    this.v1 = new MarbleSolitaireTextView(m1);
    this.v2 = new MarbleSolitaireTextView(m2);
    this.v3 = new MarbleSolitaireTextView(m3);
    this.v5 = new MarbleSolitaireTextView(m5);
    this.v6 = new MarbleSolitaireTextView(m6);
    this.v7 = new MarbleSolitaireTextView(m7);
    this.v9 = new MarbleSolitaireTextView(m9);
  }

  /**
   * The main method.
   *
   * @param args the string input
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Readable input = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }


  @Test
  public void testMoveInputs() {
    Reader in = new StringReader("6 4 4 4 q");

    StringBuilder log = new StringBuilder();
    ConfirmInputsModel model = new ConfirmInputsModel(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(m1);

    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("fromRow = 5, fromCol = 3, toRow = 3, toCol = 3\n", log.toString());
  }


  @Test
  public void testInput4() throws IOException {
    init();
    Reader in = new StringReader("6 4 4 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);
    controller.playGame();

    assertEquals(
            "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 31", dontCareOutput.toString());
  }

  @Test
  public void testInput5ArmThickness() throws IOException {
    init();
    Reader in = new StringReader("8 7 7 7 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m5, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m5, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);
    controller.playGame();

    assertEquals(
            "Game quit!\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O" +
                    "Score: 104", dontCareOutput.toString());
  }



  @Test
  public void testInput2() throws IOException {
    init();
    Reader in = new StringReader("6 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInput1() throws IOException {
    init();
    Reader in = new StringReader("6 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInput3() throws IOException {
    init();
    Reader in = new StringReader("6 4 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testOnlyQuit() throws IOException {
    init();
    Reader in = new StringReader("q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInvalidMove() throws IOException {
    init();
    Reader in = new StringReader("4 4 4 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInvalidLetter2() throws IOException {
    init();
    Reader in = new StringReader("4 4 a q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInvalidLetter1() throws IOException {
    init();
    Reader in = new StringReader("4 a q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInvalidLetter0() throws IOException {
    init();
    Reader in = new StringReader("a q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", dontCareOutput.toString());

  }

  @Test
  public void testInvalidMoveAfterValidMove() throws IOException {
    init();
    Reader in = new StringReader("6 4 4 4 4 4 4 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31", dontCareOutput.toString());

  }

  @Test
  public void testInvalidLetterAfterValidMove() throws IOException {
    init();
    Reader in = new StringReader("6 4 4 4 a q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31", dontCareOutput.toString());

  }

  @Test
  public void testValidMoveAfterValidMove() throws IOException {
    init();
    Reader in = new StringReader("6 4 4 4 3 4 5 4 q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30", dontCareOutput.toString());

  }

  @Test
  public void testInvalidLetterAfter2ValidMove() throws IOException {
    init();
    Reader in = new StringReader("6 4 4 4 3 4 5 4 a q");
    StringBuilder dontCareOutput = new StringBuilder();
    MarbleSolitaireTextView newView = new MarbleSolitaireTextView(m1, dontCareOutput);
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(m1, newView, in);

    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel model = new ConfirmInputsModel(log);

    controller.playGame();
    assertEquals("Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30", dontCareOutput.toString());

  }




}
