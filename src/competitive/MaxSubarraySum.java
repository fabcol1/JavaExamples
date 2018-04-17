package competitive;

public class MaxSubarraySum {

	
	public static void main(String[] args) {
		System.out.println(complexity_O1(new int[] {-1, 2, 4, -3, 5, 2, -5, 2}));
	}
	
	///////////////////////////////////
	// FIND MAX SUBARRAY SUM ....
	// -1 2 4 -3 5 2 -5 2
	// ---> SOLUTION: -----> 2 4 -3 5 2
	
	private static int complexity_O3(int[] inputArray) {
		int best = 0;
		for(int i = 0; i < inputArray.length; i++) {
			for(int j = i; j < inputArray.length; j++) {
				int sum = 0;
				for(int h = i; h <= j; h++) {
					sum += inputArray[h];
				}
				System.out.println("i=" + i + "sum: " + sum);
				best = Math.max(best, sum);
			}
		}
		return best;		
	}
	
	// -1 2 4 -3 5 2 -5 2
	private static int complexity_O2(int[] inputArray) {
		int best = 0;
		for(int i = 0; i < inputArray.length; i++) {
			int sum = 0;
			for(int j = i; j < inputArray.length; j++) {
				sum += inputArray[j];
				System.out.println("i=" + i + "sum: " + sum);
				best = Math.max(best, sum);
			}
		}
		return best;		
	}

	// -1 2 4 -3 5 2 -5 2
	// -1 
	// -1 2 -> 2
	// 2 4 -> 2 4
	// 6 -3 -> 6
	// massimo subarray relativo vs nuovo valore...
	private static int complexity_O1(int[] inputArray) {
		int best = 0;
		int sum = 0;
		for(int i = 0; i < inputArray.length; i++) {
			System.out.print("i="+i +" max("+inputArray[i]+", "
					+ ( sum+","+inputArray[i]) +")");
			sum = Math.max(inputArray[i], sum+inputArray[i]);
			best = Math.max(best, sum);
			System.out.println(" sum="+sum + " best=" + best); 
		}
		return best;		
	}

}
