
public class Inception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fact(20));
		towerOfHanoi(4, 1, 3, 2);
		
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(sum(array, array.length-1));
		System.out.println(bestOfCount(5, 0, 0, ""));
		System.out.println(sumDigits(135));
	}

	public static long fib(int n) {
		if(n<=2)//axium case
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	public static long fact(int n) {
		if(n<=1)//axium case
			return 1;
		
		return n * fact(n-1);
	}
	
	public static void towerOfHanoi(int n, int from, int target, int empty) {
		if (n<=0) {
			return;
		}
		towerOfHanoi(n-1, from, empty, target);
		System.out.println("Ring " + n + "to" + target);
		towerOfHanoi(n-1, empty, target, from);
	}
	
	public static int sum(int[] arr, int i) {
		if(i < 0)//or you could flip it: if(i>=arr.length)
			return 0;
		return arr[i] + sum(arr, i-1);//when flipping it: return arr[i]+ sum(arr, i+1);
	}
	
	public static int bestOfCount(int games, int score1, int score2, String series) {
		if(score1 >= (games/2)+1 || score2 >= (games/2)+1) {
			System.out.println(series);
			return 1;
		}
		return bestOfCount(games, score1 + 1, score2, "A"+series)//checks if it is team1 which won
				+ bestOfCount(games, score1, score2+1, "B"+ series);//if team2 won
		
	}
	
	public static int sumDigits(int n) {
		if(n<10)
			return n;
		return n%10 + sumDigits(n/10);
	}
	
	public static void squareEvens(int[] arr, int index) {
		if(index+2 >= arr.length-1) {
			return;
		}
		if(arr[index]%2==0) {
			arr[index] = arr[index] * arr[index];
		}
		squareEvens(arr, index+1);
		
	}
}
