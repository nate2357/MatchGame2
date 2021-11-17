package matchGame;

public class Player
{
	private String playerName;
	private int score;

	/**
	 * This is the Constructor for the Player
	 * 
	 * @param playerName - Name of player
	 */

	public Player(String playerName)
	{
		super();
		this.playerName = playerName;
		score = 0;
	}

	/**
	 * This is the constructor for Player with default values
	 */
	public Player()
	{
		super();
		playerName = "Default Player";
		score = 0;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

}
