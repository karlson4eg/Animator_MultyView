package cs5004.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class cs5004.model.ColorChange represents a motion that changes the size of the given shape.
 */
public class Scale extends AbstractMotion {

  private float oldHeight;
  private float oldWidth;

  private float newHeight;
  private float newWidth;


  /**
   * Constructor that creates a cs5004.model.Scale motion.
   *
   * @param fromTime starting time of the scaling
   * @param toTime ending time of scaling.
   * @param oldHeight old height.
   * @param oldWidth olf width.
   * @param newHeight new height.
   * @param newWidth new width.
   * @param shape shape that this motion will be applied to.
   * @throws IllegalArgumentException if passed parameters are illegal.
   */
  public Scale(int fromTime, int toTime, float oldHeight, float oldWidth, float newHeight,
      float newWidth, IShape shape) throws IllegalArgumentException {
    super(fromTime, toTime, shape);

    if (oldHeight < 0 || oldWidth < 0 || newHeight < 0 || newWidth < 0) {
      throw new IllegalArgumentException("Bad input inside the cs5004.model.Scale");
    }

    this.oldHeight = oldHeight;
    this.oldWidth = oldWidth;

    this.newHeight = newHeight;
    this.newWidth = newWidth;

  }

  @Override
  public MotionType getType() {
    return MotionType.SCALE;
  }

  @Override
  public String toString() {
    return shape.getId() + " scales from: Width: " + oldWidth + " Height: " + oldHeight
        + "to: Width:" + newWidth + " Height: " + newHeight
        + " from time t = " + fromTime + " to time t = " + toTime + "\n";
  }

  @Override
  public List getParams() {
    List params = new ArrayList();
    params.add(oldWidth);
    params.add(oldHeight);
    params.add(newWidth);
    params.add(newHeight);

    return params;
  }
}
