package competitive.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class WordScramble_Main {

	public static void main(String[] args) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();

		Charset encoding = Charset.defaultCharset();
		try (Reader reader = new InputStreamReader(System.in, encoding);
				// buffer for efficiency
				Reader buffer = new BufferedReader(reader)) {

			int r;

			while ((r = reader.read()) != -1) {
				char ch = (char) r;

				if (ch == '\n' || ch == '\r') {

					sb.reverse().append(ch);
					result.append(sb.toString());
					sb.delete(0, sb.length());

				} else if (ch == ' ') {
					sb.reverse().append(ch);
					result.append(sb.toString());
					sb.delete(0, sb.length());
				} else {
					sb.append(ch);
				}

			}

			if (sb.length() > 0) {
				sb.reverse();
				result.append(sb.toString());
				sb.delete(0, sb.length());
			}

			System.out.print(result.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
