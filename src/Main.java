import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		try {
			Game game = new Game();
			game.launchGame(args[0], args[1]);
		}
		catch(IOException e){
			System.out.println("File not found!");
		}	
	}
}
