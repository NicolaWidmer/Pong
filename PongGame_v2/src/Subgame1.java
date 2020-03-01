import gui.Window;

//normal Ponggame without powerups
public class Subgame1 extends Subgame{
	Subgame1(int width, int height,Window w){
		super(width, height,w);
		puw=0;
		pubw=0;
		sgsw=0;
		p1.lives=1;
		p2.lives=1;
	}

}
