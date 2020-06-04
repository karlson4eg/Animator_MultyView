import static org.junit.Assert.assertEquals;

import cs5004.model.ColorChange;
import cs5004.model.Ellipse;
import cs5004.model.IModel;
import cs5004.model.IShape;
import cs5004.model.ModelAnime;
import cs5004.model.Rectangle;
import cs5004.model.Scale;
import cs5004.model.ShapeType;
import org.junit.Before;
import org.junit.Test;


/**
 * Testing.
 */
public class EllipseTest {

  private IModel model;
  private IShape el2;
  private IShape el3;
  private IShape el1;

  @Before
  public void setUp() {
    model = new ModelAnime();
    el1 = new Ellipse("Epillelips1", 10, 10,
        20, 20, 0, 200, 255, 0, 0);
    el2 = new Ellipse("Circle2", 15, 10,
        10, 5, 0, 150, 255, 255, 0);
    el3 = new Ellipse("Oval3", 20, 10,
        5, 10, 0, 99, 175, 0, 125);

    model.addShape("Epillelips1", ShapeType.ELLIPSE, 10, 10,
        20, 20, 0, 200, 255, 0, 0);
    model.addShape("Circle2", ShapeType.ELLIPSE, 15, 10,
        10, 5, 0, 150, 255, 255, 0);
    model.addShape("Oval3", ShapeType.ELLIPSE, 20, 10,
        5, 10, 0, 99, 175, 0, 125);
  }

  @Test
  public void toStringTest() {
    assertEquals("This shape is cs5004.model.Ellipse. \n"
        + "Named: Epillelips1\n"
        + "Located at: (10, 10);\n"
        + "Has 20 width, and 20 height;\n"
        + "Color is: (255,0,0)\n"
        + "Appears at: t=0\n"
        + "Disappears at: t=200\n", el1.toString());
  }

  @Test
  public void stateTest() {
    assertEquals("This shape is cs5004.model.Ellipse. \n"
        + "Named: Epillelips1\n"
        + "Located at: (10, 10);\n"
        + "Has 20 width, and 20 height;\n"
        + "Color is: (255,0,0)\n"
        + "Appears at: t=0\n"
        + "Disappears at: t=200\n"
        + "This shape is cs5004.model.Ellipse. \n"
        + "Named: Circle2\n"
        + "Located at: (15, 10);\n"
        + "Has 10 width, and 5 height;\n"
        + "Color is: (255,255,0)\n"
        + "Appears at: t=0\n"
        + "Disappears at: t=150\n"
        + "This shape is cs5004.model.Ellipse. \n"
        + "Named: Oval3\n"
        + "Located at: (20, 10);\n"
        + "Has 5 width, and 10 height;\n"
        + "Color is: (175,0,125)\n"
        + "Appears at: t=0\n"
        + "Disappears at: t=99\n", model.getState());
  }

  @Test
  public void motionSameEllipseSameMotionTest() {
    model.addMotion("Epillelips1", new Scale(10, 20,
        10, 10, 20, 20, el1));
    model.addMotion("Epillelips1", new Scale(1, 5,
        3, 3, 15, 15, el1));
    model.addMotion("Epillelips1", new Scale(25, 29,
        15, 15, 33, 33, el1));

    assertEquals("This shape is cs5004.model.Ellipse. \n"
            + "Named: Epillelips1\n"
            + "Located at: (10, 10);\n"
            + "Has 20 width, and 20 height;\n"
            + "Color is: (255,0,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=200\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Circle2\n"
            + "Located at: (15, 10);\n"
            + "Has 10 width, and 5 height;\n"
            + "Color is: (255,255,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=150\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Oval3\n"
            + "Located at: (20, 10);\n"
            + "Has 5 width, and 10 height;\n"
            + "Color is: (175,0,125)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=99\n"
            + "Epillelips1 scales from: Width: 3 Height: 3to: Width:15 Height:"
            + " 15 from time t = 1 to time t = 5\n"
            + "Epillelips1 scales from: Width: 10 Height: 10to: Width:20 Heig"
            + "ht: 20 from time t = 10 to time t = 20\n"
            + "Epillelips1 scales from: Width: 15 Height: 15to: Width:33 Height: "
            + "33 from time t = 25 to time t = 29\n",
        model.getState());
  }

