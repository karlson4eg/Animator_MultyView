package cs5004.controller;

import cs5004.model.IModel;
import cs5004.view.GUIView;
import cs5004.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Class GUIController represents all operations that can be performed on the Controller for GUI
 * swig view.
 */
public class GUIController implements IController {

  private IModel model;
  private IView view;
  private Timer timer;
  private int currentFrame;

  /**
   * Constructor that creates an object of Controller that is resposible for connecting model and
   * view. Getting data from model and sending it to the view.
   *
   * @param model model.
   * @param view view.
   */
  public GUIController(IModel model, IView view) {

    this.model = model;
    this.view = view;

    currentFrame = 1;

    timer = new Timer(1000 / view.getSpeed(), new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        view.render(model.getShapesForViewAtFrame(currentFrame));

        currentFrame++;


      }    //end of actionperformed

    }); // end of timer

    initActions();
  }


  private void initActions() {
    ((GUIView) view).getRestart().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        currentFrame = 1;
        timer.restart();
        ((GUIView) view).render(model.getShapesForViewAtFrame(currentFrame)); //shapes
      }

    });

    ((GUIView) view).getPause().addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        timer.stop(); // ???
      }
    });

    ((GUIView) view).getResume().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timer.start(); // ???
      }

    });

  }

  @Override
  public void run() {
    timer.start();
  }

}