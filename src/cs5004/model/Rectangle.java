package cs5004.model;

/**
 * Class cs5004.model.Rectangle represents an rectangle-shaped object.
 */
public class Rectangle extends AbstractShape {

  public Rectangle(String id, float x, float y, float width, float height, int timeAppear,
      int timeDisappear, float r,
      float g, float b) {
    super(id, x, y, width, height, timeAppear, timeDisappear, r, g, b);
  }

  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public String toString() {
    return "This shape is cs5004.model.Rectangle. \n" + "Named: " + id + "\nLocated at: (" + x
        + ", " + y + ");\nHas " + width + " width, and " + height + " height;\n" + "Color is: ("
        + getRed() + "," + getGreen() + "," + getBlue() + ")\nAppears at: t=" + this.timeAppear
        + "\nDisappears at: t=" + this.timeDisappear + "\n";
  }

  @Override
  public String getShapeCoords() {
    return "Min corner: (" + x + "," + y + "), Width: " + width + ", Height: " + height + ", "
        + "Color: (" + red * 255 + "," + green * 255 + "," + blue * 255 + ")\n";
  }
}
