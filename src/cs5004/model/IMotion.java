package cs5004.model;

import java.util.List;

/**
 * Public interface cs5004.model.IMotion represents operations common for different types of
 * motions.
 */
public interface IMotion extends Comparable<IMotion> {

  /**
   * Method  getStartTime returns a time of the start of the motion.
   *
   * @return strating time.
   */
  int getStartTime();

  /**
   * Method  getEndTime returns a time of the end of the motion.
   *
   * @return ending time.
   */
  int getEndTime();

  /**
   * Method getType returns a type of the motion.
   *
   * @return type of the motion.
   */
  MotionType getType();

  /**
   * Method compareTo compares two motions by the starting time and returns the difference.
   *
   * @param otherMotion motion that is going to be compared with a given one.
   * @return difference in time.
   */
  int compareTo(IMotion otherMotion);

  /**
   * Method isValidMotion checks if the motion is possible to perform according to the timeline. It
   * is impossible to perform same type of operation to the same shape object at the same time.
   *
   * @param other other motion that we compare given motion with.
   */
  boolean isValidMotion(IMotion other);

  /**
   * Method getName returns a name of the associated to this motion shape.
   *
   * @return name of the associated to this motion shape.
   */
  String getName();

  /**
   * Method getParams returns motions properties that were passed in.
   *
   * @return properties that were passed in.
   */
  List getParams();


}
