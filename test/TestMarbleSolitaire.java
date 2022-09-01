import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Represents the test class.
 */
public class TestMarbleSolitaire {

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
  EnglishSolitaireModel m11;




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
  MarbleSolitaireTextView v11;

  TriangleSolitaireModel t1;
  TriangleSolitaireModel t2;
  TriangleSolitaireModel t3;
  TriangleSolitaireModel t4;
  TriangleSolitaireModel t5;
  TriangleSolitaireModel t6;
  TriangleSolitaireTextView vt1;
  TriangleSolitaireTextView vt2;
  TriangleSolitaireTextView vt3;
  TriangleSolitaireTextView vt4;
  TriangleSolitaireTextView vt5;
  TriangleSolitaireTextView vt6;

  EuropeanSolitaireModel e1;
  EuropeanSolitaireModel e2;
  EuropeanSolitaireModel e3;
  EuropeanSolitaireModel e4;
  EuropeanSolitaireModel e5;
  MarbleSolitaireTextView ve1;
  MarbleSolitaireTextView ve2;
  MarbleSolitaireTextView ve3;
  MarbleSolitaireTextView ve4;
  MarbleSolitaireTextView ve5;

  @Before
  public void init() {
    this.m1 = new EnglishSolitaireModel(3, 3, 3);
    this.m2 = new EnglishSolitaireModel();
    this.m3 = new EnglishSolitaireModel(3, 0, 2);
    this.m5 = new EnglishSolitaireModel(5, 6, 6);
    this.m6 = new EnglishSolitaireModel(7, 17, 12);
    this.m7 = new EnglishSolitaireModel(15, 17, 17);
    this.m9 = new EnglishSolitaireModel(3);
    this.m10 = new EnglishSolitaireModel(3, 3);
    this.m11 = new EnglishSolitaireModel(3);
    this.v1 = new MarbleSolitaireTextView(m1);
    this.v2 = new MarbleSolitaireTextView(m2);
    this.v3 = new MarbleSolitaireTextView(m3);
    this.v5 = new MarbleSolitaireTextView(m5);
    this.v6 = new MarbleSolitaireTextView(m6);
    this.v7 = new MarbleSolitaireTextView(m7);
    this.v9 = new MarbleSolitaireTextView(m9);
    this.v10 = new MarbleSolitaireTextView(m10);
    this.v11 = new MarbleSolitaireTextView(m11);

    this.t1 = new TriangleSolitaireModel(5, 0, 0);
    this.vt1 = new TriangleSolitaireTextView(t1);

    this.t2 = new TriangleSolitaireModel();
    this.vt2 = new TriangleSolitaireTextView(t2);

    this.t3 = new TriangleSolitaireModel(5);
    this.vt3 = new TriangleSolitaireTextView(t3);

    this.t4 = new TriangleSolitaireModel(0, 0);
    this.vt4 = new TriangleSolitaireTextView(t4);

    this.t5 = new TriangleSolitaireModel(3, 1);
    this.vt5 = new TriangleSolitaireTextView(t5);

    this.t6 = new TriangleSolitaireModel(7, 2, 2);
    this.vt6 = new TriangleSolitaireTextView(t6);



    this.e1 = new EuropeanSolitaireModel(3, 3, 3);
    this.ve1 = new MarbleSolitaireTextView(e1);

    this.e2 = new EuropeanSolitaireModel();
    this.ve2 = new MarbleSolitaireTextView(e2);

    this.e3 = new EuropeanSolitaireModel(3);
    this.ve3 = new MarbleSolitaireTextView(e3);

    this.e4 = new EuropeanSolitaireModel(3, 3);
    this.ve4 = new MarbleSolitaireTextView(e4);

    this.e5 = new EuropeanSolitaireModel(3, 6, 2);
    this.ve5 = new MarbleSolitaireTextView(e5);
  }


