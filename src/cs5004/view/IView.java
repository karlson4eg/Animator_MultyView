package cs5004.view;

import cs5004.model.IShape;
import java.util.List;

/**
 * Interface IView represents common methods for all views in the MVC model for animator program.
 */
public interface IView {

  /**
   * Method getSpeed returns current speed of the animation passed by user.
   */
  int getSpeed();

  /**
   * Method showMustShow returns a String that contains description of the animation.
   *
   * @return description of the animation.
   */
  String showMustShow();

  /**
   * Method changeSpeed changers the speed of the animation.
   *
   * @param t frames per second.
   */
  void changeSpeed(int t);

  /**
   * Method render starts the animation by passing the list to the drawing panel.
   */
  void render(List<IShape> shapes);

}
