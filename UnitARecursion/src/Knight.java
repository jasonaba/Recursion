public class Knight {
	int[][] board;
	static int rowMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
	static int colMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
	int stepCount;
	
	public Knight(int dim) {
		board = new int[dim][dim];
		for(int i = 0; i<dim; i++)
			for(int j = 0; j<dim;j++)
				board[i][j] = 0;
		stepCount = 0;
	}
	
	public String toString() {
		String output = "";
		for(int[] row:board) {
			for(int space:row) {
				output += space+" ";
				if(space<10)
					output+= " |";
				else
					output+="|";
			}
			output+="\n";
			for(int i = 0; i<board.length*4;i++)
				output +="-";
			output+="\n";
		}
		return output;
	}
	
	public boolean isSafe(int row, int col) {
		if(row<0||row>=board.length) 
			return false;
		
		if(col<0||col>=board.length)
			return false;
		
		return board[row][col]==0;
	}
	
	public boolean solve(int row, int col) throws InterruptedException {
		//can the knight hit another square where it is
		
		//base case
		if(stepCount==board.length*board.length) {//more than the area of the board
			return true;
		}
		for(int i= 0; i<rowMove.length; i++) {
			if(isSafe(row+rowMove[i], col+colMove[i])) {
				stepCount++;
				board[row+rowMove[i]][col+colMove[i]] = stepCount;
				System.out.println(this);
				Thread.sleep(100);
				if(solve(row+rowMove[i], col+colMove[i]))
					return true;
				board[row+rowMove[i]][col+colMove[i]] = 0;
				stepCount--;
				System.out.println(this);
				Thread.sleep(100);
			}
		}
		return false;
		
	}
	

}