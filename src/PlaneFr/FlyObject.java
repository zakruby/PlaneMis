package PlaneFr;

import java.awt.Image;
import java.awt.Rectangle;

import util.GameUtil;

public class FlyObject {
	Image im;
	double x,y;
	int wide,height;
	double speed=3;
	
	public Rectangle getRec(){
		return new Rectangle((int)x,(int) y, wide, height);
	}
	
	public FlyObject(){}
	public FlyObject(Image im){
		this.im = im;
		this.wide =im.getWidth(null);
		this.height = im.getHeight(null);
	}
	public FlyObject(String path,double x,double y) {
		this(GameUtil.getImage(path));
		this.x = x-wide/2;
		this.y = y-height/2;
	}
	
}
