import gui.Window;

public class PongGui {
    
    public static void main(String[] args) {
        int width = 1200;
        int height = 800;
        
        
        
        
        Window window = new Window("Pong", width, height);
        
        window.open();
        window.setFontSize(20);
        window.setStrokeWidth(7);
        while(window.isOpen()) {
        	//PongGame game = new Subgame1(width, height,window);
        	//PongGame game = new Subgame2(width, height,window);
        	PongGame game = new PongGame(width, height,window);
        	boolean gamestate=true;
        	game.draw(window);
        	game.drawCountdown(10);
        	while(gamestate&&window.isOpen()) {
        	
        	
        		game.draw(window);
            	game.step();
            	
            	gamestate=game.checkgamestate();
            
            
            	window.refreshAndClear(17);
        	}
        }
        
    }
}
