package cs5004.util;

import cs5004.model.IShape;
import cs5004.model.ShapeType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

/**
 * Class DrawingPanel represents the panel that is gonna be a canvas for our animator. All shapes
 * will be displayed here using swing.
 */
public class DrawingPanel extends JPanel implements IDrawingPanel {

  List<IShape> shapesToDraw = null;

  @Override
  public void drawShapes(List<IShape> shapesToDraw) {
    this.shapesToDraw = shapesToDraw;

    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // FIXME breaking point
    if (shapesToDraw != null) {

      for (IShape shape : this.shapesToDraw) {

        g.setColor(new Color(shape.getRed(), shape.getGreen(), shape.getBlue()));

        if (shape.getType() == ShapeType.RECTANGLE) {
          g.fillRect((int) shape.getX(), (int) shape.getY(), (int) shape.getWidth(),
              (int) shape.getHeight());
        } else if (shape.getType() == ShapeType.ELLIPSE) {
          g.fillOval((int) (shape.getX() - shape.getWidth()),
              (int) (shape.getY() - shape.getHeight()),
              (int) (shape.getWidth() * 2), (int) (shape.getHeight() * 2));
        }
      }
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 1000);
  }
}

