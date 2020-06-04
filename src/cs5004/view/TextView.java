package cs5004.view;

import cs5004.model.IModel;
import cs5004.model.IMotion;
import cs5004.model.IShape;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class TextView represents a Text View Object and methods relevant to it.
 */
public class TextView extends AbstractVIew {

  /**
   * Constructor that creates a TEXT View.
   *
   * @param model model.
   */
  public TextView(IModel model) {
    super(model);
  }

  @Override
  public String showMustShow() {
    DecimalFormat formatter = new DecimalFormat("0.00;(0.00)");
    StringBuilder builder = new StringBuilder();

    //All shapes are going here.
    List<IShape> valueList = new ArrayList<>(viewShapes.values());

    //Sorting the shapes in the list.
    Collections.sort(valueList);

    //print all shapes first.
    builder.append("Shapes:\n");

    for (IShape shape : valueList) {

      builder.append("Name : ").append(shape.getId());
      builder.append("\nType : ").append(shape.getType()).append("\n");
      builder.append(shape.getShapeCoords());
      builder.append("\nAppears at t=").append(shape.getTimeOfAppearance() / speed).append("s");
      builder.append("\nDisappears at t=").append(shape.getTimeOFDisappearance() / speed)
          .append("s\n");

    }

    //create a new list of all motions
    List<IMotion> allMotionsForAllShapes = new ArrayList<>();

    //for every motion in the list of motions of certain shape => get all values and add them to
    // the new list of all motions
    for (List<IMotion> list : viewMotions.values()) {
      allMotionsForAllShapes.addAll(list);
    }

    // sort the ultimate list
    Collections.sort(allMotionsForAllShapes);

    //append sorted motions to the output
    for (IMotion motion : allMotionsForAllShapes) {

      builder.append("Shape ").append(motion.getName());

      // get parameters for each motion
      List params = motion.getParams();

      switch (motion.getType().toString()) {
        case "TRANSITION":
          builder.append(" moves from (").append(params.get(0));
          builder.append(",").append(params.get(1)).append(") to (");
          builder.append(params.get(2)).append(",").append(3).append(")");

          break;
        case "SCALE":
          builder.append(" scales from Width: ").append(params.get(0));
          builder.append(", Height: ").append(params.get(1));
          builder.append(" to  Width: ").append(params.get(2));
          builder.append(", Height: ").append(params.get(3));
          break;
        case "COLORCHANGE":
          builder.append(" changes color from (").append((float) params.get(0) * 255).append(",")
              .append((float) params.get(1) * 255).append(",").append((float) params.get(2) * 255)
              .append(")");
          builder.append(" to (").append((float) params.get(3) * 255).append(",")
              .append((float) params.get(4) * 255).append(",").append((float) params.get(5) * 255)
              .append(")");

          break;
        default:
          //

      }

      builder.append(" from t=").append(motion.getStartTime() / speed).append("s ");
      builder.append("to t=").append(motion.getEndTime() / speed).append("s\n");

    }

    return builder.toString();
  }


}

