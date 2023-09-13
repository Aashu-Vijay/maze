package maze;

import maze.labyrinth.*;

public class Main {
     private static final String YOUR_NAME = "VijayDeepak";

     /* Change these constants to contain the paths out of your mazes. */
     private static final String PATH_OUT_OF_MAZE        = "WWWSSENEEWWSEESNWWWSE";
     private static final String PATH_OUT_OF_TWISTY_MAZE = "WWWSSEEESNWWNEEWWSWSE";

    public static void main(String[] args) {
        MazeCell startLocation = MazeUtilities.mazeFor(YOUR_NAME);
        
          if (MazeUtilities.isPathToFreedom(startLocation, PATH_OUT_OF_MAZE)) {
            System.out.println("Congratulations! You've found a way out of your labyrinth.");
        } else {
            System.out.println("Sorry, but you're still stuck in your labyrinth.");
            
        }
       
         MazeCell twistyStartLocation = MazeUtilities.twistyMazeFor(YOUR_NAME);
        int i =1;
        if (MazeUtilities.isPathToFreedom(twistyStartLocation, PATH_OUT_OF_TWISTY_MAZE)) {
            System.out.println("Congratulations! You've found a way out of your twisty labyrinth.");
        } else {
            System.out.println("Sorry, but you're still stuck in your twisty labyrinth.");
        }
    }
}
