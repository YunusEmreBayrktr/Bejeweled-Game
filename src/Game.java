import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	
	int gridWidth;
	int gridHeight;
	
	//This method creates the grid from given txt file.
	//First creates an ArrayList and loops through each line while looking for the symbol and creating 
	//the related object with x-y coordinates to store all existing Jewels. Then creates an 2D Jewel array
	//and uses these x-y coordinates to put the objects in this array and returns it.
	//Also calculates the grid height and grid width.
	public Jewel[][] createGrid(String fileName) throws IOException {
		
		ArrayList<Jewel> jewels =  new ArrayList<>();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		int y = 0;
		
		while((line = br.readLine()) != null) {
		
			int x = 0;
			String[] temp = line.split(" ");
			
			for (String i : temp) {
				
				if (i.equals("D")) {
					jewels.add(new Diamond(x,y,i));
					x+=1;
				}
				else if (i.equals("S")) {
					jewels.add(new Square(x,y,i));
					x+=1;
				}
				else if (i.equals("T")) {
					jewels.add(new Triangle(x,y,i));
					x+=1;
				}
				else if (i.equals("W")) {
					jewels.add(new Wildcard(x,y,i));
					x+=1;
				}
				else if (i.equals("/")) {
					jewels.add(new MathSymbol(x,y,i));
					x+=1;
				}
				else if (i.equals("-")) {
					jewels.add(new MathSymbol(x,y,i));
					x+=1;
				}
				else if (i.equals("+")) {
					jewels.add(new MathSymbol(x,y,i));
					x+=1;
				}
				else if (i.equals("\\")) {
					jewels.add(new MathSymbol(x,y,i));
					x+=1;
				}
				else if (i.equals("|")) {
					jewels.add(new MathSymbol(x,y,i));
					x+=1;
				}
			}
			y+=1;	
			this.gridWidth = x;
		}
		this.gridHeight = y;
		br.close();
		
		Jewel[][] grid = new Jewel[gridHeight][gridWidth];
		for(Jewel i : jewels) {
			grid[i.yCoordinate][i.xCoordinate] = i;
		}
		return grid;	
	}
	
	//This method reads the given file and returns it as an ArrayList.
	public static ArrayList<String> readFile(String fileName) {
			
		ArrayList<String> data = new ArrayList<>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				data.add(line);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return data;	
	}
	
	//This method creates the monitoring.txt file and writes the given ArrayList into it.
	public static void writeFile(ArrayList<String> output) {
			
		try {
			File fl = new File("monitoring.txt");
			FileWriter writer = new FileWriter(fl);
			
			for(String i : output) {
				writer.write(i);
			}
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//This method creates Player objects from given txt file, puts them in an ArrayList and returns it.
	public ArrayList<Player> getPlayers(String fileName) throws IOException {
		
		ArrayList<Player> players = new ArrayList<>();
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null) {
			String[] temp = line.split(" ");
			players.add(new Player(temp[0],Integer.parseInt(temp[1])));
		}	
		br.close();		
						
		return players;	
	}
	
	//This method returns the given 2D array as a String.
	public String printGrid(Jewel[][] grid) {
		
		String print = "";
		for(int y=0; y<gridHeight; y++) {		
			String[] temp = new String[gridWidth];
			
			for(int x=0; x<gridWidth; x++) {
				temp[x] = grid[y][x].symbol;			
			}
			print = print +String.join(" ", temp) + "\n";
			
		}
		return print + "\n";	
	}
	
	//This method checks the given cell and calls the related method for that jewel to pop. 
	public void check(int x, int y, Jewel[][] grid) throws ArrayIndexOutOfBoundsException{
		
			if(grid[y][x] instanceof Diamond && grid[y][x].notPopped) {
				Diamond.dPop(x, y, grid);
			}
			else if(grid[y][x] instanceof Square && grid[y][x].notPopped) {
				Square.sPop(x, y, grid);
			}
			else if(grid[y][x] instanceof Triangle && grid[y][x].notPopped) {
				Triangle.tPop(x, y, grid);
			}
			else if(grid[y][x] instanceof Wildcard && grid[y][x].notPopped) {
				Wildcard.wPop(x, y, grid);	
			}
			else if(grid[y][x] instanceof MathSymbol && grid[y][x].notPopped) {
				MathSymbol.mPop(x, y, grid);
			}
			else {
				throw new ArrayIndexOutOfBoundsException();
			}		
	}
	
	//This method updates the game grid. Loops through each cell and looks for empty ones.
	//Then moves the jewels down to fill the gaps.
	public void updateGrid(Jewel[][] grid) {
		
		for(int t=0; t<gridHeight; t++) {
			for(int i=1; i<gridHeight; i++) {
				for(int j=0; j<gridWidth; j++) {
					if((grid[i][j].symbol.equals(" "))) {
						Jewel temp = grid[i][j];
						grid[i][j] = grid[i-1][j];
						grid[i-1][j] = temp;
					}
				}
			}
		}	
	}	
	
	public void launchGame(String args1, String args2) throws IOException {
		
		/*Creating the game grid, reading the commands, creating an ArryList 
		 * for monitoring and a new Player object. */
		Jewel[][] grid = createGrid(args1);
		ArrayList<String> commands = readFile(args2);
		ArrayList<String> monitoring = new ArrayList<String>();
		Player player = new Player(commands.get(commands.size()-1),0);
		
		//Printing the initial game grid.
		monitoring.add("Game grid:\n\n");
		monitoring.add(printGrid(grid));
		
		//Looping through the commands and taking necessary actions.
		for(String line : commands) {
			
			if(line.equals("E")) {
				monitoring.add("Select coordinate or enter E to end the game: E\n\n");
				monitoring.add("Total score:" + player.totalScore + " points\n\n");
				monitoring.add("Enter name: "+ player.name+"\n\n");
				
				ArrayList<Player> leaderboard = getPlayers("leaderboard.txt");
				monitoring.add(player.rank(leaderboard));
				
				ArrayList<Player> rank = getPlayers("leaderboard.txt");
				rank.add(player);
				
				Player.writeLeaderboard(rank); 
				writeFile(monitoring);
				break;
			}
			else {
				try {
					String[] coordinates = line.split(" ");
					monitoring.add("Select coordinate or enter E to end the game: "+coordinates[0]+" "+coordinates[1]+"\n\n" );
					check(Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[0]), grid);
					updateGrid(grid);
					monitoring.add(printGrid(grid));
					player.score(grid);
					monitoring.add("Score: "+player.score+" points\n\n");
				}
				catch(ArrayIndexOutOfBoundsException e){
					monitoring.add("Please enter a valid coordinate\n\n");
				}
			}
		}
		
	}
}

