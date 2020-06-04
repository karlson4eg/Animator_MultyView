package cs5004;

import cs5004.controller.Controller;
import cs5004.controller.GUIController;
import cs5004.controller.IController;
import cs5004.model.IModel;
import cs5004.model.ModelAnime;
import cs5004.util.AnimationFileReader;
import cs5004.view.IView;
import cs5004.view.TextView;
import cs5004.view.ViewFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Main method.
 */
public class EasyAnimator {

  /**
   * Main method.
   *
   * @param args arguments.
   */
  public static void main(String[] args) {
    IController controller = null;
    IModel model = new ModelAnime();
    IView view = new TextView(model);
    Appendable output = System.out; //fixme sout kind of not good
    int speed = 1; // todo check if this one is related to when you run easyanimator file

    boolean contrGUI = false;

    Map<String, String> options = parseArgs(args);

    for (Map.Entry<String, String> entry : options.entrySet()) {

      switch (entry.getKey()) {
        case "-if":
          try {
            AnimationFileReader afr = new AnimationFileReader();
            model = afr.readFile(entry.getValue(), new ModelAnime.Builder(model));
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          break;
        case "-iv":
          if (entry.getValue().equals("visual")) {
            contrGUI = true;
          }
          try {
            view = ViewFactory.build(entry.getValue(), model);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(),
                "Select a type of View that exists!");
          }
          break;
        case "-o":

          if (entry.getValue().equalsIgnoreCase("out")) {
            output = System.out;
          } else {
            try {
              output = new PrintStream(new File(entry.getValue()));
            } catch (Exception e) {
              JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
            }
          }
          break;
        case "-speed":
          speed = Integer.parseInt(entry.getValue());
          break;

        default:
          //
      }

    }

    view.changeSpeed(speed);



                                        // fixme can be done by using factory #kostyl
    if (contrGUI) {
      controller = new GUIController(model, view);
    } else {
      controller = new Controller(model, view, output);

    }

    controller.run();

  }


  private static Map<String, String> parseArgs(String[] args) {
    Map<String, String> options = new HashMap<>();
    for (int i = 0; i <= args.length - 1; i += 2) {
      options.putIfAbsent(args[i], args[i + 1]);
    }

    if (!(options.containsKey("-if") || (options.containsKey("-iv")))) {
      JOptionPane.showMessageDialog(new JFrame(),
          "Provide both file and view please.!");
    }
    return options;
  }

}