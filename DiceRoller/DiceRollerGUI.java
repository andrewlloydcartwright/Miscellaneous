/* 	Author:		Andrew Cartwright
 *	Date:		11/3/2015
 *	Assignment:	04
 *	Objective:	Create a graphical dice roller with a roll generator that results
 *					in the display of two pseudorandom die faces.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class DiceRollerGUI extends JFrame
{
	// 	Private class-wide declarations for the frame that allow the below fields
	//		to be accessed from everywhere in the program.
	private JPanel buttonPan;
	private JPanel dicePan;
	private JLabel die1;
	private JLabel die2;
	private JButton rollButton;
	private ArrayList<ImageIcon> faces;

	// The constructor for the class object.
	public DiceRollerGUI()
	{
		// The default settings for the frame.
		setTitle("Take a chance, roll the dice!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Calls the two methods that instantiate and populate the two areas of my program.
		buildButtonPanel();
		buildDicePanel();

		// Places the button and images at the bottom and center, respectively.
		add(buttonPan, BorderLayout.SOUTH);
		add(dicePan, BorderLayout.CENTER);

		// Puts everything together and allows the frame to be visible.
		pack();
		setVisible(true);
	}

	// The method that creates the panel with the "Roll" button.
	private void buildButtonPanel()
	{
		buttonPan = new JPanel();
		rollButton = new JButton("Roll!");

		// Creates a button listener for when the "Roll" button is clicked.
		rollButton.addActionListener(new RollButtonListener());

		buttonPan.add(rollButton);
	}

	// The method that creates the center panel with the two labels for the dice images.
	private void buildDicePanel()
	{
		dicePan = new JPanel();
		die1 = new JLabel();
		die2 = new JLabel();
		dicePan.add(die1);
		dicePan.add(die2);

		// Creates and populates the ArrayList with the provided ImageIcons
		faces = new ArrayList<ImageIcon>();
		faces.add(new ImageIcon("Die1.png"));
		faces.add(new ImageIcon("Die2.png"));
		faces.add(new ImageIcon("Die3.png"));
		faces.add(new ImageIcon("Die4.png"));
		faces.add(new ImageIcon("Die5.png"));
		faces.add(new ImageIcon("Die6.png"));
	}

	private class RollButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// A new random object is generated at each press of the button, instead of being
			//	instantiated at the beginning of the class, for better pseudorandomness.
			Random rand = new Random();
			int r1 = rand.nextInt(6);
			int r2 = rand.nextInt(6);

			die1.setIcon(faces.get(r1));
			die2.setIcon(faces.get(r2));

			// Repacks the frame so the panel both fits and shows the new dice faces.
			pack();
		}
	}

	// Main method which creates an instance of the class.
	public static void main(String[] args)
	{
		new DiceRollerGUI();
	}
}