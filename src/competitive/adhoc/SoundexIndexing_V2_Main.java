package competitive.adhoc;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SoundexIndexing_V2_Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		Map<Character, Integer> mappaChar = new HashMap<>();
		
//		AEIOUWYH -1
		
		mappaChar.put('A', -1);
		mappaChar.put('E', -1);
		mappaChar.put('I', -1);
		mappaChar.put('O', -1);
		mappaChar.put('U', -1);
		mappaChar.put('W', -1);
		mappaChar.put('Y', -1);
		mappaChar.put('H', -1);
//		BPFV 1
		mappaChar.put('B', 1);
		mappaChar.put('P', 1);
		mappaChar.put('F', 1);
		mappaChar.put('V', 1);
//		CSKGJQXZ 2
		mappaChar.put('C', 2);
		mappaChar.put('S', 2);
		mappaChar.put('K', 2);
		mappaChar.put('G', 2);
		mappaChar.put('J', 2);
		mappaChar.put('Q', 2);
		mappaChar.put('X', 2);
		mappaChar.put('Z', 2);
//		DT 3
		mappaChar.put('D', 3);
		mappaChar.put('T', 3);
//		L 4
		mappaChar.put('L', 4);
//		MN 5
		mappaChar.put('M', 5);
		mappaChar.put('N', 5);
//		R 6
		mappaChar.put('R', 6);
		
		boolean first = true;
		String inp_line_str;
		char[] inp_char;
		int lastChange;
		int newChange;
		int i;
		
		
		while (sc.hasNextLine()) {
			
			if (first) {
				System.out.format("%-9s%-25s%-4s\n", "", "NAME", "SOUNDEX CODE");
				first = false;
			}
			
			inp_line_str = sc.nextLine().trim().replaceAll("\\s+", "");

			inp_char = inp_line_str.toCharArray();

			if (inp_char == null)
				continue;

			sb.append(inp_char[0]);

			lastChange =  mappaChar.get(inp_char[0]);

			for (i = 1; i < inp_char.length; i++) {

				newChange = mappaChar.get(inp_char[i]);
				if (newChange != lastChange && newChange != -1) {
					sb.append(newChange);
				}
				lastChange = newChange;
			}

			sb.append("000\n");
			System.out.format("%-9s%-25s%-4s\n", "", inp_line_str, sb.substring(0, 4).toString().trim());
			sb.delete(0, sb.length());
		}

		System.out.format("%-19s%-13s\n", "", "END OF OUTPUT");
		sc.close();
	}
}