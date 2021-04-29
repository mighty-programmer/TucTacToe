package view;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Player;
import model.PlayerRoster;
import javax.swing.JButton;

public class CreatePlayerPanel {

private PlayerRoster playersCat;

private JFrame popUp = new JFrame("Create your new player");

public CreatePlayerPanel() {
	
popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
popUp.setBounds(200, 100, 400, 200);
popUp.setBackground(Color.cyan);

Container container = popUp.getContentPane();
container.setLayout(null);
container.setBackground(Color.cyan);

JLabel logo = new JLabel("ENTER THE NAME OF THE NEW PLAYER BELOW");
logo.setBounds(60, 5, 350, 30);
JLabel nameLabel = new JLabel("Name:");
nameLabel.setBounds(30, 50, 250, 30);

JTextField textForm = new JTextField();
textForm.setBounds(80, 50, 250, 30);

JButton createPlayerBtn = new JButton("Create");
createPlayerBtn.setBounds(150, 90, 100, 30);
createPlayerBtn.addActionListener((e)->{playersCat.players.addExtend(new Player(textForm.getText())); popUp.setVisible(false);});

container.add(logo);
container.add(nameLabel);
container.add(textForm);
container.add(createPlayerBtn);
popUp.setVisible(true);

  }

}
