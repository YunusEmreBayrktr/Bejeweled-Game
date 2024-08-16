import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Player implements Comparable<Player>{
	
	String name;
	int score;
	int totalScore;
	
	public Player(String name, int totalScore) {
		this.name = name;
		this.totalScore = totalScore;		
	}
	
	//This method calculates the score of the player. Loops through each cell to find the popped jewels.
	//Then according to their class adds the related point to player's score.
	//Also subtracts last score from recent score to find the score of the last round.
	public void score(Jewel[][] grid) {
		
		int lastScore = 0;
		
		for(Jewel[] i : grid) {
			for(Jewel j : i) {
				if(j.notPopped == false) {
					if(j instanceof Diamond) {
						lastScore += 30;
					}
					else if(j instanceof Square) {
						lastScore += 15;
					}
					else if(j instanceof Triangle) {
						lastScore += 15;
					}
					else if (j instanceof Wildcard) {
						lastScore += 10;	
					}
					else if (j instanceof MathSymbol) {
						lastScore += 20;
					}
				}
			}
		}
		this.score = lastScore - this.totalScore;
		this.totalScore = lastScore;
	}
	
	//This method calculates and returns the rank of the player as a String.
	public String rank(ArrayList<Player> leaderboard) {
		String print = "";
		leaderboard.add(this);
		Collections.sort(leaderboard);
		for(int i=0; i<leaderboard.size(); i++) {
			if(leaderboard.get(i) == this && i != (leaderboard.size()-1) && i != 0) {
				print = "Your rank is "+ (i+1) +"/"+ (leaderboard.size())+", your score is " 
						+ (leaderboard.get(i-1).totalScore-this.totalScore)+ " points lower than "+
						leaderboard.get(i-1).name +" and "
						+ (this.totalScore-leaderboard.get(i+1).totalScore)+" points higher than "+
						leaderboard.get(i+1).name + "\n\nGood bye!";
			}
			else if(leaderboard.get(i)==this && i==(leaderboard.size()-1)) {
				print = "Your rank is "+ (i+1) +"/"+ (leaderboard.size())+", your score is " 
						+ (leaderboard.get(i-1).totalScore-this.totalScore)+ " points lower than "+
						leaderboard.get(i-1).name + "\n\nGood bye!";
			}
			else if(leaderboard.get(i)==this && i==0) {
				print = "Your rank is "+ (i+1) +"/"+ (leaderboard.size())+", your score is "
						+ (this.totalScore-leaderboard.get(i+1).totalScore)+" points higher than "+
						leaderboard.get(i+1).name + "\n\nGood bye!";
			}
		}
		return print;
	}
	
	//This method is used to write the recent leaderboard.txt
	public static void writeLeaderboard(ArrayList<Player> leaderboard) {
		
		try {
			File fl = new File("leaderboard.txt");
			FileWriter writer = new FileWriter(fl);
			
			for (Player p : leaderboard) {
				writer.write(p.name+" "+p.totalScore+"\n");
			}
			writer.close();
		}
		catch(IOException e) {		
		}
	}

	@Override
	public int compareTo(Player o) {
		
		if(this.totalScore > o.totalScore) {
			return -1;
		}
		else {
			return 1;
		}	
	}
}
