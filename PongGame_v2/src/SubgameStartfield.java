import gui.Window;

public class SubgameStartfield extends PowerUp{
	int sizex;
	int sizey;
	
	SubgameStartfield(Window w,Player1 p1,Player2 p2,LinkedBallList bl,int bsize){
		super(w,p1,p2,bl,bsize);
		ne=2;
		effekt=(int)(Math.random()*ne)+1;
		put=500;
		sizex=80;
		sizey=40;
	}
	
	public void draw() {
		if(effekt==1) {
			w.setColor(220, 77, 1);
			w.fillRect(px-sizex, py-sizey, sizex*2, sizey*2);
			w.setColor(255,255,255);
			w.fillCircle(px, py, bsize );
		}
		else if(effekt==2) {
			w.setColor(8, 120, 127);
			w.fillRect(px-sizex, py-sizey, sizex*2, sizey*2);
			w.setColor(255,255,255);
			for(int i=0;i<5;i++) {
				w.fillCircle(px+Math.random()*sizex-sizex/2, py+Math.random()*sizey-sizey/2, bsize);
			}
		}
	}
	public boolean checkcolision() {
		boolean ans=false;
		Ball b;
    	for(BallNode bn=bl.first;bn!=null;bn=bn.next) {
    		b=bn.value;
    		
    		if(Math.abs(b.px-px)<=sizex&&Math.abs(b.py-py)<=sizey) {
    			Subgame sg;
    			if(effekt==1) {
    				sg=new Subgame1(wi, he,w);
    				if(sg.make()) {
    					p2.lives--;
    				}
    				else {
    					p1.lives--;
    				}
    			}
    			else if(effekt==2){
    				sg=new Subgame2(wi, he,w);
    				if(sg.make()) {
    					p2.lives--;
    				}
    				else {
    					p1.lives--;
    				}
    			}
    			ans=true;
    		}
    		
    	}
		return ans;
	}
	public boolean step() {
    	
    	boolean ans=false;
    	put--;
    	if(put==0) {
    		ans=true;
    	}
    	
    	return ans;
    }
	
}
