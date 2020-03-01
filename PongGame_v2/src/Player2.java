import gui.Window;

import java.util.*;
public class Player2 extends Player{
	
	Player2(Window p){
		super(p);
		wi=(int)p.getWidth();
		he=(int)p.getHeight();
		py=he/2;
		px=wi-20;
		this.w=p;
		isPlayer1=false;
		
	}
	public void draw(Window w) {
		w.drawLine(px, py-bl/2, px, py+bl/2);
		//w.drawStringCentered(""+points, wi-30, 30);
		for (int i=0;i<lives;i++) {
			drawCross(wi-30-i*24, 30);
		}
	}
	public void draw2(Window w) {
		w.setColor(67, 5, 65);
		w.drawStringCentered(""+points, wi-30, 30);
		w.setColor(255, 255, 255);
		w.drawLine(px, py-bl/2, px, py+bl/2);
	}
	
	
	public void move() {
		if(w.isKeyPressed("up")) {
			py-=bv;
			
		}
    	if(w.isKeyPressed("down")) {
    		py+=bv;
    	}
    
	}
	public boolean colide(double px,double py,double size) {
		double u=w.getStrokeWidth()/2;
		return wi-20-u<=px+size&&px-size<=wi-20+u&&this.py-this.bl/2<=py+size&&py-size<=this.py+this.bl/2;
	}
	public void checkpos() {
		if(py>he-bl/2)py=he-bl/2;
		if(py<bl/2)py=bl/2;
	}

}