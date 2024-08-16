
public class Jewel {
	
	public int xCoordinate;
	public int yCoordinate;
	public String symbol;
	public boolean notPopped = true;
	
	
	public Jewel(int xCoordinate, int yCoordinate, String symbol) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;		
		this.symbol = symbol;
	}
	
	//Returns the symbol of the jewel as string.
	public static String getJewelAt(int x, int y, Jewel[][] grid) {
		return grid[y][x].symbol;
	}
	
	//Deletes the symbol of the jewel on the grid and sets it notPopped attribute as false.
	private void delete() {
		this.symbol = " ";
		this.notPopped = false;
	}
	
	//Tries to match the given jewel along the desired direction on the grid.
	public static boolean matching(int x,int y, int direction, Jewel[][] grid) {
		
		try {
		if (direction == 1) {
			if (grid[y][x].getClass().equals(grid[y-1][x-1].getClass())
			  &&grid[y][x].getClass().equals(grid[y-2][x-2].getClass())
			  &&grid[y-1][x-1].notPopped && grid[y-2][x-2].notPopped) {
				return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 2) {
			if (grid[y][x].getClass().equals(grid[y-1][x].getClass())
			  &&grid[y][x].getClass().equals(grid[y-2][x].getClass())
			  &&grid[y-1][x].notPopped && grid[y-2][x].notPopped ) {
				return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 3) {
			if(grid[y][x].getClass().equals(grid[y-1][x+1].getClass())
			 &&grid[y][x].getClass().equals(grid[y-2][x+2].getClass())
			 &&grid[y-1][x+1].notPopped && grid[y-2][x+2].notPopped) {
				return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 4) {
			if(grid[y][x].getClass().equals(grid[y][x-1].getClass())
			 &&grid[y][x].getClass().equals(grid[y][x-2].getClass())
			 &&grid[y][x-1].notPopped && grid[y][x-2].notPopped) {
						return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 6) {
			if(grid[y][x].getClass().equals(grid[y][x+1].getClass())
			 &&grid[y][x].getClass().equals(grid[y][x+2].getClass())
			 &&grid[y][x+1].notPopped && grid[y][x+2].notPopped) {
						return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 7) {
			if(grid[y][x].getClass().equals(grid[y+1][x-1].getClass())
			 &&grid[y][x].getClass().equals(grid[y+2][x-2].getClass())
			 &&grid[y+1][x-1].notPopped && grid[y+2][x-2].notPopped) {
						return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 8) {
			if(grid[y][x].getClass().equals(grid[y+1][x].getClass())
			 &&grid[y][x].getClass().equals(grid[y+2][x].getClass())
			 &&grid[y+1][x].notPopped && grid[y+2][x].notPopped) {
						return true;
			}
		}}
		catch(Exception e) {}
		
		try {
		if(direction == 9) {
			if(grid[y][x].getClass().equals(grid[y+1][x+1].getClass())
			 &&grid[y][x].getClass().equals(grid[y+2][x+2].getClass())
			 &&grid[y+1][x+1].notPopped && grid[y+2][x+2].notPopped) {
						return true;
			}
		}}
		catch(Exception e) {}

		return false;	
	}
	
	//Pops the jewels along given direction on the grid.
	public static void pop(int x,int y, int direction, Jewel[][] grid) {
		
		if(direction == 1) {
			grid[y][x].delete();
			grid[y-1][x-1].delete();
			grid[y-2][x-2].delete();
		}
		else if(direction == 2) {
			grid[y][x].delete();
			grid[y-1][x].delete();
			grid[y-2][x].delete();
		}
		else if(direction == 3) {
			grid[y][x].delete();
			grid[y-1][x+1].delete();
			grid[y-2][x+2].delete();
		}
		else if(direction == 4) {
			grid[y][x].delete();
			grid[y][x-1].delete();
			grid[y][x-2].delete();
		}
		else if(direction == 6) {
			grid[y][x].delete();
			grid[y][x+1].delete();
			grid[y][x+2].delete();
		}
		else if(direction == 7) {
			grid[y][x].delete();
			grid[y+1][x-1].delete();
			grid[y+2][x-2].delete();
		}
		else if(direction == 8) {
			grid[y][x].delete();
			grid[y+1][x].delete();
			grid[y+2][x].delete();
		}
		else if(direction == 9) {
			grid[y][x].delete();
			grid[y+1][x+1].delete();
			grid[y+2][x+2].delete();
		}
	}
}
