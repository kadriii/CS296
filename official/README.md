# CS 296-25 Honors Project

## How to Play

Collect the components of your ECE 385 final project in this maze riddled with riddles. The correct answer
to each riddle will lead to a UIUC themed location with a different component and riddle. An incorrect answer
will take the player to an undefined location to be sent home to restart the maze. When all items have been 
collected then the "make" command should be used to create the final project. After that, the player should
return to the ECEB to submit the project and finish the game.

## Commands

look: Display the current room's description and riddle  
north: selects the north option  
south: selects the south option  
west: selects the west option  
east: selects the east option  
giveup: exits the game  
backpack: views the inventory contents  
grab: collect the object in the current room  
status: display the current location with the backpack contents  
home: return to the home location  
call: talk to your friend Khory  
help: get hints on your current progress  
commands: display the possible commands  
make: obtain the final project once all pieces have been collected  
submit: finish the game once the final project has been made  


## Usage

The main file you want to edit is `src/adventure/core.clj`.

To run the program, use `lein run` from the command line.

## License

Copyright © 2016 Mattox Beckman, free for personal and educational use.
