package competitive.adhoc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class es_3nPlus1 {

	public static int[] stringToIntArray(String[] args) {
		int[] input = null;
		if (args.length == 1) {
			System.out.println(args[0].replaceAll("[\r\n]", " ").replaceAll("  ", " "));

			String[] s = args[0].replaceAll("[\r\n]", " ").replaceAll("  ", " ").trim().split(" ");

			System.out.println(s.length);
			System.out.println(Arrays.toString(s));
			input = new int[s.length];
			for (int i = 0; i < s.length; i++) {
				input[i] = Integer.parseInt(s[i].trim());
			}
			System.out.println(Arrays.toString(input));

		} else if (args.length > 1) {
			input = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				input[i] = Integer.parseInt(args[i].trim());
			}
			System.out.println(Arrays.toString(input));
		}
		return input;
	}

	/*
	 * input n due: print n int count = 0; if n == 1 then STOP if n è odd(dispari)
	 * -> n = 3n + 1 else n = n/2
	 * 
	 * count++ vai a due
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// CHANGE SYSTEM.IN
		String data = "1 10\r\n" + 
				"100 200\r\n" + 
				"201 210\r\n" + 
				"900 1000\r\n" +
				"1 1\r\n";
		InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
		InputStream old = System.in;
		try {
			System.setIn(testInput);

			Scanner sc = new Scanner(System.in);

			while (sc.hasNextInt()) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				if(i<=0 || j>=1_000_000) continue;
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
		} finally {
			System.setIn(old);
		}

	}
	
	private static int nPlusImpl(int n) {
		int count = 1;
		while(n!=1) {
			if (n % 2 != 0)
				n = (3 * n) + 1;
			else
				n /= 2; // n /= 2
			count++;			
		}
		return count;
	}

	private static int ricorsiveNPlusImpl(int n, int count) {
		if(n==1) return count;
		if(n%2 != 0) n = (3*n) +1;
		else n >>= 1;
		return ricorsiveNPlusImpl(n, ++count);
	}
}
