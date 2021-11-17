package matchGame;

import java.util.ArrayList;
import java.util.List;

public class GameLogic
{

	protected List<Integer> selectedButtons;
	protected List<Integer> matchedButtons;

	public GameLogic()
	{
		super();
		selectedButtons = new ArrayList<>();
		matchedButtons = new ArrayList<>();

	}

	public void setSelectedButtons(int passedButton)
	{
		selectedButtons.add(passedButton);
	}

	public int[] matchingLogic()
	{
		int buttonCompare1;
		int buttonCompare2;

		int wrong[] = { -1, -1 }; //-1 means the program will not flip the button/card back (or make it white). [-1,-1] means don't touch the last two cards.
		if (selectedButtons.size() == 3)
		{
			buttonCompare1 = selectedButtons.get(0);
			buttonCompare2 = selectedButtons.get(1);
			if (Controller.getTable().getDeck().get(buttonCompare1).getCardColor() != Controller.getTable().getDeck()
					.get(buttonCompare2).getCardColor())
			{
				wrong[0] = selectedButtons.get(0);
				wrong[1] = selectedButtons.get(1);
			}

			else
			{
				matchedButtons.add(selectedButtons.get(0));
				matchedButtons.add(selectedButtons.get(1));
			}

		}
		if (selectedButtons.size() > 3)
			if ((selectedButtons.size() + 1) % 2 == 0)
			{
				buttonCompare1 = selectedButtons.get(selectedButtons.size() - 3);
				buttonCompare2 = selectedButtons.get(selectedButtons.size() - 2);

				if (Controller.getTable().getDeck().get(buttonCompare1).getCardColor() != Controller.getTable().getDeck()
						.get(buttonCompare2).getCardColor())

				{
					wrong[0] = selectedButtons.get(selectedButtons.size() - 3);
					wrong[1] = selectedButtons.get(selectedButtons.size() - 2);

				}

				else
				{
					matchedButtons.add(selectedButtons.get(selectedButtons.size() - 3));
					matchedButtons.add(selectedButtons.get(selectedButtons.size() - 2));
				}
				
				for (int i = 0; i < matchedButtons.size(); i++)
				{
					if (wrong[0] == matchedButtons.get(i))
					{
						wrong[0] = -1;
					}
					if (wrong[1] == matchedButtons.get(i))
					{
						wrong[1] = -1;
					}
				}

			}

		return wrong; // if last two selected buttons/cards match, will return [-1,-1]. Otherwise it
						// will return the cards that need to be flipped back
	}

}
