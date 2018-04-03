package PlaneFr;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Explode {
	static Image[] ims = new Image[16];
	double x,y;
	static{
		for (int i = 0; i <16; i++) {
			ims[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			ims[i].getWidth(null);
		}
	}
	int count;
	public void draw(Graphics g){
		if(count<=15){
			g.drawImage(ims[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode() {
	}
	
	public Explode(double x,double y){
		this.x= x;
		this.y = y;
	}
}
