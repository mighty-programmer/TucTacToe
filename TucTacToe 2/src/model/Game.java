package model;

import java.time.LocalDateTime;



public class Game implements Comparable <Game>{
private Player[] players;
private Player winner = null;
private Player loser =  null;
private Boolean wasTie = false;
private float[] score;
private LocalDateTime timeStamp;
private long timeElapsed;

public Game(Player winner, Player loser, int gameType, LocalDateTime timeStamp){
	this.players = new Player[2];
	
		players[0] = winner;
		players[1] = loser;
		this.score = new float[2];
		score[0] = winner.getScore();
		score[1] = loser.getScore();
		this.timeStamp = timeStamp;
		
		if(gameType == 1){
			
			this.winner = winner;
			this.loser = loser;
		}
		
		if(gameType == 0){
			this.wasTie = true;
		}
}

public Player getWinner() {
	return winner;
}

public void setWinner(Player winner) {
	this.winner = winner;
}

public Player[] getPlayers() {
	return players;
}

public void setPlayers(Player[] players) {
	this.players = players;
}

public float[] getScore() {
	return score;
}

public void setScore(float[] score) {
	this.score = score;
}

public long getTimeElapsed() {
	return timeElapsed;
}

public void setTimeElapsed(long timeElapsed) {
	this.timeElapsed = timeElapsed;
}

public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}

public Player getLoser() {
	return loser;
}

public void setLoser(Player loser) {
	this.loser = loser;
}

public Boolean getWasTie() {
	return wasTie;
}

public void setWasTie(Boolean wasTie) {
	this.wasTie = wasTie;
}



@Override
public int compareTo(Game anotherGame) {
	
	if(this.getTimeStamp().isBefore(anotherGame.getTimeStamp())) {
		return 1;
	} else if (this.getTimeStamp().isAfter(anotherGame.getTimeStamp())) {
		return -1;
	} else {
		return 0;

	}
}

public int bestMatch(Game anotherGame, Player player) {
	if(this.getWinner().equals(player)) {
		if(anotherGame.getWinner().equals(player)) {
			if(this.getWinner().getScore() < this.getLoser().getScore() && anotherGame.getWinner().getScore() > anotherGame.getLoser().getScore()) {
				return 1;
			}else if(this.getWinner().getScore() > this.getLoser().getScore() && anotherGame.getWinner().getScore() < anotherGame.getLoser().getScore()) {
				return -1;
			}else if(this.getWinner().getScore() == this.getLoser().getScore() || this.getWinner().getScore() < this.getLoser().getScore() && anotherGame.getWinner().getScore() < anotherGame.getLoser().getScore() || this.getWinner().getScore() > this.getLoser().getScore() && anotherGame.getWinner().getScore() > anotherGame.getLoser().getScore()) {
				if(this.getTimeStamp().isAfter(anotherGame.getTimeStamp())){
					return -1;
				}else if(this.getTimeStamp().isBefore(anotherGame.getTimeStamp())) {
					return 1;
				}else if(this.getTimeStamp().isEqual(anotherGame.getTimeStamp())) {
					return 0;
				}
			}
		}else {
			return -1;
		}
	}/*else if(this.getWasTie()) {
		if(anotherGame.wasTie) {
			if(this.getLoser().getScore() > anotherGame.getLoser().getScore()) {
				return -1;
			}else if(this.getLoser().getScore() < anotherGame.getLoser().getScore()) {
				return 1;
			}else if(this.getLoser().getScore() == anotherGame.getLoser().getScore()) {
				if(this.getTimeStamp().isAfter(anotherGame.getTimeStamp())){
					return -1;
				}else if(this.getTimeStamp().isBefore(anotherGame.getTimeStamp())) {
					return 1;
				}else if(this.getTimeStamp().isEqual(anotherGame.getTimeStamp())) {
					return 0;
				}
			}
		}else {
			return 0;
		}
	}*/else if(this.getLoser().equals(player)) {
		if(anotherGame.getLoser().equals(player)) {
			if(this.getLoser().getScore() > anotherGame.getWinner().getScore()) {
				return 1;
			}else if(this.getLoser().getScore() < anotherGame.getWinner().getScore()) {
				return -1;
			}else if(this.getLoser().getScore() == anotherGame.getWinner().getScore()) {
				if(this.getTimeStamp().isAfter(anotherGame.getTimeStamp())){
					return -1;
				}else if(this.getTimeStamp().isBefore(anotherGame.getTimeStamp())) {
					return 1;
				}else if(this.getTimeStamp().isEqual(anotherGame.getTimeStamp())) {
					return 0;
				}
			}
		}else {
			return 1;
		}
	}
	 return -999;
  }
}

