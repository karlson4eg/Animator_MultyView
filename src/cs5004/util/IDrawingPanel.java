package cs5004.util;

import cs5004.model.IShape;
import java.util.List;

/**
 * Interface IDrawingPanel represents all the operations that drawing panel is providing.
 */
public interface IDrawingPanel {

  void drawShapes(List<IShape> shapesToDraw);

}
