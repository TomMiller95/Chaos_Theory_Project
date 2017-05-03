package data;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import Helpers.Artist;
import Helpers.Textures;
import static Helpers.Artist.*;

public class Driver {
	
	private final int DISPLAY_SPEED = 1000;
	Random rgen = new Random();
	ArrayList<Point> points = new ArrayList<>();
    int dotSize = 1;

    public Driver() {
        BeginSession();
        Textures.load();
        singleTriangle();
        //fern();
 	}

    private void singleTriangle()
    {
    	Point p1 = new Point(Textures.getTex("greenPoint"),250,250,5,5);
        Point p2 = new Point(Textures.getTex("bluePoint"),250,250,5,5);
        Point p3 = new Point(Textures.getTex("redPoint"),250,250,5,5);
        
        Point background = new Point(Textures.getTex("background"),0,0,1500,1500);

        /*
        Point A = new Point(Textures.getTex("greenPoint"),500,50,10,10);
        Point B = new Point(Textures.getTex("greenPoint"),100,600,10,10);
        Point C = new Point(Textures.getTex("greenPoint"),900,600,10,10);
        int pointAX = 500;
        int pointAY = 50;
        int pointBX = 100;
        int pointBY = 600;
        int pointCX = 900;
        int pointCY = 600;
        */


        /*
        Point A = new Point(Textures.getTex("point"),700,50,20,20);
        Point B = new Point(Textures.getTex("point"),300,600,20,20);
        Point C = new Point(Textures.getTex("point"),550,500,20,20);
        int pointAX = 700;
        int pointAY = 50;
        int pointBX = 300;
        int pointBY = 600;
        int pointCX = 550;
        int pointCY = 500;
        */

        //Right Triangle
        Point A = new Point(Textures.getTex("greenPoint"),100,50,10,10);
        Point B = new Point(Textures.getTex("greenPoint"),100,600,10,10);
        Point C = new Point(Textures.getTex("greenPoint"),900,600,10,10);
        int pointAX = 100;
        int pointAY = 50;
        int pointBX = 100;
        int pointBY = 600;
        int pointCX = 900;
        int pointCY = 600;

        
        float x1 = 250;
        float y1 = 250;
        float x2 = 250;
        float y2 = 250;
        float x3 = 250;
        float y3 = 250;
        p1.update();
        p2.update();
        p3.update();
        int roll;
        
        while (!Display.isCloseRequested())        //Runs until simulation is terminated, or finished.
        {
            //Keeps images from staying on screen.
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            background.update();
            A.update();
            B.update();
            C.update();
            
            for (int i = 0; i < points.size(); i++)
            {
            	points.get(i).update();
            }
            
            roll = rgen.nextInt(4);
            
            if (roll == 0 || roll == 3)
            {
            	x1 += (pointAX-x1)/2;
            	y1 += (pointAY-y1)/2;
            }
            else if (roll == 1)
            {
            	x1 += (pointBX-x1)/2;
            	y1 += (pointBY-y1)/2;
            }
            else
            {
            	x1 += (pointCX-x1)/2;
            	y1 += (pointCY-y1)/2;
            }

            roll = rgen.nextInt(4);

            if (roll == 0)
            {
                x2 += (pointAX-x2)/2;
                y2 += (pointAY-y2)/2;
            }
            else if (roll == 1 || roll == 3)
            {
                x2 += (pointBX-x2)/2;
                y2 += (pointBY-y2)/2;
            }
            else
            {
                x2 += (pointCX-x2)/2;
                y2 += (pointCY-y2)/2;
            }

            roll = rgen.nextInt(4);

            if (roll == 0)
            {
                x3 += (pointAX-x3)/2;
                y3 += (pointAY-y3)/2;
            }
            else if (roll == 1)
            {
                x3 += (pointBX-x3)/2;
                y3 += (pointBY-y3)/2;
            }
            else if (roll == 2 || roll == 3)
            {
                x3 += (pointCX-x3)/2;
                y3 += (pointCY-y3)/2;
            }
            
            p1 = new Point(Textures.getTex("greenPoint"),x1,y1,dotSize,dotSize);
            points.add(p1);
            p2 = new Point(Textures.getTex("bluePoint"),x2,y2,dotSize,dotSize);
            points.add(p2);
            p3 = new Point(Textures.getTex("redPoint"),x3,y3,dotSize,dotSize);
            points.add(p3);
            
            Display.update();
            Display.sync(DISPLAY_SPEED);  //Basically this is the speed of the simulation
        }
        Display.destroy();  //Destorys the GUI
    }
    
    









    private void fern()
    {
    	Point p = new Point(Textures.getTex("point"),250,250,10,10);
        
        Point background = new Point(Textures.getTex("background"),0,0,1500,1500);
        
        float x = 0.4f;
        float y = 0.8f;
        
        p.update();
                
        while (!Display.isCloseRequested())
        {
            //Keeps images from staying on screen.
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            background.update();
           
                        
            for (int i=0; i<200000; i++) 
            {
            	int n = getRandomProb();
	              
            	if (n == 1) 
            	{
            		x = (float) (0.85*x + 0.04*y);
            		y = (float) (-0.04*x + 0.85*y + 1.6);
            	} 
            	else if (n == 2) 
            	{
            		x = (float) (-0.15*x + 0.28*y);
            		y = (float) (0.26*x + 0.24*y + 0.44);
            	}
            	else if (n == 3) 
            	{
            		x = (float) (0.2*x - 0.26*y);
            		y = (float) (0.23*x + 0.22*y + 1.6);
            	} 
            	else if (n == 4) 
            	{
            		x = 0;
            		y = (float) (0.16*y);
            	}  
            }
            
            x *= 50;
            y *= 50;
            x += 500;
            y += 100;
            
            p = new Point(Textures.getTex("greenPoint"),x,y,5,5);
            points.add(p);
            
            for (int i = 0; i < points.size(); i++)
            {
            	points.get(i).update();
            }
            
            Display.update();
            Display.sync(DISPLAY_SPEED);
        }
        Display.destroy();
    }
	
	
	public static int getRandomProb()
	  {
	    double r = Math.random();
	    if (r<=0.85) return 1;
	    else if (r<=0.92) return 2;
	    else if (r<=0.99) return 3;
	    else return 4;
	  }

    public static void main(String[] args)
    {
        new Driver();
    }
}