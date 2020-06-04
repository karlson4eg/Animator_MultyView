package cs5004.model;

/**
 * Enumerator that represents types of shapes that are used for animation.
 */
public enum ShapeType {
  RECTANGLE("rect"), ELLIPSE("ellipse");


  private String type;

  ShapeType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}