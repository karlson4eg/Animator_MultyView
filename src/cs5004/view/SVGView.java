package cs5004.view;

import cs5004.model.IModel;
import cs5004.model.IMotion;
import cs5004.model.IShape;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Class SVGView represents a Text View Object and methods relevant to it.
 */
public class SVGView extends AbstractVIew {

  DecimalFormat formatter;

  /**
   * Constructor that creates a SVG View.
   *
   * @param model model.
   */
  public SVGView(IModel model) {
    super(model);
  }


  @Override
  public String showMustShow() {
    StringBuilder builder = new StringBuilder();

    builder.append("<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\">\n");

    for (IShape shape : viewShapes.values()) {

      builder.append("<");

      builder.append(shape.getType().getType());

      builder.append(" id=\"").append(shape.getId()).append("\"");

      switch (shape.getType().getType()) {
        case "rect":
          builder.append(" x=\"").append(shape.getX()).append("\"");
          builder.append(" y=\"").append(shape.getY()).append("\"");
          builder.append(" width=\"").append(shape.getWidth()).append("\"");
          builder.append(" height=\"").append(shape.getHeight()).append("\"");

          break;
        case "ellipse":
          builder.append(" cx=\"").append(shape.getX()).append("\"");
          builder.append(" cy=\"").append(shape.getY()).append("\"");
          builder.append(" rx=\"").append(shape.getWidth()).append("\"");
          builder.append(" ry=\"").append(shape.getHeight()).append("\"");

          break;
        default:
          break;
      }
      formatter = new DecimalFormat("0.00;(0.00)");
      builder.append(" fill=\"rgb(").append(formatter.format(shape.getRed() * 255))
          .append(",").append(formatter.format(shape.getGreen() * 255))
          .append(",").append(formatter.format(shape.getBlue() * 255)).append(")\"");
      builder.append(" visibility=\"visible\">\n");

      for (IMotion motion : viewMotions.get(shape.getId())) {
        List params = motion.getParams();

        switch (motion.getType()) {
          case TRANSITION:
            builder.append("<animate").append(" attributeType=\"xml\" ");
            builder.append("begin=\"").append(motion.getStartTime() / speed * 1000).append("ms\"");
            builder.append(" dur=\"")
                .append((motion.getEndTime() - motion.getStartTime()) / speed * 1000)
                .append("ms\" ");

            switch (shape.getType()) {
              case ELLIPSE:
                if (params.get(1).equals(params.get(3))) { // y1 == y2
                  builder.append("attributeName=\"cx\" from=\"")
                      .append(params.get(0)).append("\" to=\"").append(params.get(2)).append("\"");
                } else if (params.get(0).equals(params.get(2))) { // x1 == x2
                  builder.append("attributeName=\"cy\" from=\"")
                      .append(params.get(1)).append("\" to=\"").append(params.get(3)).append("\"");
                } else {
                  builder.append("attributeName=\"cx\" from=\"");
                  builder.append(params.get(0)).append("\" to=\"").append(params.get(2))
                      .append("\"");
                  builder.append("attributeName=\"cy\" from=\"");
                  builder.append(params.get(1)).append("\" to=\"").append(params.get(3))
                      .append("\"");
                }

                break;
              case RECTANGLE:
                if (params.get(1).equals(params.get(3))) { // y1 == y2
                  builder.append("attributeName=\"x\" from=\"")
                      .append(params.get(0)).append("\" to=\"").append(params.get(2)).append("\"");
                } else if (params.get(0).equals(params.get(2))) { // x1 == x2
                  builder.append("attributeName=\"y\" from=\"")
                      .append(params.get(1)).append("\" to=\"").append(params.get(3)).append("\"");
                } else {
                  builder.append("attributeName=\"x\" from=\"").append(params.get(0))
                      .append("\" to=\"");
                  builder.append(params.get(2)).append("\"");
                  builder.append("attributeName=\"y\" from=\"");
                  builder.append(params.get(1)).append("\" to=\"").append(params.get(3))
                      .append("\"");
                }
                break;
              default:
                break;
            }

            builder.append(" fill=\"freeze\"/>\n");
            break;
          case SCALE:
            builder.append("<animateTransform").append(" attributeType=\"XML\" ");
            builder.append("begin=\"").append(motion.getStartTime() / speed * 1000).append("ms\"");
            builder.append(" dur=\"")
                .append((motion.getEndTime() - motion.getStartTime()) / speed * 1000)
                .append("ms\" ");
            builder.append("attributeName=\"transform\" type=\"scale\" from=\"");
            builder.append(params.get(0)).append(",").append(params.get(1)).append("\"");
            builder.append(" to=\"").append(params.get(2)).append(",").append(params.get(3))
                .append("\"");
            builder.append(" additive=\"sum\" fill=\"freeze\"/>\n");
            break;
          case COLORCHANGE:
            builder.append("<animate").append(" attributeType=\"xml\" ");
            builder.append("begin=\"").append(motion.getStartTime() / speed * 1000).append("ms\"");
            builder.append(" dur=\"")
                .append((motion.getEndTime() - motion.getStartTime()) / speed * 1000)
                .append("ms\" ");
            builder.append(" attributeName=\"fill\" to=\"rgb(")
                .append((float) (params.get(3)) * 255).append(",")
                .append((float) (params.get(4)) * 255).append(",")
                .append((float) params.get(5) * 255).append(")\"");
            builder.append(" fill=\"freeze\"/>\n");
            break;

          default:
            //
        }
      }
      builder.append("</").append(shape.getType().getType()).append(">\n");
    }

    builder.append("</svg>\n");

    return builder.toString();
  }

}
