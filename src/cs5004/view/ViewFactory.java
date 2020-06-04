package cs5004.view;

import cs5004.model.IModel;

/**
 * Class ViewFactory represents a Factory that creates view objects.
 */
public class ViewFactory {

  /**
   * Method build returns a new View depends on the input.
   *
   * @param viewName name of the view.
   * @param model model.
   * @return View object.
   * @throws IllegalArgumentException if the passsed name of the view is not "text" or "svg".
   */
  public static IView build(String viewName, IModel model) throws IllegalArgumentException {
    switch (viewName) {
      case "svg":
        return new SVGView(model);

      case "text":
        return new TextView(model);

      case "visual":
        return new GUIView(model);
      default:
        throw new IllegalArgumentException("bro;");
    }
  }
}
