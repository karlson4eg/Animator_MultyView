package cs5004.model;

import cs5004.util.TweenModelBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Public class ModelAnime represents the model that handles operations of a simple animator.
 */
public class ModelAnime implements IModel {

  private Map<String, IShape> allShapes;
  private Map<String, List<IMotion>> allMotions;


  public ModelAnime() {
    allShapes = new LinkedHashMap<>();
    allMotions = new LinkedHashMap<>();
  }

  @Override
  public void addMotion(String shapeId, IMotion motion) throws IllegalArgumentException {
    List<IMotion> motionList = allMotions.get(shapeId);

    if (allShapes.get(shapeId).getTimeOfAppearance() > motion.getStartTime() //0 1
        || allShapes.get(shapeId).getTimeOFDisappearance() < motion.getEndTime()) { // 200 5
      throw new IllegalArgumentException(
          "Cant add a motion that does its thing before/after shape is not there.");
    }

    //check if move possible
    for (IMotion currentMotions : motionList) {
      if (!currentMotions.isValidMotion(motion)) {
        throw new IllegalArgumentException("Can't do two things at the same time!");
      }
    }

    motionList.add(motion);
    allMotions.put(shapeId, motionList);

  }

  @Override
  public void addShape(String id, ShapeType type, float x, float y, float w, float h,
      int timeAppear,
      int timeDisappear, float r, float g, float b)
      throws IllegalArgumentException {

    if ((w <= 0 || h <= 0 || timeAppear < 0 || timeDisappear < 0) || timeAppear == timeDisappear
        || (r < 0 || r > 255) || (g < 0
        || g > 255) || (b < 0 || b > 255)) {
      throw new IllegalArgumentException("Invalid arguments!");
    }

    IShape shape;
    for (String str : allShapes.keySet()) {
      if (str.equals(id)) {
        throw new IllegalArgumentException("Same name of the shape! Pls think about unique names!");
      }
    }

    switch (type) {
      case RECTANGLE:
        shape = new Rectangle(id, x, y, w, h, timeAppear, timeDisappear, r, g, b);
        break;
      case ELLIPSE:
        shape = new Ellipse(id, x, y, w, h, timeAppear, timeDisappear, r, g, b);
        break;
      default:
        shape = null;
    }
    if (shape != null) {
      allShapes.putIfAbsent(id, shape);
    }

    allMotions.put(id, new ArrayList<>());
  }


  @Override
  public void removeShape(String id) throws IllegalArgumentException {
    if (!allShapes.containsKey(id)) {
      throw new IllegalArgumentException("ID not found");
    }

    allShapes.remove(id);
    allMotions.remove(id);
  }


  @Override
  public String getState() {

    //create a builder.(efficiency man)
    StringBuilder output = new StringBuilder();

    //All shapes are going here.
    List<IShape> valueList = new ArrayList<>(allShapes.values());

    //Sorting the shapes in the list.
    Collections.sort(valueList);

    //print all shapes first.
    for (IShape shape : valueList) {
      output.append(shape.toString());
    }

    //create a new list of all motions
    List<IMotion> temp = new ArrayList<>();

    //for every motion in the list of motions of certain shape => get all values and add them to
    // the new list of all motions
    for (List<IMotion> list : allMotions.values()) {
      temp.addAll(list);
    }

    // sort the ultimate list
    Collections.sort(temp);

    //append sorted motions to the output
    for (IMotion motion : temp) {
      output.append(motion.toString());
    }

    return output.toString();
  }

  @Override
  public IShape getShape(String name) {
    IShape tmp = null;
    try {
      tmp = allShapes.get(name);
    } catch (Exception e) {
      System.err.print("No such name");
    }
    return tmp;
  }

  @Override
  public Map<String, IShape> getShapes() {
    return allShapes;
  }

  @Override
  public Map<String, List<IMotion>> getMotions() {
    return allMotions;
  }


