import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class GameBoard {

	private int x;
	private int y;
	private int n;
	private char[][] board;
	final char ON = '#';
	final char OFF = '.';

	public GameBoard(int x, int y, int n){
		this.x = x;
		this.y = y;
		this.n = n;
		this.board = new char[x][y];
	}
	
	public void playGame(){
		for(int i = 0; i < n ; i++){
			propogate();
		}
	}

	public String getStartingStringFromFile(String src){
		String line;
		String fileContents = "";
		try{
			File file = new File(src);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while( (line = reader.readLine())!= null){
				fileContents+=line;
			}
			reader.close();
			return fileContents;
		}
		catch(Exception e){
			System.out.println("Error generating starting string from given source");
			System.out.println(e);
			return null;
		}
	}

	public void initializeBoard(String textRepresentationOfBoard){

		int position = 0;
		for(int i = 0 ; i < x ; i++){
			for(int j = 0 ; j < y ; j++){
				board[i][j] = textRepresentationOfBoard.charAt(position);
				position++;
			}
		}
	}


	public void propogate(){
		int numNeighborsYes = 0;
		boolean isOn = false;
		char[][] tempBoard = new char[x][y];
		
		for(int i = 0 ; i < x ; i++){
			for(int j = 0 ; j < y ; j++){
				
				if(board[i][j] == ON)
					isOn = true;
				numNeighborsYes=numberOfNeighbhorsOn(i, j);
				if(isOn && (numNeighborsYes > 3 || numNeighborsYes < 2)){
				tempBoard[i][j] = OFF;
				}
				if(isOn && (numNeighborsYes == 3 || numNeighborsYes == 2)){
					tempBoard[i][j] = ON;
					}
				if(!isOn && numNeighborsYes == 3){
					tempBoard[i][j] = ON;
				}
			}
		}
		board = tempBoard;
		
	}
	public int numberOfNeighbhorsOn(int i, int j){
		int numOn = 0;
		if(board[i][((j+1)%y)]==(ON))
		{
			numOn++;
		}
		if(board[i][(((j-1)+y)%y)]==(ON))
		{
			numOn++;
		}
		if(board[(i+1)%x][j]==(ON))
		{
			numOn++;
		}
		if(board[((i-1)+x)%x][j]==(ON))
		{
			numOn++;
		}
		if(board[((i-1)+x)%x][((j+1)%y)]==(ON))
		{
			numOn++;
		}
		if(board[((i-1)+x)%x][(((j-1)+y)%y)]==(ON))
		{
			numOn++;
		}
		if(board[(i+1)%x][((j+1)%y)]==(ON))
		{
			numOn++;
		}
		if(board[(i+1)%x][(((j-1)+y)%y)]==(ON))
		{
			numOn++;
		}
		return numOn;
	}

	
	@Override
	public String toString() {
		String boardString = "";
		for(int i = 0 ; i < x ; i++){
			for(int j = 0 ; j < y ; j++){
				boardString+=board[i][j];
			}
		boardString+="\n";
		}
		return boardString;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}



}
