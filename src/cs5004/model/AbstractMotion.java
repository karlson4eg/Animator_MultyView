package cs5004.model;

/**
 * Abstract class cs5004.model.AbstractMotion represents similarities for different motion types.
 */
public abstract class AbstractMotion implements IMotion {

  protected int fromTime;
  protected int toTime;

  protected IShape shape;

  /**
   * Constructor that creates a motion(being used in evety comsturctor for different motions).
   *
   * @param fromTime time of the beginning of the motion.
   * @param toTime time of the end of the motion.
   * @param shape shape that will have this motion.
   * @throws IllegalArgumentException if values are unacceptable.
   */
  protected AbstractMotion(int fromTime, int toTime, IShape shape) throws IllegalArgumentException {

    if (fromTime < 0 || toTime < 0 || fromTime == toTime || fromTime > toTime) {
      throw new IllegalArgumentException("Invalid arguments!");
    }

    this.fromTime = fromTime;
    this.toTime = toTime;

    this.shape = shape;
  }

  @Override
  public int getStartTime() {
    return this.fromTime;
  }

  @Override
  public int getEndTime() {
    return this.toTime;
  }

  @Override
  public int compareTo(IMotion otherMotion) {
    int compareTime = otherMotion.getStartTime();
    return this.fromTime - compareTime;
  }

  @Override
  public String getName() {
    return shape.getId();
  }

  @Override
  public boolean isValidMotion(IMotion other) {
    if (other.getType() == this.getType()) {
      if ((this.getStartTime() < other.getStartTime()) && (other.getStartTime() < this.getEndTime())
          || (this.getStartTime() < other.getEndTime()) && (other.getEndTime() < this.getEndTime())
          || (this.getStartTime() < other.getStartTime() && this.getEndTime() > other.getEndTime())
          || (this.getStartTime() > other.getStartTime() && this.getEndTime() < other.getEndTime())
      ) {
        return false;
      }
    }
    return true;
  }



}