  @Override
  public List<IShape> getShapesForViewAtFrame(int currentFrame) {

    List<IShape> shapesToPassToView = new ArrayList<>();

    for (IShape shape : getShapesAtCurrentFrame(currentFrame)) {

      for (IMotion motion : allMotions.get(shape.getId())) {
        if (currentFrame >= motion.getStartTime() && currentFrame <= motion.getEndTime()) {

          switch (motion.getType()) {
            case SCALE:
              shape.setWidth(
                  tween((float) motion.getParams().get(0), (float) motion.getParams().get(2),
                      motion.getStartTime(), motion.getEndTime(), currentFrame)
              );
              shape.setHeight(
                  tween((float) motion.getParams().get(1), (float) motion.getParams().get(3),
                      motion.getStartTime(), motion.getEndTime(), currentFrame));

              shapesToPassToView.add(shape);

              break;
            case TRANSITION:
              shape.setX(
                  tween((float) motion.getParams().get(0), (float) motion.getParams().get(2),
                      motion.getStartTime(), motion.getEndTime(), currentFrame));

              shape.setY(
                  tween((float) motion.getParams().get(1), (float) motion.getParams().get(3),
                      motion.getStartTime(), motion.getEndTime(), currentFrame));
              break;
            case COLORCHANGE:
              shape.setRed(tween(

                  (float) motion.getParams().get(0), (float) motion.getParams().get(3),
                  motion.getStartTime(), motion.getEndTime(), currentFrame)
              );

              shape.setGreen(tween(
                  (float) motion.getParams().get(1), (float) motion.getParams().get(4),
                  motion.getStartTime(), motion.getEndTime(), currentFrame)
              );

              shape.setBlue(
                  tween((float) motion.getParams().get(2), (float) motion.getParams().get(5),
                      motion.getStartTime(), motion.getEndTime(), currentFrame)
              );

              break;

            default:
              //

          }

        }

      }

      shapesToPassToView.add(shape);
    }

    return shapesToPassToView;
  }

  @Override
  public float tween(float value1, float value2, int startTime, int endTime, int frame) {

    if (frame < startTime || frame > endTime) {
      throw new IllegalArgumentException("nono");
    }

    if (startTime == endTime) {
      return value2;
    }

    return (((frame - startTime) * ((value2 - value1) / (endTime - startTime))) + value1);

  }


  private List<IShape> getShapesAtCurrentFrame(int frame) {
    List<IShape> goShapes = new ArrayList<>();

    for (IShape shape : allShapes.values()) {
      if (shape.getTimeOfAppearance() <= frame && frame < shape.getTimeOFDisappearance()) {
        goShapes.add(shape);
      }
    }
    return goShapes;
  }


  /**
   * Class for building the model. Adapter if you wish.
   */
  public static final class Builder implements TweenModelBuilder<IModel> {

    private IModel model;

    public Builder(IModel model) {
      this.model = model;
    }

    @Override
    public TweenModelBuilder<IModel> addOval(String name, float cx, float cy, float xRadius,
        float yRadius, float red, float green, float blue, int startOfLife, int endOfLife) {
      model.addShape(name, ShapeType.ELLIPSE, cx, cy, xRadius, yRadius, startOfLife, endOfLife, red,
          green, blue);
      return this;
    }

    @Override
    public TweenModelBuilder<IModel> addRectangle(String name, float lx, float ly, float width,
        float height, float red, float green, float blue, int startOfLife, int endOfLife) {
      model.addShape(name, ShapeType.RECTANGLE, lx, ly, width, height, startOfLife, endOfLife, red,
          green, blue);

      return this;
    }

    @Override
    public TweenModelBuilder<IModel> addMove(String name, float moveFromX, float moveFromY,
        float moveToX, float moveToY, int startTime, int endTime) {
      model.addMotion(name,
          new Transition(startTime, endTime, moveFromX, moveFromY, moveToX, moveToY,
              model.getShape(name)));

      return this;
    }


    @Override
    public TweenModelBuilder<IModel> addColorChange(String name, float oldR, float oldG, float oldB,
        float newR, float newG, float newB, int startTime, int endTime) {
      model.addMotion(name, new ColorChange(startTime, endTime, oldR, oldG, oldB, newR, newG, newB,
          model.getShape(name)));
      return this;
    }

    @Override
    public TweenModelBuilder<IModel> addScaleToChange(String name, float fromSx, float fromSy,
        float toSx, float toSy, int startTime, int endTime) {
      model.addMotion(name,
          new Scale(startTime, endTime, fromSx, fromSy, toSx, toSy, model.getShape(name)));
      return this;
    }

    @Override
    public IModel build() {
      return model;
    }

  }


}
