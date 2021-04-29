package model;

import java.util.Objects;

public class Player implements Comparable<Player>{
	private String name;
	private int games; 
	private int wins; 
	private int losses ;
	private int ties;
	private float score;
	
	private ChartList<Game> gamesList;
	private ChartList<Game> recentGames;
	private ChartList<Game> bestGames;
	
	public Player(String name){   
		this.games = 0; 
		this.wins = 0; 
		this.losses = 0; 
		this.score = 0; 
		this.ties = 0;
		this.gamesList = new ChartList<Game>(1);
		this.recentGames = new ChartList<Game>(5);						//Has to only be 5 ! Do not use addExtend ONLY ADD!!
		this.bestGames = new ChartList<Game>(5); 						//We have to make a new list!!!
		this.name = name;
	}
	
	public void scoreCalc(){
		
		if(games == 0) {  			//Avoid arithmetic exception.
			this.score = 0;
		}else {
			float calc = (wins * games);
			score = ((2 * wins + ties) / games) * 50;
		}
		
	}
	
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public ChartList<Game> getRecentGames() {
		return recentGames;
	}

	public void setRecentGames(ChartList<Game> recentGames) {
		this.recentGames = recentGames;
	}

	public ChartList<Game> getBestGames() {
		return bestGames;
	}

	public void setBestGames(ChartList<Game> bestGames) {
		this.bestGames = bestGames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}
	
	public int findWinPerc() {
		if (games == 0) {
			return 0;
		}else {
			return (wins * 100)/games;
		}
	}
	
	public int findLosPerc() {
		if(games == 0) {
			return 0;
		}else {
			return (losses * 100)/games;
		}
	}
	
	
	public void addGame(Game game) {
		this.gamesList.addExtend(game);
		this.recentGames.add(game);
		this.bestGames.addGame(game, this);   
	}
	
	public void won() {
		games++;
		wins++;
	}
	public void lost() {
		games++;
		losses++;
	}
	
	public void tie() {
		games++;
		ties++;
	}
	
	
	@Override
	public int compareTo(Player anotherPlayer) {
		
    if(this.getScore() > anotherPlayer.getScore()) {
        return -1;
    } else if (this.getScore() < anotherPlayer.getScore()) {
        return 1;
    } else {
        return 0;
    
    	}
	}
}	
