import gui.Window;

public class PowerUpBall extends Ball {
	int effekt;
	int ne=4;
	int effekttime=150;
	
	PowerUpBall(Player1 p1, Player2 p2,Window p,int s,double vx,double vy){
		super(p1,p2,p,s,vx,vy);
		effekt=(int)(Math.random()*ne)+1;
		this.v=3;
		norm();
		
	}
	public void draw(Window w) {
		if(effekt==1||effekt==3)w.setColor(78, 253, 84);
		if(effekt==2||effekt==4)w.setColor(255, 7, 58);
		w.fillCircle(px, py, size);
		w.setColor(255, 255, 255);
		if(effekt==1||effekt==2) {
			w.setStrokeWidth(4);
			w.drawLine(px, py-size/1.5, px, py+size/1.5);
		}
		if(effekt==3||effekt==4) {
			w.setStrokeWidth(2);
			double yp1=py+size/1.5;
			double yp2=py-size/4.0;
			double yp3=py+size/4.0;
			double yp4=py-size/1.5;
			double xp1=px+size/2.5;
			double xp2=px-size/2.5;
			w.drawLine(px, yp1, xp1, yp2);
			w.drawLine(xp1, yp2, xp2, yp3);
			w.drawLine(xp2, yp3, px, yp4);
		}
		
		w.setStrokeWidth(7);
		
	}
	
	public boolean checkcolison() {
		boolean ans =false;
        if(colidey())vy=-vy;
        if(colidex1()) {
        	if(effekt==1||effekt==3) {
        		Effekts ef=new Effekts(effekt, effekttime,p1);
        		ef.make();
        		p1.ev.add( ef);
        		
        	}
        	if(effekt==2||effekt==4) {
        		Effekts ef=new Effekts(effekt, effekttime,p2);
        		ef.make();
        		p2.ev.add( ef);
        	}
        	ans= true;
        }
        if(colidex2()) {
        	if(effekt==1||effekt==3) {
        		Effekts ef=new Effekts(effekt, effekttime,p2);
        		ef.make();
        		p2.ev.add( ef);
        	}
        	if(effekt==2||effekt==4) {
        	Effekts ef=new Effekts(effekt, effekttime,p1);
    		ef.make();
    		p1.ev.add( ef);
        	}
        	ans=true;
        }
        return ans;
	}
	void hits(int i) {
		
	}

}
