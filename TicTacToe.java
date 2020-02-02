
import java.io.Console;

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  TicTacToeGame
     * and starts the game. If two parameters lines  and columns
     * are passed, they are used. If the paramters lines, columns
     * and win are passed, they are used.
     * Otherwise, a default value is used. Defaults values (3) are also
     * used if the paramters are too small (less than 2).
     * Here, we assume that the command lines arguments are indeed integers
     *
     * @param args
     *            command lines parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        Console console = System.console();
        TicTacToeGame game;
        int lines, columns, win;
        lines = 3;
        columns = 3;
        win = 3;

        if (args.length >= 2) {
            lines = Integer.parseInt(args[0]);
            if(lines<2){
                System.out.println("Invalid argument, using default...");
                lines = 3;
            }
            columns = Integer.parseInt(args[1]);
            if(columns<2){
                System.out.println("Invalid argument, using default...");
                columns = 3;
            }
        }
        if (args.length >= 3){
            win = Integer.parseInt(args[2]);
            if(win<2){
                System.out.println("Invalid argument, using default...");
                win = 3;
            }
        }
        if (args.length > 3){
            System.out.println("Too many arguments. Only the first 3 are used.");
        }

        game = new TicTacToeGame(lines, columns, win);

        // YOUR CODE HERE
        int inputNumber;

        //Play the game so long as the GameState of game is PLAYING
        while(game.getGameState()==GameState.PLAYING){
          
          //This prints the board in the console
          System.out.print(game.toString());
          
          //This switch asks for X or O to play depending on the turn
          switch(game.getLevel()%2){
            case 0:
              System.out.print("X to play:");
              break;
            case 1:
              System.out.print("O to play:");
              break;
            default:
              System.out.print("Something's wrong I can feel it");
              break;
          }
          //Gets the number from the console
          inputNumber=Integer.parseInt(System.console().readLine());
          //Most important function
          //play calls many functions internaly inside TicTacToeGame.java
          //in order to enter the X or O at the appropriate place if valid.
          game.play(inputNumber);
        }

    }

}
