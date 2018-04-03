package PlaneFr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

public class StartMain extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p = new Plane("images/plane.png", Constant.WINDOW_W/2, 400);
	ArrayList<Bullet> bullist = new ArrayList<>(); 
	Explode baozha;
	Date start;
	Date end;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i=0;i<bullist.size();i++){
			Bullet b =bullist.get(i);
			b.draw(g);
			
			Boolean boom = b.getRec().intersects(p.getRec());
			if(boom){
				p.setAlive(false);
				if(baozha==null){
					end = new Date();
					baozha=new Explode(p.x-p.wide/2,p.y-p.height/2);
				}
				baozha.draw(g);
				break;
			}
		}
		if(!p.isAlive()){
			int li = (int)((end.getTime()-start.getTime())/1000);
			printInfo(g,"存活"+li+"秒",20,220,150);
			switch (li/10) {
			case 0:
				printInfo(g, "菜鸟", 40, 215, 200);
				break;
			case 1:
				printInfo(g, "普通", 40, 215, 200);
				break;
			case 2:
				printInfo(g, "高手", 40, 215, 200);
				break;
			default:
				printInfo(g, "精通", 40, 215, 200);
				break;
			}
		}
	}
	
	public void printInfo(Graphics g,String str,int size,double x,double y){
		Color c =g.getColor();
		g.setColor(Color.WHITE);
		Font f = new Font("宋体", Font.BOLD, size);
		g.setFont(f);
		g.drawString(str,(int)x, (int)y);
		g.setColor(c);
	}
	
	@Override
	public void launchFram() {
		super.launchFram();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				p.addDir(e);;
			}
			@Override
			public void keyReleased(KeyEvent e) {
				p.relDir(e);;
			}
		});
		
		for (int i = 0; i < 30; i++) {
			Bullet b = new Bullet("images/bullet.bmp",
					Constant.WINDOW_W/2,Constant.WINDOW_H/2);
			bullist.add(b);
		}
		
		start = new Date();
	}
	public static void main(String[] args) {
			new StartMain().launchFram();
		
	}
}
