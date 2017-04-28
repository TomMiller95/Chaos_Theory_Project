package data;

import org.newdawn.slick.opengl.Texture;

import Helpers.Artist;

public class Point {

	private Texture t;
	private float x,y,h,w;
	
	public Point(Texture t, float x, float y, float h, float w)
	{
		this.t = t;
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}
	
	private void draw()
	{
		Artist.DrawQuadTex(t, x, y, h, w);
	}
	
	public void update()
	{
		draw();
	}
}
