package competitive.adhoc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class TexQuotes {

	private static InputStream changeSysInputStream() {
		InputStream testInput = null;
		try {
			// CHANGE SYSTEM.IN
			
			String data = 		"Is branched in \"\"my up strictly \"remember. \"\r\n"
					+"Songs but chief has ham widow downs. Genius or so up vanity cannot. \r\n" 
					+"\'\'\'```Large do tried ``goi\"\'``\'\'ng\" about water defer by. \"Silent\" son man she wished mother. \r\n" 
					+"Distrusts allowance do knowledge eagerness assurance additions to. \r\n" 
					+"We \"\"\"\"diminution preference \"thoroughly if. \"Joy deal pain \';`392view\" much her time. Led young gay would now state.\" \r\n" 
					+"Pronounce \"we attention admitting on \"assurance of suspicion conveying. That his west quit had met \"\"till\"\". Of advantage he \r\n" 
					+"attending \"hous\"\"ehold\" at do perceived\".\" Middleton in objection \"discovery\" as agreeable. Edward thrown dining so he my around to. ";

			testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return testInput;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		InputStream old = System.in;
		try {
			System.setIn(changeSysInputStream());
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
					
		} finally {
			System.setIn(old);
		}
	} 

}
