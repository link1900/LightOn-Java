package lightOn;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;

public class Lights {
	private HashSet<Light> lights = new HashSet<Light>();
	
	public Lights()
    {
		lights = new HashSet<Light>();
    }
    
    public Lights(int width, int height, int spacing, int Xoffset, int Yoffset)
    {
    	lights = new HashSet<Light>();
        fillPoints(width, height, spacing, Xoffset, Yoffset);
    }
    
    public HashSet<Light> getPoints()
    {
        return lights;
    }
    
    public void paintLights(Graphics g){
        for(Light l : lights){
        	l.paint(g);
        }
    }
    
    public void flicker(Point p){
    	for(Light l : lights){
    		if(l.contains(p)){
    			l.flick();
    			flickClose(l);
    		}
    	}
    }
    
    public boolean allOn(){
    	for(Light l : lights){
    		if(!l.isOn()){
    			return false;
    		}
    	}
    	return true;
    }
    
    public void flickClose(Light l){
    	Light up = getLightViaGrid(l.getGridX(), l.getGridY() -1);
    	Light down = getLightViaGrid(l.getGridX(), l.getGridY() +1);
    	Light left = getLightViaGrid(l.getGridX() - 1, l.getGridY());
    	Light right = getLightViaGrid(l.getGridX() + 1, l.getGridY());
    	if (up != null) up.flick();
    	if (down != null) down.flick();
    	if (left != null) left.flick();
    	if (right != null) right.flick();
    }
    
    public Light getLightViaGrid(int x, int y){
    	for(Light l : lights){
    		if(l.getGridX() == x && l.getGridY() == y){
    			return l;
    		}
    	}
    	return null;
    }
    
    public void fillPoints(int width, int height, int size, int Xoffset, int Yoffset)
    {
        for (int y=0; y < height; y++)
        {
            for (int x=0; x < width; x++)
            {
            	lights.add(new Light(((size + 1) * y) + Yoffset, ((size + 1) * x) + Xoffset,size,size,false,x,y));
            }
        }
    }
}
