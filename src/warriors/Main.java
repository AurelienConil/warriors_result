package warriors;

import warriors.Game.Game_status;

public class Main {
	
	public static void main(String args[]) {
		
		Menu menu = new Menu();
		Game game = new Game(menu);
		
		menu.printLineH1(" Bienvenue sur le jeu WARRIORS ");
		while(game.game_status != Game_status.END_GAME) {
			
			game.updateGame();
			

			
		}
		
		menu.printLineH2("GAME OVER");
		menu.printLineH1("A bientot sur le jeu WARRIORS ");
		
	}

}
