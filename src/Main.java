import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		Charset encoding = Charset.defaultCharset();
		try (Reader reader = new InputStreamReader(System.in, encoding);
				// buffer for efficiency
				Reader buffer = new BufferedReader(reader)) {
			
			int r;
			int count=0;
			while ((r = reader.read()) != -1) {
				char ch = (char) r;
				
				if(ch=='"') {
					sb.append((count++%2==0)?"``":"''");
				} else {
					sb.append(ch);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.print(sb);
	}
}
