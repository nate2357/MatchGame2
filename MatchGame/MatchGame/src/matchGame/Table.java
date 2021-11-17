package matchGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table
{

	private int cardNumber;
	private List<Card> deck = new ArrayList<>();
	private int difficulty;

	public Table(int difficulty)
	{
		super();
		this.difficulty = difficulty;
		cardNumber = difficulty * 2 + 8;

		for (int i = 0; i < cardNumber / 2; i++)
		{
			deck.add(new Card(Card.getColorArray()[i]));
			deck.add(new Card(Card.getColorArray()[i]));

		}

		Collections.shuffle(deck);

	}

	public int getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
	}

	public int getCardNumber()
	{
		return cardNumber;
	}

	public List<Card> getDeck()
	{
		return deck;
	}

}
