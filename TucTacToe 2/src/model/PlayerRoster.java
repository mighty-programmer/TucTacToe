package model;

import java.util.*;

public class PlayerRoster {
	
	public ChartList<Player> players;
	
	public PlayerRoster() {
		players = new ChartList <Player>(1);
		players.addExtend(new Player("Stelios"));
		players.addExtend(new Player("John"));
		players.addExtend(new Player("Sofia"));
		players.addExtend(new Player("Dimitra"));
		players.addExtend(new Player("Giorgos"));
		players.addExtend(new Player("Nikos"));
		players.addExtend(new Player("Nikoleta"));
		players.addExtend(new Player("Antonia"));
		players.addExtend(new Player("Orestis"));
		players.addExtend(new Player("Anastasia"));
		players.addExtend(new Player("Kostas"));
		players.addExtend(new Player("Xrusoula"));
	}
	
	
	
	public ChartList<Player> getPlayer(int i) {
		if (i<0 || i>4) {
			return null;
		}
		return (players);
	}
	
	
	public ChartList<Player> getPlayers() {
		return (players);
	}
	
	
	public List<String> findPlayerNames(){
		List<String> playerNames = new ArrayList<String>();
		
		for(int i=0; i<players.size(); i++){
			if(players.get(i)!=null){
				playerNames.add(players.get(i).getName());
			}
		}
		return (playerNames);
	} 
	
	
	public Player findPlayer(String name) {
		
		for(int i=0; i<players.size();i++) {
			if(players.get(i).getName().equals(name)) {
				System.out.println("Player found");
				return players.get(i);
			}
	    }		
		 System.out.println("There is no-one that matches with the name: " + name);
		
		return null;
     }
	
	
	
	public Player[] findHallOfFame(int n) {
		Player bestPlayers[] = new Player[10];
		for(int i=0;i<10;i++){
			bestPlayers [i] = players.get(i);
		}
		return bestPlayers;
 }
	

}




















