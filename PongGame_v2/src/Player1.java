import gui.Window;

import java.util.*;
public class Player1 extends Player{
	
	Player1(Window p){
		super(p);
		wi=(int)p.getWidth();
		he=(int)p.getHeight();
		py=he/2;
		px=20;
		this.w=p;
		isPlayer1=true;
		
	}
	public void draw(Window w) {
	
		w.drawLine(px, py-bl/2, px, py+bl/2);
		//w.drawStringCentered(""+points, 30, 30);
		for (int i=0;i<lives;i++) {
			drawCross(30+i*24, 30);
		}
	}
	public void draw2(Window w) {
		w.setColor(67, 5, 65);
		w.drawStringCentered(""+points, 30, 30);
		w.setColor(255, 255, 255);
		w.drawLine(px, py-bl/2, px, py+bl/2);
	}
	public void move() {
		if(w.isKeyPressed("w")) {
			py-=bv;
		}
    	if(w.isKeyPressed("s")) {
    		py+=bv;
    		
    	}
		
	}
	public boolean colide(double px,double py,double size) {
		double u=w.getStrokeWidth()/2;
		return 20-u<=px+size&&px-size<=20+u&&this.py-this.bl/2<=py+size&&py-size<=this.py+this.bl/2;
	}
	public void checkpos() {
		if(py>he-bl/2)py=he-bl/2;
		if(py<bl/2)py=bl/2;
	}
	

}