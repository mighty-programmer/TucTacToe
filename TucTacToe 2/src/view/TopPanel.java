package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.GameController;

public class TopPanel extends GamePanel{	
	JButton quitBtn;
	JButton startGameBtn;
	JButton doneBtn;
	JButton createPlayerBtn;
	JButton newGameBtn;
	
	public TopPanel(GameController gc) {
		super(gc);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.RED,1,true));
		quitBtn = new JButton("Quit App");	
		quitBtn.setPreferredSize(new Dimension(100, 40));
		quitBtn.addActionListener((e)->{this.gc.quit();});		
		
		startGameBtn = new JButton("Start Game");
		startGameBtn.setPreferredSize(new Dimension(100, 40));
		startGameBtn.setEnabled(false);
		startGameBtn.addActionListener((e)->{this.gc.startGame();});
		
		doneBtn = new JButton("Done");		
		doneBtn.setPreferredSize(new Dimension(100, 40));		
		doneBtn.setEnabled(false);
		doneBtn.addActionListener((e)->{System.out.println("done pressed");});
		
		createPlayerBtn = new JButton("Create Player");
		createPlayerBtn.setPreferredSize(new Dimension(100, 40));
		createPlayerBtn.addActionListener((e)->{new CreatePlayerPanel();});
		
		newGameBtn = new JButton("New Game");
		newGameBtn.setPreferredSize(new Dimension(100, 40));
		newGameBtn.addActionListener((e)->{this.gc.quitWindow(); GameController gcNew = new GameController(); gcNew.start();});
	
		add(createPlayerBtn);
		add(startGameBtn);
		add(doneBtn);
		add(newGameBtn);
		add(quitBtn);	
	}

	public JButton getQuitBtn() {
		return quitBtn;
	}

	public JButton getStartBtn() {
		return startGameBtn;
	}
	

	public JButton getDoneBtn() {
		return doneBtn;
	}	
	
	public JButton getCreatePlayerBtn() {
		return createPlayerBtn;
	}
}
