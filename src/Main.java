import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {

		StringBuilder name = new StringBuilder();
		StringBuilder encoded = new StringBuilder();

		Charset encoding = Charset.defaultCharset();

		try (Reader reader = new InputStreamReader(System.in, encoding); Reader buffer = new BufferedReader(reader)) {

			int r;
			int aCapo = 0;
			boolean start = true;
			int lastChange = -1;
			int nowChange;
			// print first line
			System.out.format("%-9s%-25s%-11s\n", "", "NAME", "SOUNDEX CODE");

			while ((r = reader.read()) != -1) {
				char ch = (char) r;

				if (ch != '\n' && ch != '\r') {

					name.append(ch);

					if (start) {
						encoded.append(ch);
						start = false;
						lastChange = calculateExchange(ch);
					} else {
						nowChange = calculateExchange(ch);
						if (nowChange != lastChange && nowChange != -1) {
							encoded.append(nowChange);
						}
						lastChange = nowChange;
					}

				} else {
					if (++aCapo == 2) {
						// print
						encoded.append("000");
						System.out.format("%-9s%-25s%-4s\n", "", name.toString(),
								encoded.substring(0, 4).toString().trim());
						name.delete(0, name.length());
						encoded.delete(0, encoded.length());
						// reset
						start = true;
						aCapo = 0;
					}
				}

			}

			encoded.append("000");

			if (!start) {
				System.out.format("%-9s%-25s%-4s\n", "", name.toString(), encoded.substring(0, 4).toString().trim());
			}
			// print last line
			System.out.format("%-19s%-13s", "", "END OF OUTPUT");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int calculateExchange(char c) {
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'W' || c == 'Y' || c == 'H') {
			return -1;
		} else if (c == 'B' || c == 'P' || c == 'F' || c == 'V') {
			return 1;
		} else if (c == 'C' || c == 'S' || c == 'K' || c == 'G' || c == 'J' || c == 'Q' || c == 'X' || c == 'Z') {
			return 2;
		} else if (c == 'D' || c == 'T') {
			return 3;
		} else if (c == 'L') {
			return 4;
		} else if (c == 'M' || c == 'N') {
			return 5;
		} else if (c == 'R') {
			return 6;
		}
		return -1;
	}
}