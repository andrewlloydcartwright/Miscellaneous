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

	private JPanel top;			// Panel for the top 3 squares
	private JPanel mid;			// Panel for the middle squares
	private JPanel bot;			// Panel for the bottom squares
	private JPanel buttonPan;	// Panel for the sim button

	JLabel squares[] = new JLabel[9];

	// The constructor for the class object.
	public CartwrightAssignment06()
	{
		// The default settings for the frame.
		setTitle("Tic Tac Toe Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,3));

		createPanels();

		add(top);
		add(mid);
		add(bot);
		add(buttonPan);

		// Puts everything together and allows the frame to be visible.
		pack();
		setVisible(true);
	}

	public void createPanels()
	{
		top = new JPanel();
		mid = new JPanel();
		bot = new JPanel();
		buttonPan = new JPanel();

		for (int i = 0; i < squares.length; i++)
		{
			if(  i < 3)
				top.add(squares[i] = new JLabel("_"));
			else if ((i >= 3) && (i < 6))
				mid.add(squares[i] = new JLabel("_"));
			else
				bot.add(squares[i] = new JLabel("_"));

			squares[i].setFont(new Font("Courier", Font.BOLD, 144));
		}

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

				squares[i].setText(board[i]);
			}

			// This does a row (top, mid, bot), column (left to right), and diagonal (neg to pos slope)
			//	approach to find *the* winner in the event of multiple winners.
			// Since the array is populated in this fashion, it is the fair way to determine
			// 	which winner "first" finished.

			if 	((board[0] == board[1]) && (board[1] == board[2]))
				JOptionPane.showMessageDialog(null, "\"" + board[0] + "\" WINS!");
			else if ((board[3] == board[4]) && (board[4] == board[5]))
				JOptionPane.showMessageDialog(null, "\"" + board[3] + "\" WINS!");
			else if ((board[6] == board[7]) && (board[7] == board[8]))
				JOptionPane.showMessageDialog(null, "\"" + board[6] + "\" WINS!");
			else if ((board[0] == board[3]) && (board[3] == board[6]))
				JOptionPane.showMessageDialog(null, "\"" + board[0] + "\" WINS!");
			else if ((board[1] == board[4]) && (board[4] == board[7]))
				JOptionPane.showMessageDialog(null, "\"" + board[1] + "\" WINS!");
			else if ((board[2] == board[5]) && (board[5] == board[7]))
				JOptionPane.showMessageDialog(null, "\"" + board[2] + "\" WINS!");
			else if ((board[0] == board[4]) && (board[4] == board[8]))
				JOptionPane.showMessageDialog(null, "\"" + board[0] + "\" WINS!");
			else if ((board[6] == board[4]) && (board[4] == board[2]))
				JOptionPane.showMessageDialog(null, "\"" + board[6] + "\" WINS!");
			else
				JOptionPane.showMessageDialog(null, board[3] + "CATSCRATCH! Nobody wins!");

			pack();
		}
	}

	// Main method which creates an instance of the class.
	public static void main(String[] args)
	{
		new CartwrightAssignment06();
	}
}