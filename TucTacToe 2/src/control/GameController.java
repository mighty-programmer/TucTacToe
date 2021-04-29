package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

import model.Player;
import model.GameModel;
import model.PlayerRoster;
import view.MainAreaPanel;
import view.MainWindow;

public class GameController extends WindowAdapter {
	public static StopWatch counter = new StopWatch();
	MainWindow view;
	GameModel model;
	
	public GameController() {		
		
	}
	
	@Override
	public void windowClosing(WindowEvent event) {
		quit();
	}

	
	public void start() {
		this.view = new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.view.setVisible(true);
	}
	
	public void quit() {	
		counter.stop();
		System.out.println("Bye Bye..." + counter.toString());		
		System.exit(0);
		
	}
	
	public void quitWindow() {
		System.out.println("New game started!");
		view.dispose();
		counter.stop();
		counter.start();
	}
	
	public void selectPlayer(Player p, int pos) {
		this.model.selectPlayer(p, pos);	
		System.out.println("Player " + pos + " set to " + p.getName());
		this.view.getTopPanel().getStartBtn().setEnabled(model.ready());		
	}
	
	public void startGame() {
		counter.start();
		this.model.setGameBoard(new String[3][3]);
		this.view.getTopPanel().getStartBtn().setEnabled(false);
		this.view.getMainPanel().showCard(MainAreaPanel.BOARD);
		this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
		this.view.getRightPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
	}
	
	public void endGame(Player winner, Player loser, int gameType) {
		if(gameType == 1) {
			model.handleGameEnding(winner, loser, gameType); //Not tie.
		}else if(gameType == 0) {
			model.handleGameEnding(winner, loser, gameType);	//Tie.
		}
		
		
	}
	
	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}
			
	
}
