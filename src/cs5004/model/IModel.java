package cs5004.model;

import java.util.List;
import java.util.Map;

/**
 * Interface cs5004.model.IModel represents all possible operations that model of the animator can
 * handle.
 */
public interface IModel {

  /**
   * Method addMotion creates a new motion for a given shape and adds this motion to the list of
   * motions associated with this particular shape object.
   *
   * @param shapeId name of the shape to add motion to.
   * @param motion motion object that is going to be added to the shape.
   * @throws IllegalArgumentException if cannot add a motion because of the timeline intersections.
   */
  void addMotion(String shapeId, IMotion motion);

  /**
   * Method addShape creates a new shape with given parameters and stores it in the hashmap.
   *
   * @param id name of the shape (should be unique).
   * @param type type of the shape.
   * @param x x coordinate of the shape.
   * @param y y coordinate of the shape.
   * @param w width of the shape.
   * @param h height of the shape.
   * @param timeAppear time of appearance of the shape.
   * @param timeDisappear time of disappearance of the shape.
   * @param r red component of the color of the shape.
   * @param g green component of the color of the shape.
   * @param b blue component of the color of the shape.
   * @throws IllegalArgumentException if parameters passed are invalid or cant add shape.
   */
  void addShape(String id, ShapeType type, float x, float y, float w, float h, int timeAppear,
      int timeDisappear, float r, float g, float b);

  /**
   * Method removeShape removes a shape from the model.
   *
   * @param id name.
   * @throws IllegalArgumentException if the id can not be found.
   */
  void removeShape(String id);

  /**
   * Method getState prints the state of the animator as a string. Describes all the shapes and
   * motions that those shapes are going to perform/
   */
  String getState();

  /**
   * Method getShape returns a shape object depends in the shape's id.
   *
   * @param name id of the shape.
   * @return shape with the given id.
   */
  IShape getShape(String name);

  /**
   * Method getShapes returns map of all shapes and their id values.
   *
   * @returnmap of all shapes and their id values.
   */
  Map<String, IShape> getShapes();

  /**
   * Method getMotions returns map of all motions associated with certain shape and this shapes id.
   *
   * @return map of all motions associated with certain shape and this shapes id.
   */
  Map<String, List<IMotion>> getMotions();


  /**
   * Method getShapesForViewAtFrame returns a modified list of shapes to draw in the swing.
   */
  List<IShape> getShapesForViewAtFrame(int currentFrame);

  /**
   * Method tween returns normalized values for every time frame between value1 and value 2.
   */
  float tween(float value1, float value2, int startTime, int endTime, int frame);

}