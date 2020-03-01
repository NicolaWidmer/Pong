import gui.Window;
import java.util.*;
public class Ball {
	double px;
	double py;
	double vx;
	double vy;
	int size;
	Window w;
	double he;
	double wi;
	Player p1;
	Player p2;
	double v=8;
	Vector<BallEffekts> bev =new Vector<BallEffekts>();
	int r=255;
	int g=255;
	int b=255;
	
	Ball(Player1 p1, Player2 p2,Window p,int s){
		
		this(p1,p2,p,s,(Math.random()<0.5)?10*Math.random():-10*Math.random(),(Math.random()<0.5)?2*Math.random():-2*Math.random());
		
	}
	
	Ball(Player1 p1, Player2 p2,Window p,int s,double vx,double vy){
		he=p.getHeight();
		wi=p.getWidth();
		py=he/2;
		px=wi/2;
		this.w=p;
		size=s;
		this.p1=p1;
		this.p2=p2;
		this.vx=vx;
		this.vy=vy;
		norm();
		
		
	}
	
	public void draw(Window w) {
		w.setColor(r,g,b);
		w.fillCircle(px, py, size);
		w.setColor(255, 255, 255);
	}
	public void move() {
		 px+=vx;
	     py+=vy;
	}
	public boolean checkcolison() {  
        if(colidey())vy=-vy;
        if(colidex1()) {
        	vx=-vx;
        	vy=v*0.06*(py-p1.py)/(size/2.0);
        	
        }
        if(colidex2()) {
        	vx=-vx;
        	vy=v*0.06*(py-p2.py)/(size/2.0);
        	
        }
        norm();
        return false;
	}
	public boolean colidey() {
    	return py<=0+size||py>=he-size;
    }
	public boolean colidex1() {
    	return p1.colide(px,py,size);
    	
    }
	public boolean colidex2() {
    	return p2.colide(px,py,size);
    	
    }
	public void norm() {
		if(Math.abs(vx)<Math.abs(vy)) {
			if(vx>0) {
				vx=Math.abs(vy);
			}
			else {
				vx=-Math.abs(vy);
			}
		}
		double n=Math.sqrt(Math.pow(vx, 2)+Math.pow(vy, 2));

		vx=v/n*vx;
		vy=v/n*vy;
	}
	
	void hits(int i) {
		if(i==1) {
			p2.points++;
			p1.lives--;
			
		}
		else if(i==2) {
			p1.points++;
			p2.lives--;
		}
	}
	
	void handleeffekts() {
		for(int i=0; i<bev.size(); i++){
	         bev.elementAt(i).et-- ;
	         if(bev.elementAt(i).et==0) {
	        	 bev.elementAt(i).reverse();
	        	 bev.remove(i);
	         }
	      }
	}
	
}
