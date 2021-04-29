package view;


import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.PlayerRoster;
import control.GameController;
import model.Player;

public class PlayerPanel extends GamePanel{
	
	JButton selectPlayerBtn;
	int pos;
	String currentPlayer;
	JTextField plName;
	JLabel plMark;
	JTextArea plStats;
	
	
	public PlayerPanel(GameController c, int pos) {
		super(c);
		this.pos=pos;		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT-MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.YELLOW,1,true));
		this.setAlignmentX(CENTER_ALIGNMENT);
		selectPlayerBtn = new JButton("Choose Player");
		selectPlayerBtn.setPreferredSize(new Dimension(150,40));
		selectPlayerBtn.setAlignmentX(CENTER_ALIGNMENT);
		selectPlayerBtn.addActionListener((e)->{changePlayer();});
		this.add(selectPlayerBtn);
		
		plName = new JTextField();
		plName.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,40));
		plName.setMaximumSize(plName.getPreferredSize() );
		plName.setAlignmentX(CENTER_ALIGNMENT);
		plName.setHorizontalAlignment(JTextField.CENTER);
		plName.setEnabled(false);
		
		/* Changes for Lab 08: Player Mark */
		plMark = new JLabel(pos==0? "X" : "O");
		plMark.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,80));
		plMark.setAlignmentX(CENTER_ALIGNMENT);
		plMark.setHorizontalAlignment(JTextField.CENTER);
		plMark.setEnabled(false);
		Font markf = new Font("SansSerif", Font.BOLD,90);
		plMark.setFont(markf);
		
		/* Changes for Lab 08: Player Stats JTextArea */
		plStats = new JTextArea(10,100);		
		plStats.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,400));
		plStats.setAlignmentX(CENTER_ALIGNMENT);
		Font statsf = new Font("SansSerif", Font.BOLD,20);
		plStats.setFont(statsf);
		plStats.setEnabled(false);		
		plStats.setMargin(new Insets(10, 10, 10, 10));
		this.add(plMark);
		this.add(plName);		
		this.add(plStats);
	}

	public void changePlayer() {
		//Get the list of all players
		PlayerRoster finder = new PlayerRoster(); 
		
		List<String> allPlayers = new ArrayList<String>();
		allPlayers = gc.getModel().getPlayerCatalogue().findPlayerNames();
		
		String [] playerNames = new String[allPlayers.size()];
		allPlayers.toArray(playerNames);
				
		//Show Player Selection Dialog
		String selPlayer = (String) JOptionPane.showInputDialog(this, 
				"Choose a Player...",
				"Player selection",
				JOptionPane.PLAIN_MESSAGE,
				null,
				playerNames,
				null
				);
		
		//Set the selected player		
		if(selPlayer != null) {
			if(gc.getModel().getGamePlayers()[pos==0?1:0] != null) {
				if (selPlayer.equals(gc.getModel().getGamePlayers()[pos==0?1:0].getName())) {
					JOptionPane.showMessageDialog(gc.getView(), 						
						"Player already selected",
						"Idiot",
						JOptionPane.ERROR_MESSAGE);
					    return;
			   }	
			}
			this.currentPlayer= selPlayer;			
			gc.selectPlayer(finder.findPlayer(selPlayer), pos);
			this.plName.setText(currentPlayer);
			this.setPlayerStats(gc.getModel().getPlayerStats(finder.findPlayer(selPlayer))); //Must enable.Disabled because players have no stats.
			this.repaint();
		}
	}	

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public JTextField getPlName() {
		return plName;
	}
	
	public JTextArea getPlStats() {
		return plStats;
	}
	
	public void setPlayerStats(String stats) {
		this.plStats.setText(stats);
	}

	public JButton getSelectPlayerBtn() {
		return selectPlayerBtn;
	}

	
	
}
