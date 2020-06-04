package cs5004.view;

import cs5004.model.IModel;
import cs5004.model.IMotion;
import cs5004.model.IShape;
import java.util.List;
import java.util.Map;

/**
 * Abstract class AbstractVIew represents similar properties for different Views.
 */
public abstract class AbstractVIew implements IView {

  protected int speed;
  protected IModel model;

  protected Map<String, IShape> viewShapes;
  protected Map<String, List<IMotion>> viewMotions;

  /**
   * Constructor that creates an AbstractVIew object.
   *
   * @param model model.
   */
  public AbstractVIew(IModel model) {
    this.speed = 1;

    this.model = model;
    this.viewMotions = model.getMotions();
    this.viewShapes = model.getShapes();
  }

  @Override
  public void changeSpeed(int t) {
    this.speed = t;
  }

  @Override
  public void render(List<IShape> shapes) {
    System.out.println("Not applicable for this view. Try to call showMustShow to get text."); // fixme maybe use logger? lol
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }
}
