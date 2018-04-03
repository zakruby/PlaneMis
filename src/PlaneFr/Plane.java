package PlaneFr;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class Plane extends FlyObject{
	
	private boolean left,right,up,down;
	private boolean alive=true;
	public void draw(Graphics g){
		if(alive){
		g.drawImage(im, (int)x, (int)y, null);
		move();}
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean liv) {
		alive = liv;
	}
	public void move(){
		if(left){
			x -= speed;
		}
		if(right){
			x += speed;
		}
		if(up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
	}
	
	public void addDir(KeyEvent key){
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		default:
			break;
		}
	}
	public void relDir(KeyEvent key){
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		default:
			break;
		}
	}
	public Plane() {}
	public Plane(Image im) {
		super(im);
	}
	public Plane(String path,double x,double y) {
		super(path,x,y);
	}
	
}
