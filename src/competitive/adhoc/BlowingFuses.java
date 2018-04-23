package competitive.adhoc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/////////////// UVa NUMERO: 661 https://uva.onlinejudge.org/external/6/661.pdf
public class BlowingFuses {
	public static void main(String[] args) throws UnsupportedEncodingException {
		InputStream inputData;

		String data = "1 20 59\r\n" + 
				"17\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"5 8 82\r\n" + 
				"18\r\n" + 
				"20\r\n" + 
				"3\r\n" + 
				"1\r\n" + 
				"20\r\n" + 
				"2\r\n" + 
				"4\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"4\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"8 14 93\r\n" + 
				"7\r\n" + 
				"1\r\n" + 
				"20\r\n" + 
				"8\r\n" + 
				"9\r\n" + 
				"18\r\n" + 
				"10\r\n" + 
				"13\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"6\r\n" + 
				"5\r\n" + 
				"2\r\n" + 
				"5\r\n" + 
				"2\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"8\r\n" + 
				"4\r\n" + 
				"3\r\n" + 
				"7\r\n" + 
				"6\r\n" + 
				"6 5 65\r\n" + 
				"14\r\n" + 
				"11\r\n" + 
				"18\r\n" + 
				"14\r\n" + 
				"7\r\n" + 
				"2\r\n" + 
				"6\r\n" + 
				"1\r\n" + 
				"5\r\n" + 
				"1\r\n" + 
				"6\r\n" + 
				"11 20 72\r\n" + 
				"11\r\n" + 
				"10\r\n" + 
				"13\r\n" + 
				"19\r\n" + 
				"15\r\n" + 
				"9\r\n" + 
				"20\r\n" + 
				"10\r\n" + 
				"16\r\n" + 
				"12\r\n" + 
				"5\r\n" + 
				"6\r\n" + 
				"8\r\n" + 
				"3\r\n" + 
				"4\r\n" + 
				"8\r\n" + 
				"6\r\n" + 
				"10\r\n" + 
				"3\r\n" + 
				"6\r\n" + 
				"5\r\n" + 
				"2\r\n" + 
				"4\r\n" + 
				"10\r\n" + 
				"2\r\n" + 
				"5\r\n" + 
				"6\r\n" + 
				"6\r\n" + 
				"4\r\n" + 
				"2\r\n" + 
				"4\r\n" + 
				"18 7 67\r\n" + 
				"8\r\n" + 
				"2\r\n" + 
				"15\r\n" + 
				"7\r\n" + 
				"3\r\n" + 
				"2\r\n" + 
				"10\r\n" + 
				"20\r\n" + 
				"7\r\n" + 
				"8\r\n" + 
				"10\r\n" + 
				"18\r\n" + 
				"1\r\n" + 
				"16\r\n" + 
				"2\r\n" + 
				"5\r\n" + 
				"12\r\n" + 
				"11\r\n" + 
				"5\r\n" + 
				"10\r\n" + 
				"11\r\n" + 
				"12\r\n" + 
				"17\r\n" + 
				"1\r\n" + 
				"9\r\n" + 
				"4 12 18\r\n" + 
				"13\r\n" + 
				"1\r\n" + 
				"4\r\n" + 
				"20\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"12 1 4\r\n" + 
				"15\r\n" + 
				"11\r\n" + 
				"3\r\n" + 
				"14\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"11\r\n" + 
				"17\r\n" + 
				"4\r\n" + 
				"14\r\n" + 
				"10\r\n" + 
				"1\r\n" + 
				"7\r\n" + 
				"2 17 10\r\n" + 
				"3\r\n" + 
				"7\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1 10 1\r\n" + 
				"9\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"2 25 99\r\n" + 
				"9\r\n" + 
				"9\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"1 25 5\r\n" + 
				"12\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"6 24 71\r\n" + 
				"10\r\n" + 
				"10\r\n" + 
				"14\r\n" + 
				"14\r\n" + 
				"14\r\n" + 
				"15\r\n" + 
				"4\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"5\r\n" + 
				"5\r\n" + 
				"5\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"5\r\n" + 
				"5\r\n" + 
				"4\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"1\r\n" + 
				"6\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"5\r\n" + 
				"5\r\n" + 
				"20 9 60\r\n" + 
				"13\r\n" + 
				"12\r\n" + 
				"5\r\n" + 
				"8\r\n" + 
				"15\r\n" + 
				"12\r\n" + 
				"12\r\n" + 
				"10\r\n" + 
				"11\r\n" + 
				"16\r\n" + 
				"10\r\n" + 
				"19\r\n" + 
				"17\r\n" + 
				"15\r\n" + 
				"11\r\n" + 
				"9\r\n" + 
				"17\r\n" + 
				"6\r\n" + 
				"14\r\n" + 
				"5\r\n" + 
				"15\r\n" + 
				"18\r\n" + 
				"20\r\n" + 
				"18\r\n" + 
				"15\r\n" + 
				"8\r\n" + 
				"6\r\n" + 
				"5\r\n" + 
				"7\r\n" + 
				"4 6 60\r\n" + 
				"8\r\n" + 
				"1\r\n" + 
				"19\r\n" + 
				"2\r\n" + 
				"4\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"4\r\n" + 
				"4 13 19\r\n" + 
				"6\r\n" + 
				"2\r\n" + 
				"7\r\n" + 
				"11\r\n" + 
				"3\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"3\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"2\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"8 20 15\r\n" + 
				"18\r\n" + 
				"12\r\n" + 
				"18\r\n" + 
				"7\r\n" + 
				"14\r\n" + 
				"3\r\n" + 
				"3\r\n" + 
				"18\r\n" + 
				"6\r\n" + 
				"8\r\n" + 
				"8\r\n" + 
				"3\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"2\r\n" + 
				"7\r\n" + 
				"5\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"7\r\n" + 
				"4\r\n" + 
				"6\r\n" + 
				"1\r\n" + 
				"3\r\n" + 
				"5\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"7\r\n" + 
				"12 25 70\r\n" + 
				"9\r\n" + 
				"6\r\n" + 
				"19\r\n" + 
				"7\r\n" + 
				"11\r\n" + 
				"2\r\n" + 
				"1\r\n" + 
				"8\r\n" + 
				"19\r\n" + 
				"20\r\n" + 
				"3\r\n" + 
				"2\r\n" + 
				"12\r\n" + 
				"5\r\n" + 
				"11\r\n" + 
				"3\r\n" + 
				"1\r\n" + 
				"8\r\n" + 
				"9\r\n" + 
				"4\r\n" + 
				"3\r\n" + 
				"6\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"10\r\n" + 
				"8\r\n" + 
				"6\r\n" + 
				"9\r\n" + 
				"7\r\n" + 
				"12\r\n" + 
				"10\r\n" + 
				"7\r\n" + 
				"5\r\n" + 
				"4\r\n" + 
				"9\r\n" + 
				"7\r\n" + 
				"1\r\n" + 
				"1 13 64\r\n" + 
				"13\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"5 6 11\r\n" + 
				"18\r\n" + 
				"18\r\n" + 
				"5\r\n" + 
				"17\r\n" + 
				"3\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"4\r\n" + 
				"1\r\n" + 
				"1\r\n" + 
				"0 0 0";

		inputData = new ByteArrayInputStream(data.getBytes("UTF-8"));

		InputStream old = System.in;

		System.setIn(inputData);

		Scanner sc = new Scanner(System.in);
	
		final int[] inp_line = new int[3];
		
		String[] inp_line_str;
		int[] devices;
		boolean[] operations;
		int sequenceCounter = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while (sc.hasNextLine()) {
			inp_line_str = sc.nextLine().trim().replaceAll("\\s+"," ").split(" ");

//			System.out.println(Arrays.toString(inp_line_str));
			
			for(int i = 0; i < 3; i++) {
				inp_line[i] = Integer.parseInt(inp_line_str[i]);
			}
			
			if(inp_line[0] == 0 && inp_line[1] == 0 && inp_line[2] == 0) {
				break;
			}

			devices = new int[inp_line[0]];
			operations = new boolean[inp_line[0]];
			
			int pc = 0;
			int maxPc = 0;
			String s_temp;
			
			for(int i = 0; i < devices.length; i++) {
				s_temp = sc.nextLine();
				devices[i] = Integer.parseInt(s_temp);
			}

			sb.append("Sequence ").append(++sequenceCounter).append("\n");
			
			int nextInt;
			boolean blow = false;

//			System.out.println(Arrays.toString(operations));
			
			for(int i = 0; i < inp_line[1]; i++) {
				
				s_temp = sc.nextLine();
//				System.out.println(Integer.parseInt(s_temp));
				nextInt = Integer.parseInt(s_temp)-1;
				
//				System.out.println(nextInt);
				
				if(operations[nextInt]) {
					pc -= devices[nextInt];
					operations[nextInt] = false;
				} else {
					pc += devices[nextInt];
					operations[nextInt] = true;
				}

				if(pc > inp_line[2] && !blow) {
					sb.append("Fuse was blown.\n\n");
					blow = true;
				}
				
				if(pc > maxPc) {
					maxPc = pc;
				}
				
			}
			if(!blow) {
				sb.append("Fuse was not blown.\n")
					.append("Maximal power consumption was ")
					.append(maxPc)
					.append(" amperes.\n\n");
			}
		}

		System.out.print(sb.toString());
		sc.close();
		System.setIn(old);
	}
}
