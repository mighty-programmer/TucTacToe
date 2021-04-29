package model;


import java.io.*;

public class GameRecord implements Serializable{
	ChartList<Game> allGames = new ChartList<Game>(1);
	
	
	public GameRecord(){
	}


	public ChartList<Game> getAllGames() {
		return allGames;
	}

	public void addGame(Game game) {
		allGames.addExtend(game);
		System.out.println("Game saved");
	}
}
