package model;
import control.StopWatch;
import model.*;
import control.GameController;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class GameModel {
	PlayerRoster  playerCatalogue;
	GameRecord gamesCatalogue;
	Player [] gamePlayers = null;		
	String[][] gameBoard;
	GameController gc;
 
	/* Changes for Lab 08 */
	Boolean gameEnded = false;
	Boolean mover;
	int moves;
	
	public GameModel(GameController gc) {
		this.gc=gc;
		gamePlayers = new Player[2];
		gameBoard= null;
		playerCatalogue = new PlayerRoster();
		gamesCatalogue = new GameRecord();
		/* Changes for Lab 08 */
		mover=false;
		moves=0;
	}
	
	public void selectPlayer(Player player, int pos) {
		if (pos<0 && pos>1){
			return;
		}
		//PlayerRoster obj = new PlayerRoster();
		gamePlayers[pos] = player;
	}
	
	
	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] !=null);
	}
	
	
	public void startGame() {
		gameBoard= new String[3][3];
	}
	
	
	public boolean inPlay() {
		return gameBoard !=null && moves <9;
	}
	
	public boolean NoPlay() {
		return !inPlay();
	}
	
	/* Changes for Lab 08 */
	public int getMover() {
		return mover.compareTo(false);
	}
	
	
	public Player[] getGamePlayers() {
		return gamePlayers;
	}
	

	public String[][] getGameBoard() {
		return gameBoard;
	}
	
	/* Changes for Lab 08 */
	public void checkDimValidity(int row, int col) {
		if (row <0 || col < 0 || row > 2 || col >2) {
			throw new IndexOutOfBoundsException(row + ","+col +" is not a valid board cell");
		}
	}
	
	/* Changes for Lab 08 */
	public void checkMoveValidity(int row, int col) {
		checkDimValidity(row, col);
		if (gameBoard[row][col]!=null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}
	
	/* Changes for Lab 08 */
	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public PlayerRoster getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayerRoster playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}
	
	/* Changes for Lab 08 */
	public int makeMove(int row, int col) {
		if(gameEnded == false) {
			if(inPlay()) {
				checkMoveValidity(row, col);
				gameBoard[row][col]=getMoverMark();
				int check = winnerCheck();
				if(check == 0 || check == 1) {
					gameEnded = true;
					gc.endGame(gamePlayers[check],gamePlayers[check == 0 ? check+1 : check-1], 1);
				}else if(check == -1) {
					gc.endGame(null, null, 0);
				}
				mover=!mover;
				moves++;
				return 0;
			}
		}
		System.out.println("Game ended.No move is legal!");
		return 1;
	}
	
	/* Changes for Lab 08 */
	public String getMoverMark() {
		return mover? "X": "O";
	}
	
	public int winnerCheck() {
		if(moves < 9) {
			if(moves >= 4) {
				//For X
				if(gameBoard[0][0] == "X" && gameBoard[0][1] == "X" && gameBoard[0][2] == "X" ) {
					System.out.println("Winner is X");
					return 0; 	//I return 0 Because of the Position used in View -> Main window.
				}
				if(gameBoard[1][0] == "X" && gameBoard[1][1] == "X" && gameBoard[1][2] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				if(gameBoard[2][0] == "X" && gameBoard[2][1] == "X" && gameBoard[2][2] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				if(gameBoard[0][0] == "X" && gameBoard[1][0] == "X" && gameBoard[2][0] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				if(gameBoard[0][1] == "X" && gameBoard[1][1] == "X" && gameBoard[2][1] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				if(gameBoard[0][2] == "X" && gameBoard[1][2] == "X" && gameBoard[2][2] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				
				if(gameBoard[0][0] == "X" && gameBoard[1][1] == "X" && gameBoard[2][2] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				if(gameBoard[0][2] == "X" && gameBoard[1][1] == "X" && gameBoard[2][0] == "X" ) {
					System.out.println("Winner is X");
					return 0;
				}
				
				// For O
				if(gameBoard[0][0] == "O" && gameBoard[0][1] == "O" && gameBoard[0][2] == "O" ) {
					System.out.println("Winner is O");
					return 1;    //I return 1 Because of the Position used in View -> Main window.
				}
				if(gameBoard[1][0] == "O" && gameBoard[1][1] == "O" && gameBoard[1][2] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
				if(gameBoard[2][0] == "O" && gameBoard[2][1] == "O" && gameBoard[2][2] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
				if(gameBoard[0][0] == "O" && gameBoard[1][0] == "O" && gameBoard[2][0] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
				if(gameBoard[0][1] == "O" && gameBoard[1][1] == "O" && gameBoard[2][1] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
				if(gameBoard[0][2] == "O" && gameBoard[1][2] == "O" && gameBoard[2][2] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
				
				if(gameBoard[0][0] == "O" && gameBoard[1][1] == "O" && gameBoard[2][2] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
				if(gameBoard[0][2] == "O" && gameBoard[1][1] == "O" && gameBoard[2][0] == "O" ) {
					System.out.println("Winner is O");
					return 1;
				}
			}
			return 666;
		}
		return -1;
	}
	
	/* Changes for Lab 08 */
	public String getPlayerStats(Player player) {
		StringBuilder sb = new StringBuilder("");
		sb.append(player.getName()).append("\n\n\n");
		sb.append("Total:").append("\t").append(player.getGames()).append("\n");
		sb.append("Won:").append("\t").append(player.findWinPerc()).append("%\n");   //CHANGE!!!!
		sb.append("Lost:").append("\t").append(player.findLosPerc()).append("%\n");
		return sb.toString();			
	}

	public GameRecord getGamesCatalogue() {
		return gamesCatalogue;
	}

	public void setGamesCatalogue(GameRecord gamesCatalogue) {
		this.gamesCatalogue = gamesCatalogue;
	}
	
	public void handleGameEnding(Player winner, Player loser, int gameType) {
		LocalDateTime timeStamp = LocalDateTime.now(); 
		if(gameType == 1) {
			winner.won();
			loser.lost();
			
			Game game = new Game(winner, loser, 1, timeStamp);
			
			winner.addGame(game);
			loser.addGame(game);
			winner.scoreCalc();
			loser.scoreCalc();
			
			this.gamesCatalogue.addGame(game);
			//counter.stop();
			//System.out.println("Game ended! It lasted: "+counter.toString());
		}else if(gameType == 0){
			winner.tie();
			loser.tie();
			
			Game game = new Game(winner, loser, 0, timeStamp);
			
			winner.addGame(game);
			loser.addGame(game);
			winner.scoreCalc();
			loser.scoreCalc();
			
			this.gamesCatalogue.addGame(game);
		}
		
	}
		
	
} 
