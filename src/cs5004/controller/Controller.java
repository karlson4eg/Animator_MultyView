package cs5004.controller;

import cs5004.model.IModel;
import cs5004.view.IView;
import java.io.IOException;

/**
 * Class Controller represents a Controller for the MVC model for our Animator program.
 */
public class Controller implements IController {

  Appendable appendable;

  IModel model;
  IView view;

  /**
   * Constructor that creates a Controller object.
   *
   * @param model model.
   * @param view view.
   * @param appendable output.
   */
  public Controller(IModel model, IView view, Appendable appendable) {
    this.model = model;
    this.view = view;
    this.appendable = appendable;
  }


  @Override
  public void run() {

    try {
      appendable.append(view.showMustShow());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


}