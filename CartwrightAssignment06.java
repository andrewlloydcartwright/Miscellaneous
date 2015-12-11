/* 	Author:		Andrew Cartwright
 *	Date:		12/10/2015
 *	Assignment:	06
 *	Objective:	Create a GUI-based tic tac toe simulator.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CartwrightAssignment06 extends JFrame
{
	// 	Classwide private fields for all the JFrame components
	private JButton sim;

	private JPanel topPan;		// Panel for the top row
	private JPanel midPan;		// Panel for the middle row
	private JPanel botPan;		// Panel for the bottom row
	private JPanel buttonPan;	// Panel for the sim button

	private JLabel sq1;
	private JLabel sq2;
	private JLabel sq3;
	private JLabel sq4;
	private JLabel sq5;
	private JLabel sq6;
	private JLabel sq7;
	private JLabel sq8;
	private JLabel sq9;

	// The constructor for the class object.
	public CartwrightAssignment06()
	{
		// The default settings for the frame.
		setTitle("Tic Tac Toe Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,3));

		createPanels();

		add(topPan);
		add(midPan);
		add(botPan);
		add(buttonPan);

		// Puts everything together and allows the frame to be visible.
		pack();
		setVisible(true);
	}

	public void createPanels()
	{
		topPan = new JPanel();
		midPan = new JPanel();
		botPan = new JPanel();
		buttonPan = new JPanel();

		topPan.add(sq1 = new JLabel("_"));
		topPan.add(sq2 = new JLabel("_"));
		topPan.add(sq3 = new JLabel("_"));
		midPan.add(sq4 = new JLabel("_"));
		midPan.add(sq5 = new JLabel("_"));
		midPan.add(sq6 = new JLabel("_"));
		botPan.add(sq7 = new JLabel("_"));
		botPan.add(sq8 = new JLabel("_"));
		botPan.add(sq9 = new JLabel("_"));

		sim = new JButton("Simulate game.");
		sim.addActionListener(new SimulationListener());
		buttonPan.add(sim);
	}

	// Private inner class for the simulate button's ActionListener.
	private class SimulationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String board[] = new String[9];
			Random rand = new Random();

			for (int i = 0; i < board.length; i++)
			{
				int spot = rand.nextInt(2);

				if (spot == 0)
					board[i] = "X";
				else
					board[i] = "O";

				System.out.print(board[i] + " ");

				if ((i+1) % 3 == 0)
					System.out.println();

			}

			System.out.println();

			// To be removed later
			// garbageModule();


			// Repacks the frame so the panel both fits and shows the new dice faces.
			pack();
		}
	}

	// Main method which creates an instance of the class.
	public static void main(String[] args)
	{
		new CartwrightAssignment06();
	}
}


/*
public void garbageModule()
	{
		Random rand = new Random();

		int r1 = rand.nextInt(2);
		int r2 = rand.nextInt(2);
		int r3 = rand.nextInt(2);
		int r4 = rand.nextInt(2);
		int r5 = rand.nextInt(2);
		int r6 = rand.nextInt(2);
		int r7 = rand.nextInt(2);
		int r8 = rand.nextInt(2);
		int r9 = rand.nextInt(2);

		if (r1 == 0)
			sq1.setText("X");
		else
			sq1.setText("O");

		if (r2 == 0)
			sq2.setText("X");
		else
			sq2.setText("O");

		if (r3 == 0)
			sq3.setText("X");
		else
			sq3.setText("O");

		if (r4 == 0)
			sq4.setText("X");
		else
			sq4.setText("O");

		if (r5 == 0)
			sq5.setText("X");
		else
			sq5.setText("O");

		if (r6 == 0)
			sq6.setText("X");
		else
			sq6.setText("O");

		if (r7 == 0)
			sq7.setText("X");
		else
			sq7.setText("O");

		if (r8 == 0)
			sq8.setText("X");
		else
			sq8.setText("O");

		if (r9 == 0)
			sq9.setText("X");
		else
			sq9.setText("O");
	}
*/

