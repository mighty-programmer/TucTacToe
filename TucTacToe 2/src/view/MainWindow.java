package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import control.GameController;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	static public final int WIDTH = 1200;
	static public final int HEIGHT = 800;
	static public final int TOP_HEIGHT = 80;
	static public final int PLAYER_WIDTH = 300;
	
	private PlayerPanel leftPanel;
	private PlayerPanel rightPanel;
	private TopPanel topPanel;
	private MainAreaPanel mainPanel;
	private GameController gc;
	
	
	public MainWindow(GameController gc) {
		super("TUC-TAC-TOE");
		this.gc=gc;
		Container c = this.getContentPane();		
		c.setPreferredSize(new Dimension(WIDTH, HEIGHT));		
		
		topPanel = new TopPanel(this.gc);		
				
		this.add(topPanel,BorderLayout.PAGE_START);
		
		leftPanel = new PlayerPanel(gc,0);  	// Position 0 is X
		this.add(leftPanel,BorderLayout.LINE_START);
		
		rightPanel = new PlayerPanel(gc, 1);    //Position 1 is O
		this.add(rightPanel,BorderLayout.LINE_END);

		mainPanel = new MainAreaPanel(this.gc);
		this.add(mainPanel,BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.pack();			
	}

	public PlayerPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(PlayerPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public PlayerPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(PlayerPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public TopPanel getTopPanel() {
		return topPanel;
	}

	public void setTopPanel(TopPanel topPanel) {
		this.topPanel = topPanel;
	}	
		
	public MainAreaPanel getMainPanel() {
		return mainPanel;
	}
		
}
