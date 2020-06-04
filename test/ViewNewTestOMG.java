
import static org.junit.Assert.assertEquals;

import cs5004.model.IModel;
import cs5004.model.ModelAnime;
import cs5004.util.AnimationFileReader;
import cs5004.view.IView;
import cs5004.view.SVGView;
import cs5004.view.TextView;
import org.junit.Before;
import org.junit.Test;


/**
 * Testing.
 */
public class ViewNewTestOMG {

  IModel model;
  IView view;

  @Before
  public void setUp() {
    model = new ModelAnime();

  }


  @Test
  public void svgTestOutput() {
    view = new SVGView(model);
    AnimationFileReader afr = new AnimationFileReader();
    try {
      model = afr.readFile("toh-3.txt", new ModelAnime.Builder(model));
    } catch (Exception e) {
      e.printStackTrace();
    }

    assertEquals("<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"disk1\" x=\"190.0\" y=\"180.0\" width=\"20.0\" height=\"30.0\""
        + " fill=\"rgb(0.47,49.85,90.44)\" visibility=\"visible\">\n"
        + "<animate attributeType=\"xml\" begin=\"25000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"180.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"36000ms\" dur=\"10000ms\""
        + " attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"47000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"89000ms\" dur=\"10000ms\" "
        + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"100000ms\" dur=\"10000ms\""
        + " attributeName=\"x\" from=\"490.0\" to=\"340.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"111000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"153000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"164000ms\" dur=\"10000ms\""
        + " attributeName=\"x\" from=\"340.0\" to=\"190.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"175000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"217000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"228000ms\" dur=\"10000ms\""
        + " attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"239000ms\" dur=\"10000ms\" "
        + "attributeName=\"y\" from=\"50.0\" to=\"180.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"249000ms\" dur=\"8000ms\" "
        + " attributeName=\"fill\" to=\"rgb(0.0,255.0,0.0)\" fill=\"freeze\"/>\n"
        + "</rect>\n"
        + "<rect id=\"disk2\" x=\"167.5\" y=\"210.0\" width=\"65.0\" height=\"30.0\""
        + " fill=\"rgb(6.58,247.15,41.80)\" visibility=\"visible\">\n"
        + "<animate attributeType=\"xml\" begin=\"57000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"68000ms\" dur=\"10000ms\""
        + " attributeName=\"x\" from=\"167.5\" to=\"317.5\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"79000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"185000ms\" dur=\"10000ms\""
        + " attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"196000ms\" dur=\"10000ms\""
        + " attributeName=\"x\" from=\"317.5\" to=\"467.5\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"207000ms\" dur=\"10000ms\" "
        + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"217000ms\" dur=\"8000ms\" "
        + " attributeName=\"fill\" to=\"rgb(0.0,255.0,0.0)\" fill=\"freeze\"/>\n"
        + "</rect>\n"
        + "<rect id=\"disk3\" x=\"145.0\" y=\"240.0\" width=\"110.0\" height=\"30.0\""
        + " fill=\"rgb(11.34,45.74,175.32)\" visibility=\"visible\">\n"
        + "<animate attributeType=\"xml\" begin=\"121000ms\" dur=\"10000ms\" "
        + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"132000ms\" dur=\"10000ms\" "
        + "attributeName=\"x\" from=\"145.0\" to=\"445.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"143000ms\" dur=\"10000ms\" "
        + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"153000ms\" dur=\"8000ms\"  "
        + "attributeName=\"fill\" to=\"rgb(0.0,255.0,0.0)\" fill=\"freeze\"/>\n"
        + "</rect>\n"
        + "</svg>\n", view.showMustShow());


  }


