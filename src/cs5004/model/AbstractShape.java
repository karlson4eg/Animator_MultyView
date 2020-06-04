package cs5004.model;

/**
 * Abstract class cs5004.model.AbstractShape represents similarities for all types of shapes.
 */
public abstract class AbstractShape implements IShape {

  protected String id;

  protected float x;
  protected float y;

  protected float width;
  protected float height;

  protected float red;
  protected float green;
  protected float blue;

  protected int timeAppear;
  protected int timeDisappear;

  /**
   * Common constructor that reates a shape object. Is being used in every shape constructor.
   *
   * @param id name of the shape (should be unique).
   * @param x x coordinate of the shape.
   * @param y y coordinate of the shape.
   * @param width width of the shape.
   * @param height height of the shape.
   * @param timeAppear time of appearance of the shape.
   * @param timeDisappear time of disappearance of the shape.
   * @param r red component of the color of the shape.
   * @param g green component of the color of the shape.
   * @param b blue component of the color of the shape.
   * @throws IllegalArgumentException if values are negative or not in the RGB range.
   */
  protected AbstractShape(String id, float x, float y, float width, float height, int timeAppear,
      int timeDisappear,
      float r, float g, float b) {

    if ((width < 0 || height < 0 || timeAppear < 0 || timeDisappear < 0)
        || (r < 0 || r > 1) || (g < 0 || g > 1) || (b < 0 || b > 1)) {
      throw new IllegalArgumentException("Invalid arguments!");
    }
    this.id = id;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    this.timeAppear = timeAppear;
    this.timeDisappear = timeDisappear;

    this.red = r;
    this.green = g;
    this.blue = b;
  }

  @Override
  public int compareTo(IShape otherShape) {
    int compareTime = otherShape.getTimeOfAppearance();
    return this.timeAppear - compareTime;
  }

  @Override
  public float getHeight() {
    return this.height;
  }

  @Override
  public float getWidth() {
    return this.width;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public float getRed() {
    return this.red;
  }

  @Override
  public float getGreen() {
    return this.green;
  }

  @Override
  public float getBlue() {
    return this.blue;
  }

  @Override
  public int getTimeOfAppearance() {
    return this.timeAppear;
  }

  @Override
  public int getTimeOFDisappearance() {
    return this.timeDisappear;
  }

  @Override
  public float getX() {
    return this.x;
  }

  @Override
  public float getY() {
    return this.y;
  }

  public void setX(float x) {
    this.x = x;
  }

  @Override
  public void setY(float y) {
    this.y = y;
  }

  @Override
  public void setWidth(float width) {
    this.width = width;
  }

  @Override
  public void setHeight(float height) {
    this.height = height;
  }

  @Override
  public void setRed(float red) {
    this.red = red;
  }

  @Override
  public void setGreen(float green) {
    this.green = green;
  }

  @Override
  public void setBlue(float blue) {
    this.blue = blue;
  }
}
