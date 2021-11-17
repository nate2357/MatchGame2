package matchGame;

import java.awt.Color;

import javax.swing.JButton;

public class GameButton extends JButton
{
	private Color realColor;

	public GameButton()
	{
		super();
		this.realColor = Color.WHITE; // default

	}

	public Color getRealColor()
	{
		return realColor;
	}

	public void setRealColor(Color realColor)
	{
		this.realColor = realColor;
	}

}
