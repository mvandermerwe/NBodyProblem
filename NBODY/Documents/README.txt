Welcome to the N Body Simulation Environment

Our program has several added functionality beyond the basic simulation of the satellites.

When you click on planets, the planet will explode into flotsam. The flotsam is designed to
populate the area where the planet was.

When you want to supernova, click on the sun. The sun will decrease in size (after all this
is what happens), change color, and all the planets in the system will explode into flotsam
from the "radiation."

Note: When you first enter the planets, a strange bug occurs in which they are slightly too low.
By scrolling, you will recall their placement code and they will be placed where they should be.
A quick debug session revealed that in the set up code, the JPanel size passed in mysteriously 
changes and we have not yet adjusted this.

Note: Dragging doesn't work great. If you run into issues drag your mouse to the top left
corner and you should be able to see everything again.