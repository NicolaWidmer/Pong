import gui.Window;
public class PowerUp {
    double px;
    double py;
    int size=30;
    Window w;
    int he;
    int wi;
    Player1 p1;
    Player2 p2;
    LinkedBallList bl;
    int effekt;
	int ne=5;
	int effekttime=300;
	int bsize=10;
	
	int put=1000;

    PowerUp(Window w,Player1 p1,Player2 p2,LinkedBallList bl,int bsize){
        he=(int)w.getHeight();
        wi=(int)w.getWidth();
        this.w=w;
        this.p1=p1;
        this.p2=p2;
        this.bl=bl;
        px=(wi-200)*Math.random()+100;
        py=(he-60)*Math.random()+30;
        effekt=(int)(Math.random()*ne)+1;
        this.bsize=bsize;

    }
    public void draw(){
    	if(effekt==1) {
    		w.setColor(68, 142, 228);
    		w.fillCircle(px, py, size);
    		w.setColor(255,255,255);
    		w.fillCircle(px, py, bsize/2);
			
		}
		if(effekt==2) {
			w.setColor(68, 142, 228);
			w.fillCircle(px, py, size);
			w.setColor(255,255,255);
			w.fillCircle(px, py, 2*bsize);
		}
		if(effekt==3) {
			w.setColor(253, 255, 82);
			w.fillCircle(px, py, size);
			w.setColor(255, 255, 255);
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
			w.setStrokeWidth(7);
			
		}
		if(effekt==4) {
			double d=bsize/0.75;
			w.setColor(166, 111, 181);
			w.fillCircle(px, py, size);
			w.setColor(255,255,255);
			w.fillCircle(px, py+d, bsize);
			w.fillCircle(px, py-d, bsize);
		}
		if(effekt==5) {
			w.drawCircle(px, py, size);
		}
       
    }
    public boolean checkcolision(){
    	
    	boolean ans=false;
    	Ball b;
    	for(BallNode bn=bl.first;bn!=null;bn=bn.next) {
    		b=bn.value;
    		if(Math.abs(b.px-px)<=size&&Math.abs(b.py-py)<=size) {
    			if(effekt==4) {
    				bl.addFirst(new Ball(p1, p2,w,b.size));
    			}
    			else {
    				BallEffekts bef;
    				if(effekt==5) {
    					bef=new BallEffekts(effekt, effekttime/10,b);
    				}
    				else{
    					bef=new BallEffekts(effekt, effekttime,b);
    				}
    				bef.make();
    				b.bev.add(bef);
    			}
    			ans=true;
    		}
    		
    	}
    	
    	return ans;
    }
    public boolean step() {
    	
    	boolean ans=checkcolision();
    	put--;
    	if(put==0) {
    		ans=true;
    	}
    	
    	return ans;
    }

    
}