package view;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import control.GameController;

public class HallOfFame extends GamePanel{
private GameController gc;
	
	public HallOfFame(GameController gc) {
		super(gc);
		this.gc=gc;
	}
	
	@Override
	public void paintComponent(Graphics g)   {  
	      super.paintComponent(g);
	      int x = this.getWidth()/2 - 50;
			int y = this.getHeight()/2;		
			g.drawString("Hall Of Fame", x, y);
	      
	}

}