  @Test
  public void motionTest() {
    model.addMotion("Epillelips1", new Scale(10, 20,
        10, 10, 20, 20, el1));
    model.addMotion("Epillelips1", new Scale(1, 5,
        3, 3, 15, 15, el1));
    model.addMotion("Epillelips1", new Scale(25, 29,
        15, 15, 33, 33, el1));

    model.addMotion("Epillelips1", new ColorChange(0, 2,
        0, 0, 2, 200, 100, 50, el1));
    model.addMotion("Epillelips1", new ColorChange(10, 20,
        46, 33, 44, 250, 55, 33, el1));

    assertEquals("This shape is cs5004.model.Ellipse. \n"
            + "Named: Epillelips1\n"
            + "Located at: (10, 10);\n"
            + "Has 20 width, and 20 height;\n"
            + "Color is: (255,0,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=200\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Circle2\n"
            + "Located at: (15, 10);\n"
            + "Has 10 width, and 5 height;\n"
            + "Color is: (255,255,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=150\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Oval3\n"
            + "Located at: (20, 10);\n"
            + "Has 5 width, and 10 height;\n"
            + "Color is: (175,0,125)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=99\n"
            + "Epillelips1 changes from: (0,0,2) to (200,100,50) from time t ="
            + " 0 to time t = 2\n"
            + "Epillelips1 scales from: Width: 3 Height: 3to: Width:15 Height:"
            + " 15 from time t = 1 to time t = 5\n"
            + "Epillelips1 scales from: Width: 10 Height: 10to: Width:20 Height"
            + ": 20 from time t = 10 to time t = 20\n"
            + "Epillelips1 changes from: (46,33,44) to (250,55,33) from time t = "
            + "10 to time t = 20\n"
            + "Epillelips1 scales from: Width: 15 Height: 15to: Width:33 Height: "
            + "33 from time t = 25 to time t = 29\n",
        model.getState());

  }

  @Test
  public void removeTest() {
    model.addMotion("Epillelips1", new Scale(1, 5,
        3, 3, 15, 15, el1));
    model.addMotion("Epillelips1", new ColorChange(0, 2,
        0, 0, 2, 200, 100, 50, el1));
    model.addMotion("Circle2", new ColorChange(0, 2,
        0, 0, 2, 200, 100, 50, el2));

    assertEquals("This shape is cs5004.model.Ellipse. \n"
            + "Named: Epillelips1\n"
            + "Located at: (10, 10);\n"
            + "Has 20 width, and 20 height;\n"
            + "Color is: (255,0,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=200\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Circle2\n"
            + "Located at: (15, 10);\n"
            + "Has 10 width, and 5 height;\n"
            + "Color is: (255,255,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=150\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Oval3\n"
            + "Located at: (20, 10);\n"
            + "Has 5 width, and 10 height;\n"
            + "Color is: (175,0,125)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=99\n"
            + "Epillelips1 changes from: (0,0,2) to (200,100,50) from time t"
            + " = 0 to time t = 2\n"
            + "Circle2 changes from: (0,0,2) to (200,100,50) from time t = 0 "
            + "to time t = 2\n"
            + "Epillelips1 scales from: Width: 3 Height: 3to: Width:15 Height:"
            + " 15 from time t = 1 to time t = 5\n",
        model.getState());

    model.removeShape("Circle2");

    assertEquals("This shape is cs5004.model.Ellipse. \n"
            + "Named: Epillelips1\n"
            + "Located at: (10, 10);\n"
            + "Has 20 width, and 20 height;\n"
            + "Color is: (255,0,0)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=200\n"
            + "This shape is cs5004.model.Ellipse. \n"
            + "Named: Oval3\n"
            + "Located at: (20, 10);\n"
            + "Has 5 width, and 10 height;\n"
            + "Color is: (175,0,125)\n"
            + "Appears at: t=0\n"
            + "Disappears at: t=99\n"
            + "Epillelips1 changes from: (0,0,2) to (200,100,50) from time "
            + "t = 0 to time t = 2\n"
            + "Epillelips1 scales from: Width: 3 Height: 3to: Width:15 Height: "
            + "15 from time t = 1 to time t = 5\n",
        model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddmotionBeforeObject() {
    model.addShape("testingrectangle", ShapeType.RECTANGLE, 0, 0, 2, 2,
        10, 20, 4, 5, 6);
    IShape s = new Rectangle("testingrectangle", 0, 0, 2, 2,
        10, 20, 4, 5, 6);
    model.addMotion("testingrectangle", new ColorChange(3, 17,
        4, 4, 4, 5, 5, 5, s));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoTime() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, 2, -2,
        4, 4, 4, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testNoNoTimeSame() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, 2, 4,
        4, 4, 4, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNegativeX() {
    model.addShape("hui", ShapeType.RECTANGLE, -2, 2, 2, 2, 0,
        4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNegativeY() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, -2, 2, 2, 0,
        4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNegativeWidth() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, -2, 2, 0,
        4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNegativeHeight() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, -2, 0,
        4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNoZeroHeight() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, 0, 0,
        4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNoZeroWidth() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 0, 2, 0,
        4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNoInvalidRGBRed() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, 2, 0,
        4, 257, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNoInvalidRGBGreen() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, 2, 0,
        4, 3, -1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoNoNoInvalidRGBBlue() {
    model.addShape("hui", ShapeType.RECTANGLE, 2, 2, 2, 2, 0,
        4, 3, 1, 999);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNOID() {
    model.removeShape("hui");
  }


}