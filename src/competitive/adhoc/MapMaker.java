package competitive.adhoc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/// ESERCIZIO UVA N 394 //////////////////////////////////////////////////////////////////////////////////////////
public class MapMaker {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// CHANGE SYSTEM.IN
		String data =    "    4 7\r\n" + 
				"    ONE       1500 2 2 0 3 1 5\r\n" + 
				"    TWO       2000 4 3 1 4 0 5 5 10\r\n" + 
				"    THREE     3000 1 1 1 9\r\n" + 
				"    FOUR      5000 3 4 0 4 19 22 22 32 9 12\r\n" + 
				"    ONE       2 4\r\n" + 
				"    THREE     7\r\n" + 
				"    TWO       2 0 6\r\n" + 
				"    TWO       3 3 9\r\n" + 
				"    FOUR      1 20 23 11\r\n" + 
				"    FOUR      4 21 31 9\r\n" + 
				"    THREE     8";
		
		InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
		InputStream old = System.in;
		try {
			System.setIn(testInput);

			Scanner sc = new Scanner(System.in);

			while (sc.hasNextInt()) {

				final int nLineeArr = sc.nextInt();
//				System.out.print("nLineeArr: " + nLineeArr);

				final int nLineeRef = sc.nextInt();
//				System.out.println(" nLineeRef: " + nLineeRef);

				List<ArrayReference> ref = new ArrayList<>();
				
				for (int i = 0; i <= nLineeArr; i++) {
					final String s = sc.nextLine().trim().replaceAll("\\s+"," ");
//					System.out.println(s);
					
					if(s!=null && !s.isEmpty()) {
						final ArrayReference v = ArrayReference.createArrayReference(s);
//						System.out.println(v.toString());
						ref.add(v); 
					}
					
				}
				
				for (int i = 0; i < nLineeRef; i++) {
					final String s = sc.nextLine().trim().replaceAll("\\s+"," ");
					if(s!=null && !s.isEmpty()) {
						String[] arr = s.split(" ");
						String name = arr[0];
						int result = 0;
//						System.out.println(Arrays.toString(arr));

						int[] vals = new int[arr.length-1];
						for(int j = 1; j < arr.length; j++) {
							vals[j-1] = Integer.parseInt(arr[j]);
						}
						
						for(ArrayReference ar : ref) {
							if(ar.getName().equals(name)) {
								result = ar.calculateReference(vals);
							}
						}
						
						System.out.println(name+Arrays.toString(vals)+" = "+result);
						
//						System.out.println(Arrays.toString(vals));
					} 	
				}
//				
//				System.out.println(ref.get(0).calculateReference(new int[]{2, 4}));
//				System.out.println(ref.get(2).calculateReference(new int[]{7}));
//				System.out.println(ref.get(1).calculateReference(new int[]{2, 0, 6}));
//				System.out.println(ref.get(1).calculateReference(new int[]{3, 3, 9}));
//				for(int i = 0; i < nLineeRef; i++) {
//				
//				
//				}

			}
			sc.close();
		} finally {
			System.setIn(old);
		}
	}
}

class ArrayReference {
	
	String name;
	int base;
	int sizeByte;
	int dimD;
	int[] lowers;
	int[] uppers;
	int[] coeff;
	int coeff0;
	
	private ArrayReference(String name, int base, int sizeByte, int dimD, int[] lowers, int[] uppers) {
		this.name = name;
		this.base = base;
		this.sizeByte = sizeByte;
		this.dimD = dimD;
		this.lowers = lowers;
		this.uppers = uppers;
		
		coeff = new int[dimD];
		coeff[dimD-1] = sizeByte;

		for(int j=dimD-2; j >= 0; j--) {
			coeff[j] = coeff[j+1] * (uppers[j+1] - lowers[j+1] +1);
		}
		
//		C0 = B − C1L1 − C2L2 − · · · − CDLD
		int diff = base;

		for(int j = 0; j < coeff.length; j++) {
			diff -= (coeff[j] * this.lowers[j]);
		}	
		
		this.coeff0 = diff;
	}
	
	public static ArrayReference createArrayReference(String line) {
		String[] arr = line.split(" ");
		String name = arr[0];
		int base = Integer.parseInt(arr[1]);
		int sizeByte = Integer.parseInt(arr[2]);
		int dimD = Integer.parseInt(arr[3]);
		
		int[] lowers = new int[dimD];
		int[] uppers = new int[dimD];
		
//		System.out.println(Arrays.toString(arr));
		
		for(int j = 0, x = 0; j < dimD ; j++, x++) {
			lowers[j] = Integer.parseInt(arr[j+x+4]);
			uppers[j] = Integer.parseInt(arr[j+x+5]);
		}
		
		return new ArrayReference(name, base, sizeByte, dimD, lowers, uppers);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(name).append("\tBase: ").append(base)
			.append("\tByte: ").append(sizeByte).append("\tdimD: ").append(dimD)
			.append("\tUp: ").append(Arrays.toString(uppers))
			.append("\tLw: ").append(Arrays.toString(lowers))
			.append("\tCoeff: ").append(Arrays.toString(coeff))
			.append("\tC0: ").append(coeff0);
		return sb.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int calculateReference(int[] ix) {
		int somma = coeff0;
		for(int i = 0; i < ix.length; i++) {
			somma += coeff[i]*ix[i];
		}
		return somma;
	}
	
}
