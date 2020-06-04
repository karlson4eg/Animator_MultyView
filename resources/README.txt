Readme3.0
The Animator^tm

The design of this program is implemented using MVC design pattern.
Model part of Animator is able to create different Shapes and Add motions to them,
basically contains two maps associated with shapes and motions.



Controller part is reasonable for transmitting the output to the specified View.
ControllerGUI is responsible for swing GUI view.

All logic is implemented in the model. Shapes are being modified in the original map.

. 
Also view part contains viewfactory for easy use in the main.

____


added setters for shapes.
added GUIVIEW to the View Factory.

____

User can pause, play, restart, resume animation.