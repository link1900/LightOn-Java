package lightOn;
import java.awt.*;
public class Light extends Rect
{
    private boolean isOn;
    /**
	 * @return the isOn
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * @param isOn the isOn to set
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	private int gridX;
    private int gridY;
    
    public Light()
    {
        super();
        isOn = false;
    }
    
    public Light(int aX, int aY, int aWidth, int aHeight, boolean whatOn)
    {
        super(aX, aY,aWidth,aHeight);
        this.setGridX(aX);
        this.setGridY(aY);
        isOn = whatOn;
    }
    
    public Light(int aX, int aY, int aWidth, int aHeight, boolean whatOn,int  gridX, int gridY)
    {
        super(aX, aY,aWidth,aHeight);
        this.setGridX(gridX);
        this.setGridY(gridY);
        isOn = whatOn;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
        if (!isOn)
            g.setColor(Color.gray);
        else
            g.setColor(Color.blue);

        g.fillRect(x, y, width, height);
    }
    
    public void flick()
    {
        isOn = !isOn;
    }
    
    public void on()
    {
        isOn = true;
    }
    
    public void off()
    {
        isOn= false;
    }

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridX() {
		return gridX;
	}

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}

	public int getGridY() {
		return gridY;
	}

}
