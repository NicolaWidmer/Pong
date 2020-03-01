import static java.lang.Math.PI;
import gui.Window;
import java.util.*;
public class PongGame {
	Player1 p1;
	Player2 p2;
	
	Ball b;
	LinkedBallList bl;
	int bs=10;
	
	LinkedBallList publ;
	double pubw=0.002;
	
	Vector<PowerUp> puv=new Vector<PowerUp>();
	double puw=0.004;
	
	Vector<PowerUp> sgs=new Vector<PowerUp>();
	double sgsw=0.001;
	
    int width;
    int height;
    Window w;
    
    int i=1000;
    int j=i;
    
    PongGame(int width, int height,Window w) {
        this.width = width;
        this.height = height;
        p1=new Player1(w);
        p2=new Player2(w);
        bl=new LinkedBallList();
        publ=new LinkedBallList();
        bl.addFirst(new Ball(p1, p2,w,bs));
        this.w=w;
        
    }
    
    void step() { 
    	/*j--;
    	if(j==0) {
    		bl.addFirst(new Ball(p1, p2,w,bs));
    		j=i;
    	}*/
    	
    	bl.step(w,p1,p2);
    	
    	if(bl.isEmpty()) {
    		bl.addFirst(new Ball(p1, p2,w,bs));
    	}
    	
        p1.move();
        p2.move();
        p1.checkpos();
        p2.checkpos();
        p1.handleEffekts();
        p2.handleEffekts();
        
    	
        
        if(Math.random()<pubw) {
        	double hvx=(Math.random()<0.5)?10*Math.random():-10*Math.random();
        	double hvy=(Math.random()<0.5)?2*Math.random():-2*Math.random();
			publ.addFirst(new PowerUpBall(p1, p2,w,2*bs,hvx,hvy));
			publ.addFirst(new PowerUpBall(p1, p2,w,2*bs,-hvx,-hvy));
		}
        
        publ.step(w, p1, p2);
        
        if(bl.size>0) {
        	bl.step(w,p1,p2);
        }
        
        if(Math.random()<puw) {
			puv.add(new PowerUp(w,p1,p2,bl,bs));
		}
        for(int i=0; i<puv.size(); i++){
        	if(puv.get(i).step())puv.remove(i);
        }
        
        if(Math.random()<sgsw) {
			sgs.add(new SubgameStartfield(w,p1,p2,bl,bs));
		}
        for(int i=0; i<sgs.size(); i++){
        	if(sgs.get(i).step()) {
        		sgs.remove(i);
        	}
        	if(i<sgs.size()&&sgs.get(i).checkcolision()) {
        		sgs.remove(i);
        		drawCountdown(5);
        	}
        }
        
    	
        
    }
    void draw(Window w) {
    	w.setColor(0, 0, 0);
    	w.fillRect(0, 0, width, height);
    	w.setColor(255, 255, 255);
    	p1.draw(w);
    	p2.draw(w);
    	bl.draw(w);
    	for(int i=0; i<puv.size(); i++){
        	puv.get(i).draw();
        }
    	for(int i=0; i<sgs.size(); i++){
        	sgs.get(i).draw();
        }
    	if(!publ.isEmpty()) {
    		publ.draw(w);
    	}
    }
    
    
    boolean checkgamestate() {
    	boolean ans=true;
    	boolean nextgame=true;
    	if(p1.lives==0) {
    		ans=false;
    		while(nextgame&&w.isOpen()) {
    			if(w.wasKeyTyped("g"))nextgame=false;
    			
    			p1.win();
    			w.refreshAndClear(17);
    		}
    	}
    	if(p2.lives==0) {
    		ans=false;
    		
    		while(nextgame&&w.isOpen()) {
    			if(w.wasKeyTyped("g"))nextgame=false;
    			p2.win();
    			w.refreshAndClear(17);
    		}
    	}
    	return ans;
    }
    
    void drawCountdown(int t) {
    	double i=255.0/t;
    	for(;t>=0;t--) {
    		draw(w);
    		double hw=w.getStrokeWidth();
    		w.setStrokeWidth(3);
    		for(BallNode bn=bl.first;bn!=null;bn=bn.next) {
    			b=bn.value;
    			w.drawLine(b.px, b.py, b.px+b.vx*10, b.py+b.vy*10);
	    	}
    		
    		w.setStrokeWidth(hw);
    		
    		int fz=w.getFontSize();
    		w.setColor((int)(0+t*i),(int)(255-t*i),0);
    		w.setFontSize(80);
    		w.drawStringCentered(""+t, width/2, height/2);
    		w.setColor(255, 255, 255);
    		w.refreshAndClear(1000);
    		w.setFontSize(fz);
    	}
    }
    
    
}
