
public class Triangle extends Jewel {
	

	public Triangle(int xCoordinate, int yCoordinate, String symbol) {
		super(xCoordinate, yCoordinate, symbol);
	}
	
	// Calls the methods from Jewel class. First looks for matching in given directions(for triangle: 2,8).
	// If the matching returns true then calls the 'pop' method to pop the Jewels in the same direction.
	public static void tPop(int x ,int y, Jewel[][] grid) {
		
		if(Jewel.matching(x, y, 2, grid)) {
			Jewel.pop(x, y, 2, grid);
		}
		else if(Jewel.matching(x, y, 8, grid)) {
			Jewel.pop(x, y, 8, grid);
		}
	}
}
