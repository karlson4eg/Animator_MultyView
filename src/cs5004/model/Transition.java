package cs5004.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class cs5004.model.Transition represents a motion that changes the position of the given shape.
 */
public class Transition extends AbstractMotion {

  private float x1;
  private float x2;

  private float y1;
  private float y2;

  /**
   * Constructor cs5004.model.Transition creates an transition motion object.
   *
   * @param fromTime starting time of the transition.
   * @param toTime ending time of the transition.
   * @param x1 old x position.
   * @param y1 old y position.
   * @param x2 new x position.
   * @param y2 new y position.
   * @param shape shape that this motion is going to be applied to.
   * @throws IllegalArgumentException if time is aint right.
   */
  public Transition(int fromTime, int toTime, float x1, float y1, float x2, float y2, IShape shape)
      throws IllegalArgumentException {
    super(fromTime, toTime, shape);

    this.x1 = x1;
    this.y1 = y1;

    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public MotionType getType() {
    return MotionType.TRANSITION;
  }

  @Override
  public String toString() {
    return shape.getId() + " moves from:  (" + this.x1 + ","
        + this.y1 + ") to (" + this.x2 + "," + this.y2
        + ") from time t = " + fromTime + " to time t = " + toTime + "\n";
  }

  @Override
  public List getParams() {
    List parameters = new ArrayList();

    parameters.add(x1); //0
    parameters.add(y1); // 1
    parameters.add(x2); //  2
    parameters.add(y2); //   3

    return parameters;
  }

}
