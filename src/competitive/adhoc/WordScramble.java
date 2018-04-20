package competitive.adhoc;

import java.io.*;
import java.nio.charset.Charset;

//////////// UVA 483 ////////////////////////////////////////////
public class WordScramble {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
	
		String data = "Assure polite his really and others figure though. Day age advantages end sufficient eat expression travelling. Of on am father by agreed supply rather either. Own handsome delicate its property mistress her end appetite. Mean are sons too sold nor said. Son share three men power boy you. Now merits wonder effect garret own. \r\n" + 
				"\r\n" + 
				"Attention he extremity unwilling on otherwise. Conviction up partiality as delightful is discovered. Yet jennings resolved disposed exertion you off. Left did fond drew fat head poor. So if he into shot half many long. China fully him every fat was world grave. \r\n" + 
				"This is the problem!!!\r\n" + 
				"My email is a@aa@aaa.com@\r\n" + 
				"every dot is a . but not all dots are .s\r\n" + 
				"is it a good test case ?\r\n" + 
				"aa.bb.aa.\r\n" + 
				"a.....aaaa..a..a.a..a\r\n" + 
				"''.'sd.f'df'.df.'f.'\r\n" + 
				"...adf....fds....sdf\r\n" + 
				".,,;;,',[,;,\r\n" + 
				"\r\n" + 
				"sdfklj ,s,df, /////sdfdf\r\n" + 
				"123456 aasdf\r\n" + 
				"     568  sdf a1b2c3 :)\r\n" + 
				"i am r2d2.\r\n" + 
				"adfsaf 4-34549230 3\r\n" + 
				"adffsflkdajflkdsajflafda afdsf 9024334242342342\r\n" + 
				",.z,.czxvkjwoijeoinlkf 2890ilakjnnc\r\n" + 
				"dsakff;kdsafdafsaf adfaf";

//		String data = "I love you.\r\n" + 
//				"You love me.\r\n" + 
//				"We're a happy family.\r\n";
		
		InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
		InputStream old = System.in;

		System.setIn(testInput);
		
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();

		Charset encoding = Charset.defaultCharset();
		try (Reader reader = new InputStreamReader(System.in, encoding);
				// buffer for efficiency
				Reader buffer = new BufferedReader(reader)) {
			
			int r;
	
			while ((r = reader.read()) != -1) {
				char ch = (char) r;

				if(ch=='\n' || ch=='\r') {
					
					sb.reverse().append(ch);
					result.append(sb.toString());
					sb.delete(0, sb.length());
					
				}else if(ch==' ') {
					sb.reverse().append(ch);
					result.append(sb.toString());
					sb.delete(0, sb.length());
				} else {
					sb.append(ch);
				}
	
			}
			
			if(sb.length()>0) {
				sb.reverse();
				result.append(sb.toString());
				sb.delete(0, sb.length());
			}
			
			System.out.print(result.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setIn(old);
	}
}	