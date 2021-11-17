package matchGame;

public class Controller
{

	/*
	 * Don't go higher than difficulty 7 (I couldn't think of enough colors). This
	 * directly impacts the number of cards on the table
	 */
	protected static Player myPlayer;
	protected static Table myTable;
	protected static GameLogic myLogic;

	public static void startGame(int difficulty)
	{
		myPlayer = new Player("Bob");
		myTable = new Table(difficulty);
		myLogic = new GameLogic();

	}

	static public Table getTable()
	{
		return myTable;

	}

	static public GameLogic getLogic()
	{
		return myLogic;
	}

	static public Player getPlayer()
	{
		return myPlayer;
	}

}
