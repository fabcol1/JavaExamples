import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Main{
	public static void main(String[] args) throws UnsupportedEncodingException {
			Scanner sc = new Scanner(System.in);
			
			while (sc.hasNextInt()) {
				int i = sc.nextInt();
				int j = sc.nextInt();
//				if(i<=0 || j<=0 || j>=1000000 || i >=1000000) continue;
				System.out.print(i + " " + j);
				
				
				if(i>j) {
					int temp = j;
					j = i;
					i = temp;
				}
				
				int best = 0;
				for (int h = i; h <= j; h++) {
					best = Math.max(best, ricorsiveNPlusImpl(h, 1));
				}
				System.out.println(" " + best);
			}
			sc.close();
	}
	//SLOWER
	private static int ricorsiveNPlusImpl(int n, int count) {
		if(n==1) return count;
		if(n%2 != 0) n = (3*n) +1;
		else n >>= 1;
		return ricorsiveNPlusImpl(n, ++count);
	}

}
