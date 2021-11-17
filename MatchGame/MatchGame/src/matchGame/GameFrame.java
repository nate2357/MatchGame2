package matchGame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class GameFrame extends JFrame
{

	private JPanel contentPane;
	List<GameButton> buttonList = new ArrayList<>();
	double buttonNumber = ((Controller.getTable()).getDeck()).size();
	int elapsedTime = 0;
	int gameTime = Controller.myTable.getDifficulty() * 15;
	JLabel timerLabel;
	boolean victory;

	/**
	 * Create the frame.
	 */
	public GameFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelTable = new JPanel();
		contentPane.add(panelTable, BorderLayout.CENTER);

		// This set of code determines the appropriate height and width for the grid
		// layout based on the number of cards
		double dimension = Math.sqrt(buttonNumber);
		dimension = Math.ceil(dimension);
		panelTable.setLayout(new GridLayout((int) dimension, (int) dimension, 0, 0));

		// Creating all buttons (cards) and adding them to the panel
		for (int i = 0; i < buttonNumber; i++)
		{
			buttonList.add(newButton());
			(buttonList.get(i)).setRealColor(((Controller.getTable().getDeck()).get(i)).getCardColor());
			panelTable.add(buttonList.get(i));
		}

		JPanel panel_top = new JPanel();
		contentPane.add(panel_top, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Ready to Match!");
		panel_top.add(lblNewLabel);

		JPanel panel_bottom = newBottomPanel();
		contentPane.add(panel_bottom, BorderLayout.SOUTH);

		timerLabel = new JLabel();
		timerLabel.setText("Time Left: " + gameTime);
		panel_bottom.add(timerLabel);
	}

	private JPanel newBottomPanel()
	{
		JPanel panel_bottom = new JPanel();

		ActionListener al = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				elapsedTime++;
				timerLabel.setText("Time Left: " + (gameTime - elapsedTime));
				if (elapsedTime >= gameTime)
				{
					timerLabel.setText("Ran out of time");

				}
				victory = true;
				for (int i = 0; i < buttonList.size(); i++)
				{
					if (buttonList.get(i).getBackground() == Color.WHITE)
					{
						victory = false;
					}
				}
				if (victory == true)
				{
					timerLabel.setText("You won!");
				}
			}
		};
		Timer timer = new Timer(1000, al);// create the timer which calls the actionperformed method for every second
		timer.start();// start the task

		return panel_bottom;
	}

	private GameButton newButton()
	{
		GameButton btnNewButton = new GameButton();
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if ((gameTime - elapsedTime) > 0)
				{
					for (int i = 0; i < buttonList.size(); i++)
					{
						if (buttonList.get(i) == e.getSource())
						{
							Controller.getLogic().setSelectedButtons(i);
						}
					}
					if ((Controller.getLogic().matchingLogic()[0]) != -1)
					{
						buttonList.get(Controller.getLogic().matchingLogic()[0]).setBackground(Color.WHITE);
					}

					if ((Controller.getLogic().matchingLogic()[1]) != -1)
					{
						buttonList.get(Controller.getLogic().matchingLogic()[1]).setBackground(Color.WHITE);
					}
					btnNewButton.setBackground(btnNewButton.getRealColor());

				}
			}
		});
		return btnNewButton;
	}

	public List<GameButton> getButtonList()
	{
		return buttonList;
	}

}
