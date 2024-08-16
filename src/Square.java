
public class Square extends Jewel{
	

	public Square(int xCoordinate, int yCoordinate, String symbol) {
		super(xCoordinate, yCoordinate, symbol);
	}
	
	// Calls the methods from Jewel class. First looks for matching in given directions(for square: 4,6).
	// If the matching returns true then calls the 'pop' method to pop the Jewels in the same direction.
	public static void sPop(int x ,int y, Jewel[][] grid) {
		
		if(Jewel.matching(x, y, 4, grid)) {
			Jewel.pop(x, y, 4, grid);
		}
		else if(Jewel.matching(x, y, 6, grid)) {
			Jewel.pop(x, y, 6, grid);
		}
	}
}
