package view;

	import java.awt.Color;
	import java.awt.Container;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JButton;

	public class EndingPanel {

	private JFrame endPopUp = new JFrame("Game Results");

	public EndingPanel() {
		
	endPopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	endPopUp.setBounds(200, 100, 400, 200);
	endPopUp.setBackground(Color.green);

	Container container = endPopUp.getContentPane();
	container.setLayout(null);
	container.setBackground(Color.green);

	JLabel logo = new JLabel("THE WINNER OF THIS GAME WAS:");
	logo.setBounds(100, 20, 350, 30);
	JLabel nameLabel = new JLabel("Stelios");
	nameLabel.setBounds(180, 50, 250, 30);


	JButton createPlayerBtn = new JButton("OK");
	createPlayerBtn.setBounds(150, 90, 100, 30);
	createPlayerBtn.addActionListener((e)->{endPopUp.setVisible(false);});

	container.add(logo);
	container.add(nameLabel);
	container.add(createPlayerBtn);
	endPopUp.setVisible(true);

	  }

	}
