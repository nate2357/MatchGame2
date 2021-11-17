package matchGame;

import java.awt.Color;
import java.util.Objects;

public class Card
{
	private Suit cardSuite; //In case we ever need
	private Color cardColor;
	private int value; //In case we ever need
	
	private static Color[] colorArray = new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK, Color.ORANGE, Color.GRAY, Color.DARK_GRAY, Color.MAGENTA, Color.LIGHT_GRAY};

	public Card(Color cardColor)
	{
		super();
		this.cardColor = cardColor;
	}

	public Card(Color cardColor, int value)
	{
		super();
		this.cardColor = cardColor;
		this.value = value;
	}

	public Suit getCardSuite()
	{
		return cardSuite;
	}

	public Color getCardColor()
	{
		return cardColor;
	}

	public int getValue()
	{
		return value;
	}
	
	public static Color[] getColorArray()
	{
		return colorArray;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(cardColor);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(cardColor, other.cardColor);
	}

	@Override
	public String toString()
	{
		return "Card [cardColor=" + cardColor + "]";
	}

	public enum Suit
	{
		HEARTS, SPADES, CLUBS, DIAMONDS;
	}
}
