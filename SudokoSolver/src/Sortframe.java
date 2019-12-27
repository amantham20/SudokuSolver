import java.awt.*;
import java.awt.geom.Line2D;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Sortframe {

	sortPanel panel;
	int[][] board = new int[9][9];
	JFrame frame;
	int r, c;
	Color a;

	Sortframe() {
		frame = new JFrame("recursion");
		panel = new sortPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton button = new JButton();

		frame.add(panel);
		// frame.setSize(300, 300);
		// frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(panel);

		// frame = new JFrame("_____");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new sortPanel();
		panel.setPreferredSize(new Dimension(1000, 500));

		/*
		 * frame.getContentPane().add(panel);
		 * 
		 * frame.pack(); frame.setVisible(true);
		 */
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}

	private class sortPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int posx = 50, posy = 50;
			for (int x = 0; x < 100; x++) {
				int x1 = x % 10;
				g.drawString("" + "hi ", posx, posy);
				posx += 100;

			}
			
		}
	}

}
