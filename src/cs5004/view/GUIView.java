package cs5004.view;

import cs5004.model.IModel;
import cs5004.model.IShape;
import cs5004.util.DrawingPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 * Class GUIView represents operation that can be performed on the GUI. Represents the window
 * itself.
 */
public class GUIView extends JFrame implements IView {

  private int speed;

  protected DrawingPanel drawingPanel;

  protected JPanel buttonsPanel;
  private JScrollPane scrollPane;

  private JButton pause;
  private JButton restart;
  private JButton resume;

  protected IModel model;


  /**
   * Constructor that creates a GUIView Object.
   *
   * @param model model.
   */
  public GUIView(IModel model) {
    this.speed = 1;
    this.model = model;

    initNodes();
    placeNodes();

    setVisible(true);
  }

  private void placeNodes() {
    setSize(500, 500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());

    buttonsPanel.add(pause);
    buttonsPanel.add(restart);
    buttonsPanel.add(resume);

    add(scrollPane, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);
  }

  private void initNodes() {
    drawingPanel = new DrawingPanel();
    drawingPanel.setBackground(Color.white);
    pause = new JButton("pause");
    scrollPane = new JScrollPane();
    scrollPane.getViewport().add(drawingPanel);
    buttonsPanel = new JPanel();

    pause = new JButton("Pause");
    restart = new JButton("Restart");

    resume = new JButton("Resume");

  }


  /**
   * Getter for button.
   *
   * @return play pause.
   */
  public JButton getPause() {
    return pause;
  }

  /**
   * Getter for button.
   *
   * @return play restart.
   */
  public JButton getRestart() {
    return restart;
  }

  /**
   * Getter for button.
   *
   * @return play resume.
   */
  public JButton getResume() {
    return resume;
  }

  @Override
  public void render(List<IShape> shapes) {
    drawingPanel.drawShapes(shapes);
  }

  @Override
  public String showMustShow() {
    return null;
  }

  @Override
  public void changeSpeed(int t) {
    this.speed = t;

  }

  @Override
  public int getSpeed() {
    return this.speed;
  }


}
