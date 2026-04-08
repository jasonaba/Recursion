
public class ChessPuzzles {

	public static void main(String[] args) throws InterruptedException {
		/*
		Queens liz = new Queens(8);//queen elizabeth
		System.out.println(liz);
		liz.solve(0);
		System.out.println(liz);
		*/
		Knight richard = new Knight(8);
		System.out.println(richard);
		richard.board[0][0] = 1;
		richard.stepCount = 1;
		richard.solve(0, 0);
		System.out.println(richard);
	}
	
}
