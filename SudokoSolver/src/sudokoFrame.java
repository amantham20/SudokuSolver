import java.awt.*;
import java.awt.geom.Line2D;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class sudokoFrame {
	sudokoPanel panel;
	int[][] board = new int[9][9];
	JFrame frame;
	int r, c;
	Color a;

	sudokoFrame() {
		frame = new JFrame("recursion");
		panel = new sudokoPanel();
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
		panel = new sudokoPanel();
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

	public void frameupdate() {

		panel.repaint();
	}

	public void sudokoset(int[][] puzzle) {
		board = puzzle;
		panel.repaint();
		frame.repaint();
		panel.revalidate();

	}

	public void colorset(int ro, int co) {
		// a = Color.blue;
		r = ro;
		c = co;
	}

	private class sudokoPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(8));

			g2.draw(new Line2D.Float(30, 175, 900, 175));
			g2.draw(new Line2D.Float(30, 320, 900, 320));

			g2.draw(new Line2D.Float(300, 20, 300, 470));
			g2.draw(new Line2D.Float(600, 20, 600, 470));

			g2.draw(new Line2D.Float(30, 20, 30, 470));
			g2.draw(new Line2D.Float(900, 20, 900, 470));
			g2.draw(new Line2D.Float(30, 20, 900, 20));
			g2.draw(new Line2D.Float(30, 470, 900, 470));

			g2.setStroke(new BasicStroke(3));

			g2.draw(new Line2D.Float(100, 20, 100, 470));
			g2.draw(new Line2D.Float(200, 20, 200, 470));

			g2.draw(new Line2D.Float(400, 20, 400, 470));
			g2.draw(new Line2D.Float(500, 20, 500, 470));

			g2.draw(new Line2D.Float(700, 20, 700, 470));
			g2.draw(new Line2D.Float(800, 20, 800, 470));

			g2.draw(new Line2D.Float(30, 67, 900, 67));
			g2.draw(new Line2D.Float(30, 123, 900, 123));

			g2.draw(new Line2D.Float(30, 220, 900, 220));
			g2.draw(new Line2D.Float(30, 270, 900, 270));

			g2.draw(new Line2D.Float(30, 370, 900, 370));
			g2.draw(new Line2D.Float(30, 420, 900, 420));

			g.setFont(g.getFont().deriveFont(18.0f));

			g.setColor(Color.blue);
			int posx = 50, posy = 50;
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {

					if (board[x][y] != 0) {
						if (Main.valid[x][y] == false)
							g.drawString("" + board[x][y], posx, posy);
						else {
							g.setColor(Color.red);
							g.drawString("" + board[x][y], posx, posy);
							g.setColor(Color.blue);
						}
					} else if (board[x][y] == 0)
						g.drawString("" + " ", posx, posy);

					/*
					 * else { g.setColor(Color.red); g.drawString("" + board[x][y], posx, posy);
					 * g.setColor(Color.blue); }
					 */

					posx += 100;

				}
				posy += 50;
				posx = 50;
			}

			if (Main.done == -1) {
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						g.setColor(Color.red);
						g.drawString("" + board[x][y], posx, posy);
						try {
							TimeUnit.MILLISECONDS.sleep(20);} catch (InterruptedException e) {}
						g.setColor(Color.yellow);
						g.drawString("" + board[x][y], posx, posy);
					}
				}

			} else if (Main.done == 1) {
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						g.setColor(Color.red);
						g.drawString("" + board[x][y], posx, posy);
						try {
							TimeUnit.MILLISECONDS.sleep(20);} catch (InterruptedException e) {}
						g.setColor(Color.yellow);
						g.drawString("" + board[x][y], posx, posy);
					}
				}

			}

		}

	}

}
