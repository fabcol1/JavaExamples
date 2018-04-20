package competitive.adhoc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class MapMaker_Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {

			final int nLineeArr = sc.nextInt();
			final int nLineeRef = sc.nextInt();

			List<ArrayReference_Main> ref = new LinkedList<>(); // VERSIONE CON LINKED LIST è PIU LENTA RISPETTO A QUELLA CON ARRAYLIST

			for (int i = 0; i <= nLineeArr; i++) {
				final String s = sc.nextLine().trim().replaceAll("\\s+", " ");

				if (s != null && !s.isEmpty()) {
					final ArrayReference_Main v = ArrayReference_Main.createArrayReference_Main(s);
					ref.add(v);
				}
			}

			for (int i = 0; i < nLineeRef; i++) {
				final String s = sc.nextLine().trim().replaceAll("\\s+", " ");
				if (s != null && !s.isEmpty()) {
					String[] arr = s.split(" ");
					String name = arr[0];
					int result = 0;

					int[] vals = new int[arr.length - 1];
					for (int j = 1; j < arr.length; j++) {
						vals[j - 1] = Integer.parseInt(arr[j]);
					}

					for (ArrayReference_Main ar : ref) {
						if (ar.getName().equals(name)) {
							result = ar.calculateReference(vals);
						}
					}

					System.out.println(name + Arrays.toString(vals) + " = " + result);
				}
			}
		}
		sc.close();
	}
}

class ArrayReference_Main {

	String name;
	int base;
	int sizeByte;
	int dimD;
	int[] lowers;
	int[] uppers;
	int[] coeff;
	int coeff0;

	private ArrayReference_Main(String name, int base, int sizeByte, int dimD, int[] lowers, int[] uppers) {
		this.name = name;
		this.base = base;
		this.sizeByte = sizeByte;
		this.dimD = dimD;
		this.lowers = lowers;
		this.uppers = uppers;

		coeff = new int[dimD];
		coeff[dimD - 1] = sizeByte;

		for (int j = dimD - 2; j >= 0; j--) {
			coeff[j] = coeff[j + 1] * (uppers[j + 1] - lowers[j + 1] + 1);
		}

		// C0 = B − C1L1 − C2L2 − · · · − CDLD
		int diff = base;

		for (int j = 0; j < coeff.length; j++) {
			diff -= (coeff[j] * this.lowers[j]);
		}

		this.coeff0 = diff;
	}

	public static ArrayReference_Main createArrayReference_Main(String line) {
		String[] arr = line.split(" ");
		String name = arr[0];
		int base = Integer.parseInt(arr[1]);
		int sizeByte = Integer.parseInt(arr[2]);
		int dimD = Integer.parseInt(arr[3]);

		int[] lowers = new int[dimD];
		int[] uppers = new int[dimD];

		for (int j = 0, x = 0; j < dimD; j++, x++) {
			lowers[j] = Integer.parseInt(arr[j + x + 4]);
			uppers[j] = Integer.parseInt(arr[j + x + 5]);
		}

		return new ArrayReference_Main(name, base, sizeByte, dimD, lowers, uppers);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(name).append("\tBase: ").append(base).append("\tByte: ").append(sizeByte)
				.append("\tdimD: ").append(dimD).append("\tUp: ").append(Arrays.toString(uppers)).append("\tLw: ")
				.append(Arrays.toString(lowers)).append("\tCoeff: ").append(Arrays.toString(coeff)).append("\tC0: ")
				.append(coeff0);
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
		for (int i = 0; i < ix.length; i++) {
			somma += coeff[i] * ix[i];
		}
		return somma;
	}
}
