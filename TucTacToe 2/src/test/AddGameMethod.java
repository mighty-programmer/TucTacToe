package test;

import java.time.*;
import control.*;
import model.*;
import app.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddGameMethod {
	LocalDateTime timeStamp;
	GameController gc;
	GameModel model ;
	
	@BeforeEach
	void SetUp() {	
	    gc = new GameController();
	    model  = new GameModel(gc);
	}

	
	@Test
	@DisplayName ("Testing handleGameEndign method.")
	void testingHandleGameEnding() {
		Player player1 = new Player("john");
		Player player2 = new Player("stelios");
		
        model.handleGameEnding(player1, player2, 1);
        model.handleGameEnding(player2, player1, 1);
        model.handleGameEnding(player1, player2, 1);
        model.handleGameEnding(player1, player2, 1);
        model.handleGameEnding(player1, player2, 1);
        model.handleGameEnding(player2, player1, 1);
        
		
		assertAll("Testing BestGames list",
				()->assertEquals(player1.getBestGames().get(0).getWinner().getName(), "john","Should be john"),
				()->assertEquals(player2.getBestGames().get(0).getWinner().getName(), "stelios","Should be stelios "),
				()->assertEquals(player2.getRecentGames().get(0).getWinner().getName(),"stelios","Should be stelios")
				);
	}
	
	@Disabled
	@DisplayName ("Testing bestGame list")
	void  testingBestGameList() {
		LocalDateTime timeStamp = LocalDateTime.now();
		
		Player player1 = new Player("john");
		Player player2 = new Player("stelios");
		
		Game game0 = new Game(player1, player2, 1, timeStamp);
		Game game1 = new Game(player1, player2, 1, timeStamp.plusDays(1));
		Game game2 = new Game(player2, player1, 1, timeStamp.plusDays(2));
		Game game3 = new Game(player1, player2, 1, timeStamp.plusDays(3));
		Game game4 = new Game(player2, player1, 1, timeStamp.plusDays(4));
				
		player1.addGame(game0);
		player1.won();
		player1.scoreCalc();
		player1.addGame(game1);
		player1.won();
		player1.scoreCalc();
		player1.lost();
		player1.addGame(game2);
		player1.lost();
		player1.scoreCalc();
		player1.addGame(game3);
		player1.won();
		player1.scoreCalc();
		player1.addGame(game4);
		player1.lost();
		player1.scoreCalc();
		
		player2.addGame(game0);
		player2.lost();
		player2.scoreCalc();
		player2.addGame(game1);
		player2.lost();
		player2.scoreCalc();
		player2.addGame(game2);
		player2.won();
		player2.scoreCalc();
		player2.addGame(game3);
		player2.lost();
		player2.scoreCalc();
		player2.addGame(game4);
		player2.won();
		player2.scoreCalc();
		
		assertAll("Testing bestGame list",
				()->assertEquals(player1.getBestGames().get(0), game3, "Should be game 3"),
				()->assertEquals(player1.getBestGames().get(1), game2, "Not sure"),
				()->assertEquals(player2.getBestGames().get(0), game4, "Should be game 3")
				);
		
		
	}
}
