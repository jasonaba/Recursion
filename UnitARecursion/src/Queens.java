public class Queens {
    private char[][] board;
   
    public Queens(int dim) {
        board = new char[dim][dim];
        for(int i = 0; i<dim;i++)
            for(int j = 0; j<dim;j++)
                board[i][j] = '.';
    }
    public String toString() {
        String output = "";
        for(char[] crr:board) {
            for(char c:crr)
                output += c + "  ";
            output +='\n';
        }
        return output;
    }
    
    public boolean solve(int col) throws InterruptedException {
    	if(col>=board.length)//if you're trying to place a queen on the outside, then you should be done
    		return true;
    	for(int row = 0; row<board.length; row++) {//going through each column
    		if(isSafe(row, col)) {//if you can place a queen here
    			board[row][col] = 'Q';
    			System.out.println(this);
    			Thread.sleep(500);
    			if(solve(col+1))//if the next one will be the last oen 
    				return true;
    			board[row][col] = '.';
    			System.out.println(this);
    			Thread.sleep(500);
    	}
    	}
    	return false;
    }
   
    public boolean isSafe(int row, int col) {
        for(int i = col; i>=0; i--)  //scan left
            if(board[row][i]=='Q')
                return false;
        //now scan up and left
        int i = row; int j = col;
        while(i>0&&j>0) {
            i--; j--;
            if(board[i][j]=='Q')
                return false;
        }
        i = row; j = col;
        //now scan down and left
        while(i<board.length-1&&j>0) {
            i++; j--;
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    }

}