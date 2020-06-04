package cs5004.model;

/**
 * Class cs5004.model.Ellipse represents an ellipse-shaped object.
 */
public class Ellipse extends AbstractShape {

  public Ellipse(String id, float x, float y, float width, float height, int timeAppear,
      int timeDisappear,
      float r,
      float g, float b) {
    super(id, x, y, width, height, timeAppear, timeDisappear, r, g, b);
  }

  @Override
  public ShapeType getType() {
    return ShapeType.ELLIPSE;
  }

  @Override
  public String toString() {
    return "This shape is cs5004.model.Ellipse. \n" + "Named: " + id + "\nLocated at: (" + x + ", "
        + y
        + ");\nHas "
        + width + " width, and "
        + height + " height;\n" + "Color is: (" + getRed() + "," + getGreen() + "," + getBlue()
        + ")\nAppears at: t=" + this.timeAppear + "\nDisappears at: t=" + this.timeDisappear + "\n";
  }

  @Override
  public String getShapeCoords() {
    return "Center: (" + x + "," + y + "), X radius: " + width + ", Y radius: " + height + ", "
        + "Color: (" + 255 * red + "," + 255 * green + "," + 255 * blue + ")\n";
  }
}
