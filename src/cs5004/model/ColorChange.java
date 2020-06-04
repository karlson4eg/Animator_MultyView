package cs5004.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class cs5004.model.ColorChange represents a motion that changes the color of the given shape.
 */
public class ColorChange extends AbstractMotion {


  private float newRed;
  private float newGreen;
  private float newBlue;

  private float oldRed;
  private float oldGreen;
  private float oldBlue;

  private boolean isRGBLegit(float a) {
    return a >= 0 && a <= 255;
  }

  /**
   * Constructor that creates a motion of type color change.
   *
   * @param fromTime strating time
   * @param toTime ending time
   * @param oldRed old red
   * @param oldGreen old green
   * @param oldBlue old blue
   * @param newRed new red
   * @param newGreen new green
   * @param newBlue new blue
   * @param shape object that this is gonna be applied.
   */
  public ColorChange(int fromTime, int toTime, float oldRed, float oldGreen, float oldBlue,
      float newRed, float newGreen, float newBlue,
      IShape shape) {
    super(fromTime, toTime, shape);

    if (!(isRGBLegit(oldRed) || isRGBLegit(oldGreen) || isRGBLegit(oldBlue) || isRGBLegit(newRed)
        || isRGBLegit(newGreen) || isRGBLegit(newBlue))) {
      throw new IllegalArgumentException("No no no from cs5004.model.ColorChange");
    }

    this.oldRed = oldRed;
    this.oldGreen = oldGreen;
    this.oldBlue = oldBlue;

    this.newRed = newRed;
    this.newGreen = newGreen;
    this.newBlue = newBlue;

  }

  @Override
  public MotionType getType() {
    return MotionType.COLORCHANGE;
  }

  @Override
  public String toString() {
    return shape.getId() + " changes from: (" + oldRed + "," + oldGreen + "," + oldBlue
        + ") to (" + newRed + "," + newGreen + "," + newBlue
        + ") from time t = " + fromTime + " to time t = " + toTime + "\n";
  }

  @Override
  public List getParams() {
    List params = new ArrayList();

    params.add(oldRed);
    params.add(oldGreen);
    params.add(oldBlue);
    params.add(newRed);
    params.add(newGreen);
    params.add(newBlue);

    return params;
  }
}