  @Test
  public void textTestOUT() {

    view = new TextView(model);
    AnimationFileReader afr = new AnimationFileReader();
    try {
      model = afr.readFile("toh-3.txt", new ModelAnime.Builder(model));
    } catch (Exception e) {
      e.printStackTrace();
    }

    assertEquals("Shapes:\n"
            + "Name : disk1\n"
            + "Type : RECTANGLE\n"
            + "Min corner: (190.0,180.0), Width: 20.0, Height: 30.0, Color: "
            + "(0.47328362,49.84622,90.440994)\n"
            + "\n"
            + "Appears at t=1s\n"
            + "Disappears at t=302s\n"
            + "Name : disk2\n"
            + "Type : RECTANGLE\n"
            + "Min corner: (167.5,210.0), Width: 65.0, Height: 30.0, Color: "
            + "(6.5849085,247.1456,41.802372)\n"
            + "\n"
            + "Appears at t=1s\n"
            + "Disappears at t=302s\n"
            + "Name : disk3\n"
            + "Type : RECTANGLE\n"
            + "Min corner: (145.0,240.0), Width: 110.0, Height: 30.0, Color: "
            + "(11.344268,45.741367,175.31712)\n"
            + "\n"
            + "Appears at t=1s\n"
            + "Disappears at t=302s\n"
            + "Shape disk1 moves from (190.0,180.0) to (190.0,3) from t=25s to t=35s\n"
            + "Shape disk1 moves from (190.0,50.0) to (490.0,3) from t=36s to t=46s\n"
            + "Shape disk1 moves from (490.0,50.0) to (490.0,3) from t=47s to t=57s\n"
            + "Shape disk2 moves from (167.5,210.0) to (167.5,3) from t=57s to t=67s\n"
            + "Shape disk2 moves from (167.5,50.0) to (317.5,3) from t=68s to t=78s\n"
            + "Shape disk2 moves from (317.5,50.0) to (317.5,3) from t=79s to t=89s\n"
            + "Shape disk1 moves from (490.0,240.0) to (490.0,3) from t=89s to t=99s\n"
            + "Shape disk1 moves from (490.0,50.0) to (340.0,3) from t=100s to t=110s\n"
            + "Shape disk1 moves from (340.0,50.0) to (340.0,3) from t=111s to t=121s\n"
            + "Shape disk3 moves from (145.0,240.0) to (145.0,3) from t=121s to t=131s\n"
            + "Shape disk3 moves from (145.0,50.0) to (445.0,3) from t=132s to t=142s\n"
            + "Shape disk3 moves from (445.0,50.0) to (445.0,3) from t=143s to t=153s\n"
            + "Shape disk1 moves from (340.0,210.0) to (340.0,3) from t=153s to t=163s\n"
            + "Shape disk3 changes color from (11.344268,45.741367,175.31712) to (0.0,255.0,0.0) "
            + "from t=153s to t=161s\n"
            + "Shape disk1 moves from (340.0,50.0) to (190.0,3) from t=164s to t=174s\n"
            + "Shape disk1 moves from (190.0,50.0) to (190.0,3) from t=175s to t=185s\n"
            + "Shape disk2 moves from (317.5,240.0) to (317.5,3) from t=185s to t=195s\n"
            + "Shape disk2 moves from (317.5,50.0) to (467.5,3) from t=196s to t=206s\n"
            + "Shape disk2 moves from (467.5,50.0) to (467.5,3) from t=207s to t=217s\n"
            + "Shape disk1 moves from (190.0,240.0) to (190.0,3) from t=217s to t=227s\n"
            + "Shape disk2 changes color from (6.5849085,247.1456,41.802372) to (0.0,255.0,0.0) "
            + "from t=217s to t=225s\n"
            + "Shape disk1 moves from (190.0,50.0) to (490.0,3) from t=228s to t=238s\n"
            + "Shape disk1 moves from (490.0,50.0) to (490.0,3) from t=239s to t=249s\n"
            + "Shape disk1 changes color from (0.47328362,49.84622,90.440994) to (0.0,255.0,0.0) "
            + "from t=249s to t=257s\n",
        view.showMustShow());
  }


}
