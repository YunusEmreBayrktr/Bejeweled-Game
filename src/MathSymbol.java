
public class MathSymbol extends Jewel{

	
	public MathSymbol(int xCoordinate, int yCoordinate, String symbol) {
		super(xCoordinate, yCoordinate, symbol);
	}
	
	//First looks for the selected jewel to determine the directions.
	//Then calls the 'matching' method for related directions.
	//If the matching returns true then calls the 'pop' method to pop the Jewels in the same direction.
	public static void mPop(int x, int y, Jewel[][] grid) {
		
		if(grid[y][x].symbol.equals("/")) {
			if(Jewel.matching(x, y, 3, grid)) {
				Jewel.pop(x, y, 3, grid);
			}
			else if(Jewel.matching(x, y, 7, grid)) {
				Jewel.pop(x, y, 7, grid);
			}	
		}	
		else if (grid[y][x].symbol.equals("-")) {
			if(Jewel.matching(x, y, 4, grid)) {
				Jewel.pop(x, y, 4, grid);
			}
			else if(Jewel.matching(x, y, 6, grid)) {
				Jewel.pop(x, y, 6, grid);
			}	
		}
		else if (grid[y][x].symbol.equals("+")) {
			if(Jewel.matching(x, y, 4, grid)) {
				Jewel.pop(x, y, 4, grid);
			}
			else if(Jewel.matching(x, y, 6, grid)) {
				Jewel.pop(x, y, 6, grid);
			}
			if(Jewel.matching(x, y, 2, grid)) {
				Jewel.pop(x, y, 2, grid);
			}
			else if(Jewel.matching(x, y, 8, grid)) {
				Jewel.pop(x, y, 8, grid);
			}
		}
		else if (grid[y][x].symbol.equals("\\")) {
			if(Jewel.matching(x, y, 1, grid)) {
				Jewel.pop(x, y, 1, grid);
			}
			else if(Jewel.matching(x, y, 9, grid)) {
				Jewel.pop(x, y, 9, grid);
			}	
		}
		else if (grid[y][x].symbol.equals("|")) {
			if(Jewel.matching(x, y,2, grid)) {
				Jewel.pop(x, y, 2, grid);
			}
			else if(Jewel.matching(x, y, 8, grid)) {
				Jewel.pop(x, y, 8, grid);
			}	
		}	
	}
}
