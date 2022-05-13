// Package, provides sets of input and output streams
import java.io.*; 

public class GameLogic {

// Local variables from Board and Player
  private Board board;
  // Human player
  private Player player1;
  // Computer player
  private Player player2;

// Constructor initialises objects 
  public GameLogic() {
    board = new Board();
    player1 = new Player("r");
    player2 = new Player("y");
  }

  // PlayGame method which is called from Main 
  // Prints initial text and board
  public void playGame() {
    System.out.println("Welcome to Connect4! ");
    System.out.println("There are 2 players: red, 'r' and yellow, 'y'.");
    System.out.println("Player 1 is red, Player 2 is yellow.");
    System.out.println("To play the game type in the number of the column you want to drop you counter in.");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally.");
    System.out.println("To replay, rerun the programme.");
    System.out.println("");
    System.out.println(board.getPrintableBoard());
 
    // Checks for draw
    //boolean test = false;
    //test = board.isFull();

    while (!board.hasWon()) {

      // Player 1
      int userInput = 0;
      Player player = player1;
      boolean valid = false;

      // Checks if player input is valid
      do{
        userInput = player.getUserInput();
        if (userInput <= 7 && userInput > 0) {
          valid = true;
        }
        else {
          System.out.println("Please enter a number from 1 to 7.");
        }
      }
      while (!valid);

      // Checks for space in column before adding counter
      boolean placedFlag = board.placeCounter('r', userInput);
      if (placedFlag == true) {
        // 
      }
      else {
        System.out.println("The column is full, pick another.");
        continue;
      }

      // Prints board with added counters and checks if player has won
      System.out.println(board.getPrintableBoard());
      board.winOrNot('r');
      
      if (board.hasWon()) {
        System.out.println("");
      } else {
        player = player2;

        // Checks for space in column before adding counter
        do {
          placedFlag = board.placeCounter('y', player.getRandom());
          }
        while (!placedFlag);
    
        // Prints board with added counters and checks if player has won
        String pb = board.getPrintableBoard();
        System.out.println(pb);
        board.winOrNot('y');
      }
    }
  }
}