
public class Diamond extends Jewel {
	
	
	public Diamond(int xCoordinate, int yCoordinate,String symbol) {
		super(xCoordinate, yCoordinate, symbol);	
	}
	
	// Calls the methods from Jewel class. First looks for matching in given directions(for diamond: 1,9,3,7).
	// If the matching returns true then calls the 'pop' method to pop the Jewels in the same direction.
	public static void dPop(int x ,int y, Jewel[][] grid) {
		
		if(Jewel.matching(x, y, 1, grid)) {
			Jewel.pop(x, y, 1, grid);
		}
		else if(Jewel.matching(x, y, 9, grid)) {
			Jewel.pop(x, y, 9, grid);
		}
		else if(Jewel.matching(x, y, 3, grid)) {
			Jewel.pop(x, y, 3, grid);
		}
		else if(Jewel.matching(x, y, 7, grid)) {
			Jewel.pop(x, y, 7, grid);
		}
	}
}
