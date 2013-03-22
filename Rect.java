package lightOn;
/**
 * By Scott Brown
 * ID 19877366
 */
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class Rect
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    
    public Rect()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }
    
    public Rect(int aX, int aY, int aWidth, int aHeight)
    {
        x = aX;
        y = aY;
        width = aWidth;
        height = aHeight;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setX(int aX)
    {
        x = aX;
    }
    
    public void setY(int aY)
    {
        y = aY;
    }
    
    public void setWidth(int aWidth)
    {
        width = aWidth;
    }
    
    public void setHeight(int aHeight)
    {
        height = aHeight;
    }
    
    public boolean contains(Point aPoint)
    {
        return new Rectangle(x,y,width,height).contains(aPoint);
    }
    
//     public void draw(Graphics g)
//     {
//         g.fillRect(x,y,width,height);
//     }
    
    public void setLocation(Point p)
    {
        x = p.x;
        y = p.y;
    }
    
    public void setLocation(int newX, int newY)
    {
        x = newX;
        y = newY;
    }
    
    public void setSize(int newWidth, int newHeight)
    {
        width = newWidth;
        height = newHeight;
    }
    
    public void setSize(Dimension newDim)
    {
        width = newDim.width;
        height = newDim.height;
    }
    
    public void setRect(int newX, int newY, int newWidth, int newHeight)
    {
        x = newX;
        y = newY;
        width = newWidth;
        height = newHeight;
    }
}
