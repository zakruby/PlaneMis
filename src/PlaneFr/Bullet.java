package PlaneFr;

import java.awt.Graphics;
import java.awt.Image;


public class Bullet extends FlyObject{
	double degree=Math.random()*2*Math.PI;
	
	public void draw(Graphics g){
		g.drawImage(im, (int)x, (int)y, null);
		move();
	}

	public void move(){
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(x>500-wide||x<0){
			degree = Math.PI-degree;
		}if(y>500-height||y<30){
			degree = -degree;
		}
	}
	
	
	public Bullet() {}
	public Bullet(Image im){
		super(im);
	}
	
	public Bullet(String path,double x,double y){
		super(path,x,y);
	}
}