  @Test
  public void testInvalidInitialization() {
    try {
      this.m4 = new EnglishSolitaireModel(3, 0, 5);
      this.v4 = new MarbleSolitaireTextView(m1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m2 = new EnglishSolitaireModel(3, 0, 0);
      this.v2 = new MarbleSolitaireTextView(m2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m6 = new EnglishSolitaireModel(7, -1,4);
      this.v6 = new MarbleSolitaireTextView(m6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m8 = new EnglishSolitaireModel(5, 4, -3);
      this.v8 = new MarbleSolitaireTextView(m8);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m1 = new EnglishSolitaireModel(-2, 3, 3);
      this.v1 = new MarbleSolitaireTextView(m1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m1 = new EnglishSolitaireModel(2);
      this.v1 = new MarbleSolitaireTextView(m1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m10 = new EnglishSolitaireModel(8, 8);
      this.v10 = new MarbleSolitaireTextView(m10);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m10 = new EnglishSolitaireModel(4);
      this.v10 = new MarbleSolitaireTextView(m10);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.m10 = new EnglishSolitaireModel(4, 3, 3);
      this.v10 = new MarbleSolitaireTextView(m10);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testInvalidTriangleInitialization() {
    try {
      this.t1 = new TriangleSolitaireModel(5, 0, 1);
      this.vt1 = new TriangleSolitaireTextView(t1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.t1 = new TriangleSolitaireModel(5, 4, 5);
      this.vt1 = new TriangleSolitaireTextView(t1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.t1 = new TriangleSolitaireModel(5, 4, 7);
      this.vt1 = new TriangleSolitaireTextView(t1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.t3 = new TriangleSolitaireModel(-1);
      this.vt3 = new TriangleSolitaireTextView(t3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.t4 = new TriangleSolitaireModel(0, 5);
      this.vt4 = new TriangleSolitaireTextView(t4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testInvalidEuroInitialization() {
    try {
      this.e1 = new EuropeanSolitaireModel(3, 0, 1);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(3, 1, 6);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(3, 5, 0);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(3, 5, 6);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(3, -1, 1);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(3, 0, 8);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(-3);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(6);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e1 = new EuropeanSolitaireModel(0, 5);
      this.ve1 = new MarbleSolitaireTextView(e1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testInvalidModelView() {
    try {
      this.m4 = null;
      this.v4 = new MarbleSolitaireTextView(m4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      this.e4 = null;
      this.ve4 = new MarbleSolitaireTextView(e4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testInvalidTriangleModelView() {
    try {
      this.t4 = null;
      this.vt4 = new TriangleSolitaireTextView(t4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }


  @Test
  public void testToString() {
    init();


    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", v1.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", v11.toString());


    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", v9.toString());

    assertEquals("    O O O\n" +
                       "    O O O\n" +
                       "O O O O O O O\n" +
                       "O O O _ O O O\n" +
                       "O O O O O O O\n" +
                       "    O O O\n" +
                       "    O O O", v2.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", v10.toString());

    assertEquals("    _ O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", v3.toString());
    assertEquals("        O O O O O\n" +
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
            "        O O O O O", v5.toString());
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O _\n" +
            "            O O O O O O O", v6.toString());
    assertEquals("                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O _ O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O" +
            " O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O\n" +
            "                            O O O O O O O O O O O O O O O", v7.toString());



    System.out.print(v2.toString());

    System.out.print(v5.toString());

    System.out.print(v3.toString());

  }

  @Test
  public void testToStringTriangle() {
    init();

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", vt1.toString());
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", vt2.toString());
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", vt3.toString());
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", vt4.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O _ O O\n" +
            "O O O O O", vt5.toString());
    assertEquals("      O\n" +
            "     O O\n" +
            "    O O _\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", vt6.toString());
  }

  @Test
  public void testToStringEuropean() {
    init();

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", ve1.toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", ve2.toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", ve3.toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", ve4.toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    _ O O", ve5.toString());
  }

  @Test
  public void testValidMove() {
    init();
    m2.move(5, 3, 3, 3);
    m2.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m2.getSlotAt(0, 0));

    m2.move(2, 3, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(3, 3));

    m2.move(2,5,2,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(2, 5));

    m2.move(3,1,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(3, 2));

  }

  @Test
  public void testValidTriangleMove() {
    init();
    t1.move(2, 0, 0, 0);
    t1.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0, 1));

    t1.move(2,2,2,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(2, 1));

    t1.move(4,4,2,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(3, 3));


    t1.move(1,1,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(2, 2));


    t1.move(4,2,2,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(3, 2));


    t1.move(4,0,4,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 1));


    t1.move(4,3,4,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 2));


    t1.move(4,1,2,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(3, 1));

  }

  @Test
  public void testValidEuroMove() {
    init();
    e1.move(1, 3, 3, 3);
    e1.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, e1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, e1.getSlotAt(0, 1));

    e1.move(2, 1, 2, 3);
    e1.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, e1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(2, 2));

    e1.move(0, 2, 2, 2);
    e1.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, e1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(1, 2));

    e1.move(3, 2, 1, 2);
    e1.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, e1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(2, 2));

    e1.move(2, 4, 2, 2);
    e1.toString();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, e1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, e1.getSlotAt(2, 3));
  }

  @Test
  public void testInvalidMove() {
    init();
    try {
      m2.move(3, 3, 5, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      m2.move(2, 3, 3, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      m2.move(0, 0, 3, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      m6.move(0, 4, -1, 10);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      m2.move(3, 3, -1, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      m5.move(6,11,6,13);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testInvalidTriangleMove() {
    init();
    try {
      t1.move(0, 0, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      t1.move(1, 0, 1, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      t1.move(3, 0, 3, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      t1.move(3, 0, 2, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testInvalidEuroMove() {
    try {
      e1.move(3, 3, 5, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(2, 3, 3, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(0, 0, 3, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(0, 4, -1, 10);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(3, 3, -1, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.move(6,11,6,13);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }



  @Test
  public void testValidGetSlotAt() {
    init();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            m2.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            m2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            m3.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            m2.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            e1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            e1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            e5.getSlotAt(6, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            e1.getSlotAt(0, 1));
  }

  @Test
  public void testTriangleValidGetSlotAt() {
    init();
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            t1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            t1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            t6.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            t1.getSlotAt(0, 1));
  }

  @Test
  public void testInValidGetSlotAt() {
    init();
    try {
      m2.getSlotAt(-1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      m2.getSlotAt(8, 8);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      t1.getSlotAt(-1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      t1.getSlotAt(8, 8);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.getSlotAt(-1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      e1.getSlotAt(8, 8);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testGetScore() {
    init();
    assertEquals(32, m2.getScore());
    m2.move(5, 3, 3, 3);
    assertEquals(31, m2.getScore());
    m2.move(2, 3, 4, 3);
    assertEquals(30, m2.getScore());

    assertEquals(14, t1.getScore());
    t1.move(2, 0, 0, 0);
    assertEquals(13, t1.getScore());

    assertEquals(36, e1.getScore());
    e1.move(1, 3, 3, 3);
    assertEquals(35, e1.getScore());
  }

  @Test
  public void testIsGameOver() {
    init();
    m2.move(3, 1, 3, 3);
    m2.toString();
    m2.move(5, 2, 3, 2);
    m2.move(4, 0, 4,2);
    m2.move(4, 3, 4, 1);
    m2.move(4, 5, 4, 3);
    m2.move(6, 4, 4, 4);
    m2.move(3,4,5,4);
    m2.move(6,2,6,4);
    assertFalse(m2.isGameOver());
    m2.move(6, 4, 4,4);
    m2.move(2,2,4,2);
    m2.move(0,2,2,2);
    m2.move(1,4,3,4);
    m2.move(3,4, 5,4);
    m2.move(5,4, 5, 2);
    m2.move(5, 2,3,2);
    m2.move(3,2,1,2);
    m2.move(2,0,4,0);
    m2.move(4,0,4,2);
    m2.move(4,2,4,4);
    m2.move(2,6,2,4);
    m2.move(2,3,2,5);
    m2.move(4,6,2,6);
    m2.move(2,6,2,4);
    m2.move(0,4,0,2);
    m2.move(0,2,2,2);
    m2.move(2,1,2,3);
    m2.move(2,3,2,5);
    m2.move(2,5,4,5);
    m2.move(4,5,4,3);
    m2.move(4,3,2,3);
    m2.move(1,3,3,3);
    assertTrue(m2.isGameOver());
  }

  @Test
  public void isTriangleGameOver() {
    init();

    t1.move(2, 0, 0,0);
    t1.move(2,2,2,0);
    t1.move(4,4,2,2);
    t1.move(1,1,3,3);
    t1.move(4,2,2,2);
    t1.move(4,0,4,2);
    t1.move(4,3,4,1);
    t1.move(4,1,2,1);
    t1.move(3,3,1,1);
    assertFalse(t1.isGameOver());
    t1.move(3,0,1,0);
    t1.move(0,0,2,0);
    t1.move(2,0,2,2);
    t1.move(2,2,0,0);
    assertTrue(t1.isGameOver());
  }

  @Test
  public void testEuropeanIsGameOver() {
    init();

    e1.move(1, 3, 3, 3);
    e1.move(2,1,2,3);
    e1.move(0, 2, 2, 2);
    e1.move(3, 2, 1, 2);
    e1.move(2, 4, 2, 2);
    e1.move(5, 2, 3, 2);
    e1.move(4, 0, 4, 2);
    e1.move(4, 3, 4, 1);
    e1.move(2, 6, 2, 4);
    e1.move(2, 0, 4, 0);
    e1.move(4, 0, 4, 2);
    e1.move(4, 5, 4, 3);
    e1.move(4, 3, 4, 1);
    e1.move(4, 1, 2, 1);
    e1.move(2, 1, 2, 3);
    e1.move(2, 3, 2, 5);
    e1.move(6, 4, 4, 4);
    e1.move(3, 4, 5, 4);
    e1.move(4, 6, 2, 6);
    assertFalse(e1.isGameOver());
    e1.move(2, 6, 2, 4);
    e1.move(6, 2, 6, 4);
    e1.move(6, 4, 4, 4);
    e1.move(0, 4, 0, 2);
    e1.move(0, 2, 2, 2);
    e1.move(2, 2, 4, 2);
    e1.move(1, 4, 3, 4);
    e1.move(3, 4, 5, 4);
    e1.move(5, 4, 5, 2);
    e1.move(5, 2, 3, 2);
    e1.move(3, 2, 3, 4);
    e1.move(3, 5, 3, 3);
    assertTrue(e1.isGameOver());

  }

}
