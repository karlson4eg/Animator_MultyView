package cs5004.model;

/**
 * Public interface cs5004.model.IShape represents operations common for different types of shapes.
 */
public interface IShape extends Comparable<IShape> {

  /**
   * Method getHeight returns height  of the shape.
   *
   * @return height.
   */
  float getHeight();

  /**
   * Method getWidth returns width  of the shape.
   *
   * @return width.
   */
  float getWidth();

  /**
   * Method getY returns X coordinate of the shape center.
   *
   * @return x coordinate.
   */
  float getX();

  /**
   * Method getY returns Y coordinate of the shape center.
   *
   * @return y coordinate.
   */
  float getY();


  /**
   * Method getId returns the String ID of the shape.
   *
   * @return ID of the shape.
   */
  String getId();

  /**
   * Method getRed returns red component of the color of the provided shape.
   *
   * @return red component of the color of the given shape.
   */
  float getRed();

  /**
   * Method getRed returns green component of the color of the provided shape.
   *
   * @return green component of the color of the given shape.
   */
  float getGreen();

  /**
   * Method getRed returns blue component of the color of the provided shape.
   *
   * @return blue component of the color of the given shape.
   */
  float getBlue();

  /**
   * Method getTimeOfAppearance returns the time of the appearance of the given shape.
   *
   * @return time of the appearance of the given shape.
   */
  int getTimeOfAppearance();

  /**
   * Method getTimeOFDisappearance returns the time of the disappearance of the given shape.
   *
   * @return time of the disappearance of the given shape.
   */
  int getTimeOFDisappearance();

  /**
   * Method getType returns the type of the shape.
   *
   * @return type of the shape as enum.
   */
  ShapeType getType();

  /**
   * Method getShapeCoords returns the string that describes shape's initial state.
   *
   * @return string that describes shape's initial state.
   */
  String getShapeCoords();

  /**
   * Set the X parameter.
   *
   * @param x x.
   */
  void setX(float x);

  /**
   * Set the Y parameter.
   *
   * @param y y.
   */
  void setY(float y);

  /**
   * Set the width parameter.
   *
   * @param width width.
   */
  void setWidth(float width);

  /**
   * Set the height parameter.
   *
   * @param height height.
   */
  void setHeight(float height);

  /**
   * Set the red parameter.
   *
   * @param red red.
   */
  void setRed(float red);

  /**
   * Set the green parameter.
   *
   * @param green green.
   */
  void setGreen(float green);

  /**
   * Set the blue parameter.
   *
   * @param blue blue.
   */
  void setBlue(float blue);

}
