/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToeGame {

// FINISH THE VARIABLE DECLARATION
   /**
	* The board of the game, stored as a one dimension array.
	*/
	private CellValue[] board;

   /**
	* level records the number of rounds that have been
	* played so far.
	*/
	private int level = 0;

   /**
	* gameState records the current state of the game.
	*/
	private GameState gameState = GameState.PLAYING;


   /**
	* lines is the number of lines in the grid
	*/
	private int lines;

   /**
	* columns is the number of columns in the grid
	*/
	private int columns;


   /**
	* sizeWin is the number of cell of the same type
	* that must be aligned to win the game
	*/
	private int sizeWin;

	private int numberOfXs=0;
	private int numberOfOs=0;
   /**
	* default constructor, for a game of 3x3, which must
	* align 3 cells
	*/
	public TicTacToeGame(){

		// YOUR CODE HERE
		lines = 3;
		columns = 3;
		sizeWin = 3;

		// I'm a bit hesitant on this one
		board = new CellValue[9];
		for (int i=0; i<board.length; i++){
			// initializing cells as empty
			board[i] = CellValue.EMPTY;
		}

	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game. 3 cells must
	* be aligned.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
  	*/
	public TicTacToeGame(int lines, int columns){

		// YOUR CODE HERE

		this.lines = lines;
		this.columns = columns;
		sizeWin = 3;

		// I'm a bit hesitant on this one
		board = new CellValue[lines*columns];
		for (int i=0; i<board.length; i++){
			// initializing cells as empty
			board[i] = CellValue.EMPTY;
		}

	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game, as well as
	* the number of cells that must be aligned to win.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
  	*/
	public TicTacToeGame(int lines, int columns, int sizeWin){

		// YOUR CODE HERE
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;

		// I'm a bit hesitant on this one
		board = new CellValue[lines*columns];
		for (int i=0; i<board.length; i++){
			// initializing cells as empty
			board[i] = CellValue.EMPTY;
		}
	}



   /**
	* getter for the variable lines
	* @return
	* 	the value of lines
	*/
	public int getLines(){

		// YOUR CODE HERE
		return this.lines;

	}

   /**
	* getter for the variable columns
	* @return
	* 	the value of columns
	*/
	public int getColumns(){

		// YOUR CODE HERE
		return this.columns;

	}

   /**
	* getter for the variable level
	* @return
	* 	the value of level
	*/
	public int getLevel(){

		// YOUR CODE HERE
		return this.level;

	}

  	/**
	* getter for the variable sizeWin
	* @return
	* 	the value of sizeWin
	*/
	public int getSizeWin(){

		// YOUR CODE HERE
		return this.sizeWin;

	}

   /**
	* getter for the variable gameState
	* @return
	* 	the value of gameState
	*/
	public GameState getGameState(){

		// YOUR CODE HERE
		return gameState;

	}

   /**
	* returns the cellValue that is expected next,
	* in other word, which player (X or O) should
	* play next.
	* This method does not modify the state of the
	* game.
	* @return
    *  the value of the enum CellValue corresponding
    * to the next expected value.
  	*/
	public CellValue nextCellValue(){

		// YOUR CODE HERE -- Not Sure
		/*if(numberOfXs+numberOfOs==0){
			numberOfXs++;
			return CellValue.X;
		} else {
			if(numberOfOs<numberOfXs){
				numberOfOs++;
				return CellValue.O;
			} else {
				numberOfXs++;
				return CellValue.X;
			}
		}*/
		if(level%2==1){
			return CellValue.O;
		} else {
			return CellValue.X;
		}
	}

   /**
	* returns the value  of the cell at
	* index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
   	* @param i
    *  the index of the cell in the array board
    * @return
    *  the value at index i in the variable board.
  	*/
	public CellValue valueAt(int i) {
		// YOUR CODE HERE
		if (i>=(lines*columns)){
			System.out.println("ERROR! Index is invalid!");
			return null;
		} else {
			return board[i];
		}

	}

   /**
	* This method is called when the next move has been
	* decided by the next player. It receives the index
	* of the cell to play as parameter.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is
	* printed out. The behaviour is then unspecified
	* If the move is valide, the board is updated, as well
	* as the state of the game.
	* To faciliate testing, is is acceptable to keep playing
	* after a game is already won. If that is the case, the
	* a message should be printed out and the move recorded.
	* the  winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been
    * selected by the next player
  	*/
	public void play(int i) {

		// YOUR CODE HERE
		CellValue nextPlayer = nextCellValue();
		// next variable is set to true if board was updated and false if not
		boolean updated = false;

		// next few statements check if index is invalid
		// and if it is then update board
		if (i>=lines*columns){
			System.out.println("Error! Index invalid!");
		} else if (board[i]!=CellValue.EMPTY){
			System.out.println("Error! Selected cell is already taken");
		} else {
			board[i] = nextPlayer;
			updated = true;
		}

		if(updated){
			// method is still under construction...
			setGameState(i);
			level++;
		}
		

	}


   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set in
	* the method play(int i)
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (i.e. the game was playing). Therefore, it only needs to
	* check if playing at index i has concluded the game, and if
	* set the oucome correctly
	*
   	* @param i
    *  the index of the cell in the array board that has just
    * been set
	  */

	private void checkWinnerHorizontally(){
		int counter = 1;

		for(int i=0; i<lines*columns; i+=columns){
			for(int j=i; j<i+columns-1; j++){
				if(board[j]==board[j+1]){
					counter++;
					if(counter==sizeWin){
						if (valueAt(j)==CellValue.X){
							gameState = GameState.XWIN;
							System.out.println("X WON!");
							break;
						} else if (valueAt(j)==CellValue.O){
							gameState = GameState.OWIN;
							System.out.println("O WON!");
							break;
						}
					}
				} else {
					counter = 1;
				}
			}
			if (gameState==GameState.XWIN || gameState==GameState.OWIN){
				break;
			}
		}
	}

	private void checkWinnerVertically(){
		int count = 1;

		for (int i=0; i<columns; i++){
			for(int j=i; j<=columns*(lines-2); j+=columns){
				if(board[j]==board[j+columns]){
					count+=1;
					if(count==sizeWin){
						if(valueAt(j)==CellValue.X){
							gameState = GameState.XWIN;
							System.out.println("X WON!");
							break;
						} else if (valueAt(j)==CellValue.O){
							gameState = GameState.OWIN;
							System.out.println("O WON!");
							break;
						}
					}
				} else {
					count=1;
				}
			}
			if (gameState==GameState.XWIN || gameState==GameState.OWIN){
				break;
			}
		}
	}

	private void checkWinnerDiagonal(){
		int count = 1;

		for (int i=0; i<=(lines-sizeWin)*columns; i+=columns){
			for (int j=i; j<i+(columns-sizeWin)+1; j++){
			  for(int k=j; k<j+(columns+1)*(sizeWin-1); k+=columns+1){
				  // System.out.print(k+" ");
				if(board[k]==board[k+columns+1]){
					count++;
					if(count==sizeWin){
						if(valueAt(k)==CellValue.X && level%2==0){
							gameState = GameState.XWIN;
							// System.out.println("X WON!");
							break;
						} else if (valueAt(k)==CellValue.O && level%2==1){
							gameState = GameState.OWIN;
							// System.out.println("O WON!");
							break;
						}
					}
				} else {
					count=1;
				}
			  }
			  // System.out.println("***********");
			  if(gameState==GameState.XWIN || gameState==GameState.OWIN){
				break;
			}
			}
			// System.out.println("------------");
			if(gameState==GameState.XWIN || gameState==GameState.OWIN){
				break;
			}
			
		  }
		// System.out.println("Fin diagonale");
	}


	private void checkWinnerCounterDiagonal(){
		int count = 1;

		for (int i=columns-1; i<=(lines-sizeWin)*columns+columns-1; i+=columns){
			for (int j=i; j>i-(columns-sizeWin)-1; j--){
			  for(int k=j; k<j+(columns-1)*(sizeWin-1); k+=columns-1){
				  // System.out.print(k+" ");
				if(board[k]==board[k+columns-1]){
					count++;
					if(count==sizeWin){
						if(valueAt(k)==CellValue.X && level%2==0){
							gameState = GameState.XWIN;
							// System.out.println("X WON!");
							break;
						} else if (valueAt(k)==CellValue.O && level%2==1){
							gameState = GameState.OWIN;
							// System.out.println("O WON!");
							break;
						}
					}
				} else {
					count=1;
				}
			  }
			  // System.out.println("***********");
			  if(gameState==GameState.XWIN || gameState==GameState.OWIN){
				break;
			}
			}
			// System.out.println("------------");
			if(gameState==GameState.XWIN || gameState==GameState.OWIN){
				break;
			}
			
		  }
		// System.out.println("Fin diagonale");
	}


	private void setGameState(int i) {

		// YOUR CODE HERE
		checkWinnerHorizontally();
		checkWinnerVertically();
		checkWinnerDiagonal();
		checkWinnerCounterDiagonal();
		if (gameState!=GameState.XWIN || gameState!=GameState.OWIN){
			if(level==board.length){
				gameState = GameState.DRAW;
			}
		} 
		//check vertical X
		// for(int v=0; v<lines; v++){
			//System.out.print("Ignore this"); //I got tired, this is where I stopped after the display method
		//}

		// toughest method!!!
		// if (xWin){
			//gameState=GameState.PLAYING;
		//}else if (oWin){
			//gameState=GameState.OWIN;

		//}else if (drawn){
			//gameState=GameState.DRAWN;
		//}else{
			//gameState=GameState.PLAYING;
		//}

	}



   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	*
   	* @return
    *  String representation of the game
  	*/

	public String toString(){
		String str="";
		// YOUR CODE HERE
		for (int l=0; l<lines; l++){
			for (int c=0; c<columns; c++){
				switch(board[l*columns+c]){
					case O:
						str+=" O ";
						break;
					case X:
						str+=" X ";
						break;
					case EMPTY:
						str+="   ";
						break;
					default:
				  	str+="def";
						break;
				}
				if (((c+1)%columns!=0)){
					str+="|";
				}else{
					str+="\n";
				}
			}
			if (l<lines-1){
				str+="---";
				for (int i=0; i<columns-1; i++){
					str+="----";
				}
			}
			str+="\n";
		}
		return str;
	}

}
