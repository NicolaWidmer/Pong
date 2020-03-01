import gui.Window;

public class Subgame2 extends Subgame{
	Subgame2(int width, int height,Window w){
		super(width, height,w);
		i=51;
		
		p1.lives=i/2+1;
		p2.lives=i/2+1;
		
		puw=0;
		pubw=0;
		sgsw=0;
	}
	void step() {
		if(i!=0) {
			bl.addFirst(new Ball(p1, p2,w,bs));
			i--;
		}
		bl.step(w,p1,p2);
		
		p1.move();
        p2.move();
        p1.checkpos();
        p2.checkpos();
        
        if(bl.size>0) {
        	bl.step(w,p1,p2);
        }
	}
	
	void draw(Window w) {
		w.setColor(0, 0, 0);
    	w.fillRect(0, 0, width, height);
    	w.setColor(255, 255, 255);
    	p1.draw2(w);
    	p2.draw2(w);
    	bl.draw(w);
	}

}
