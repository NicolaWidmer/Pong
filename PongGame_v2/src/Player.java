import gui.Window;
import java.util.*;
public class Player {
	int px;
	int py;
	int bl=160;
	double bv=8;
	
	int points=0;
	int lives=5;
	
	Window w;
	int wi;
	int he;
	Vector<Effekts> ev= new Vector<Effekts>();
	
	boolean isPlayer1;
		
	Player(Window p){
		wi=(int)p.getWidth();
		he=(int)p.getHeight();
		py=he/2;
		px=wi-20;
		this.w=p;
		
	}
	
	void handleEffekts(){
		
		
	      for(int i=0; i<ev.size(); i++){
	         ev.elementAt(i).et-- ;
	         if(ev.elementAt(i).et==0) {
	        	 ev.elementAt(i).reverse();
	        	 ev.remove(i);
	         }
	      }
		
	}
	
	
	public void checkpos() {
		if(py>he-bl/2)py=he-bl/2;
		if(py<bl/2)py=bl/2;
	}
	
	public void drawCross(int px,int py) {
		
		w.setColor(255, 0, 13);
		double  s=w.getStrokeWidth();
		w.setStrokeWidth(3);
		int z=8;
		w.drawLine(px-z, py, px+z, py);
		w.drawLine(px, py-z, px, py+z);
		w.setStrokeWidth(s);
		w.setColor(255, 255, 255);
	}
	
	public void win() {
		int fz=w.getFontSize();
		w.setColor(0, 0, 0);
		w.fillRect(0, 0, wi, he);
		w.setColor(253,95,0);
		w.setFontSize(80);
		if(!isPlayer1) {
			w.drawStringCentered("Player 1 Wins!!", wi/2, he/2);
		}
		else {
			w.drawStringCentered("Player 2 Wins!!", wi/2, he/2);
		}
		w.setColor(255,255,255);
		w.setFontSize(20);
		w.drawStringCentered("Press g for a rematch", wi/2, he/2+100);
		
		
		w.setFontSize(fz);
		w.setColor(0, 0, 0);
	}
	
	public void draw(Window w) {
	}
	public void draw2(Window w) {
	}
	public void move() {
		
	}
	public boolean colide(double px,double py,double size) {
		return true;
	}
	

}

