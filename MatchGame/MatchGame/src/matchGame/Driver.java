package matchGame;

import java.awt.EventQueue;

public class Driver
{
	protected static Controller myController;

	public static void main(String[] args)
	{

		Controller.startGame(3); //3 is difficulty

		// Launch the application (GameFrame).
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

	}

}
