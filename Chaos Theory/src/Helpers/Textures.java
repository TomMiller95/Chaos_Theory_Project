package Helpers;

import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public final class Textures {
	
	public static HashMap<String,Texture> texs = new HashMap<>();
	//public static Texture ant;
    public static Texture point;
    public static Texture background;
    public static Texture greenPoint;
	public static Texture bluePoint;
	public static Texture redPoint;
	
	public static void load() {
    	try {	
    		point = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Res/dot.png"));
    		greenPoint = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Res/greenDot.png"));
            bluePoint = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Res/blueDot.png"));
            redPoint = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Res/redDot.png"));
    		background = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Res/whiteBack.png"));
    	
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
        texs.put("point", point);
        texs.put("greenPoint", greenPoint);
        texs.put("bluePoint", bluePoint);
        texs.put("redPoint", redPoint);
        texs.put("background", background);
	}
	
	public static Texture getTex(String desc)
	{
		return texs.get(desc);
	}
}