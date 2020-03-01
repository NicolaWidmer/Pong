import gui.Window;

public class Subgame extends PongGame{
	Subgame(int width, int height,Window w){
		super(width, height,w);
	}
	public boolean make() {
		while(w.isOpen()) {
			draw(w);
			step();
			
			w.refreshAndClear(17);
			
			if(p1.lives==0)break;
			if(p2.lives==0)break;
			
    	}
		
		return p2.lives==0;
	}

	
}
