
public class Wildcard extends Jewel{
	
	
	public Wildcard(int xCoordinate, int yCoordinate, String symbol) {
		super(xCoordinate, yCoordinate, symbol);
	}
	
	//First looks for matching wild card cases in every direction ( WXX or WXW or WWX).
	//If the matching returns true then calls the 'pop' method for the related direction and
	//exits the method.
	public static void wPop(int x ,int y, Jewel[][] grid) {
		
		try {
			if (grid[y-1][x].getClass().equals(grid[y-2][x].getClass()) ||
				grid[y-1][x] instanceof Wildcard || grid[y-2][x] instanceof Wildcard) {
				Jewel.pop(x, y, 2, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y+1][x].getClass().equals(grid[y+2][x].getClass()) ||
				grid[y+1][x] instanceof Wildcard || grid[y+2][x] instanceof Wildcard) {
				Jewel.pop(x, y, 8, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y][x-1].getClass().equals(grid[y][x-2].getClass()) ||
				grid[y][x-1] instanceof Wildcard || grid[y][x-2] instanceof Wildcard) {
				Jewel.pop(x, y, 4, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y][x+1].getClass().equals(grid[y][x+2].getClass()) ||
				grid[y][x+1] instanceof Wildcard || grid[y][x+2] instanceof Wildcard) {
				Jewel.pop(x, y, 6, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y-1][x-1].getClass().equals(grid[y-2][x-2].getClass()) ||
				grid[y-1][x-1] instanceof Wildcard || grid[y-2][x-2] instanceof Wildcard) {
				Jewel.pop(x, y, 1, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y+1][x+1].getClass().equals(grid[y+2][x+2].getClass()) ||
				grid[y+1][x+1] instanceof Wildcard || grid[y+2][x+2] instanceof Wildcard) {
				Jewel.pop(x, y, 9, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y-1][x+1].getClass().equals(grid[y-2][x+2].getClass()) ||
				grid[y-1][x+1] instanceof Wildcard || grid[y-2][x+2] instanceof Wildcard) {
				Jewel.pop(x, y, 3, grid);
				return;
			}}
			catch(Exception e) {}
			
		try {
			if (grid[y+1][x-1].getClass().equals(grid[y+2][x-2].getClass()) ||
				grid[y+1][x-1] instanceof Wildcard || grid[y+2][x-2] instanceof Wildcard) {
				Jewel.pop(x, y, 7, grid);
				return;
			}}		
			catch(Exception e) {}
	}
}
