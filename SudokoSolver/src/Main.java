import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Main {
	
	public static int[][] puzzle;
	public static boolean[][] valid = new  boolean[9][9];
	static sudokoFrame sFrame = new sudokoFrame();
	static int p1 = 10 , times = 0;
	public static int done = 0;


	public static void main(String[] args) throws IOException, InterruptedException {
		// Create a Scanner to read one of the files
		Scanner scan = new Scanner(new File("sudoko.txt"));
		// Read the number of rows and columns
		p1  =  Integer.parseInt((String)JOptionPane.showInputDialog(
                null,
                " enter the delay "
              + " * default = 10 ms && noTEXT",
                "enter speed",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                 10));
		
		puzzle = new int[9][9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				puzzle[x][y] = scan.nextInt();
			}
		}
		
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if(puzzle[x][y] == 0) 
					 valid[x][y] = true;
				else 
					valid[x][y] = false;
			}
		}
		
		 
		
		
		
		sFrame.sudokoset(puzzle);
		sFrame.frameupdate();

		long startTime = System.nanoTime();

		boolean possible = solve();
		
		if(possible == false) {
			System.out.println("not possible");
		}
		// ... do something ...
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println(estimatedTime);
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {

				System.out.print(puzzle[y][x] + " ");
			}
			System.out.println(" ");
		}
		
		done = 1;
		sFrame.frameupdate();

		System.err.println("\n" + possible);
		System.err.println("\n" + times);

	}

	private static boolean rowcheck(int row, int n) {
		for (int i = 0; i < 9; i++) {
			if (puzzle[row][i] == n)
				return true;
		}
		return false;
	}

	private static boolean colcheck(int col, int n) {
		for (int i = 0; i < 9; i++) {
			if (puzzle[i][col] == n)
				return true;
		}
		return false;
	}

	private static boolean boxcheck(int row, int col, int n) {
		int r = row - row % 3;
		int c = col - col % 3;

		for (int x = r; x < r + 3; x++) {
			for (int y = c; y < c + 3; y++) {
				if (puzzle[x][y] == n)
					return true;
			}
		}
		return false;
	}

	private static boolean works(int row, int col, int n) {
		if (rowcheck(row, n) == true || colcheck(col, n) == true || boxcheck(row, col, n) == true) {
			// System.err.println(false + " class -- works --" + n);
			return false;
		} else
			// System.err.println(true + " class -- works --" + n + " -- row" + row + "
			// --col " + col);
			return true;
	}
	// you should quit programming you're such a bastard
	public static boolean solve() throws InterruptedException {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (puzzle[r][c] == 0) {
					for (int x = 1; x <= 9; x++) {
						if (works(r, c, x) == true) {
							puzzle[r][c] = x;
							//TimeUnit.SECONDS.sleep((long) 0.5);
							TimeUnit.MILLISECONDS.sleep(p1);
							sFrame.sudokoset(puzzle);
							times++ ; 
							//sFrame.colorset(r, c);
							TimeUnit.MILLISECONDS.sleep(p1);
							//TimeUnit.SECONDS.sleep((long) 0.5);
							if (solve() == true) {
								return true;
							} else {
								puzzle[r][c] = 0;
							}

						}

					}
					return false;

				}
			}

		}
		return true;
	}

}
