import java.util.Scanner;


public class Game {
	
	public static void main(String[] args){
		GameBoard board = setUpBoard();
		String boardStringRepresentation = board.getStartingStringFromFile("input.txt");
		board.initializeBoard(boardStringRepresentation);
		System.out.println(board);
	}
	public static GameBoard setUpBoard(){
		int x; //the width of the board
		int y; //the height of the board		
		int n; //the number of iterations
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter x");
		x=keyboard.nextInt();
		System.out.println("Enter y");
		y=keyboard.nextInt();
		System.out.println("Enter n");
		n=keyboard.nextInt();
		
		GameBoard board = new GameBoard(x,y,n);
		return board;
		
		
	}

}
