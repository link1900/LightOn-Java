package lightOn;
import java.awt.*;
import java.util.*;

public class Grid
{
    private HashSet<Point> points;
    
    public Grid()
    {
        points = new HashSet<Point>();
    }
    
    public Grid(int width, int height, int spacing)
    {
        points = new HashSet<Point>();
        fillPoints(width, height, spacing);
    }
    
    public HashSet<Point> getPoints()
    {
        return points;
    }
    
    public void fillPoints(int width, int height, int spacing)
    {
        for (int y=0; y < height; y++)
        {
            for (int x=0; x < width; x++)
            {
                points.add(new Point(x*spacing,y*spacing));
            }
        }
    }
    
//    public static HashSet<Point> makeGrid(int width, int height, int spacing)
//    {
//        HashSet<Point> points = new HashSet<Point>();
//        for (int y=0; y < height; y++)
//        {
//            for (int x=0; x < width; x++)
//            {
//                points.add(new Point(x*spacing,y*spacing));
//            }
//        }
//        return points;
//    }

}
