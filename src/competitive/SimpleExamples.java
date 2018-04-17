package competitive;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExamples {
	
//	1. Given a string that represents a base X number,
//	e.g. FF (base 16, Hexadecimal), convert it
//	to base Y, e.g. 255 (base 10, Decimal), 
//	2 ≤ X, Y ≤ 36. (More details in Section 5.4.2).
	private static void ex1() {
		System.out.println("ff  -> " + Integer.parseInt("FF", 16));
		System.out.println("255 -> " + Integer
								.toString(Integer.parseInt("FF", 16),
										 		16));
	}
	
//	2. Given a list of integers L of size up to 1M items,
//	determine whether a value v exists in L?
//			(More details in Section 2.2.1).
	private static void ex2() {
//		[1 << 16]; // 1 << 16 is 2^16,
		// pick the 1 and shift it for 16en positions....
		// so for write 1M that is 2^20 i need 20 shift
//		System.out.println(1<<20);
		int[] l = new int[1<<20];
		l[10213] = 4;
		Arrays.sort(l);
		System.out.println(Arrays.binarySearch(l, 4)>=0);
		System.out.println(Arrays.binarySearch(l, 2)>=0);
//		System.out.println(l.length-1 +" = " + Arrays.binarySearch(l,4));
	}
	
//	3. Given a date, determine what is the day 
//		(Monday, Tuesday, ..., Sunday) of that date?
	private static void ex3() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date.getDayOfWeek());
		
		String dateString = LocalDateTime.now().toString();
		System.out.println("String: " + dateString);
		LocalDateTime parsedDate = LocalDateTime.parse(dateString);
		System.out.println("Parsed: " + parsedDate);
	}
	
//	4. Given a long string, replace all the occurrences of a
//	character followed by two consecutive
//	digits in with “***”, e.g. S = “a70 and z72 will be replaced, 
//	but aa24 and a872 will not” will
//	be transformed to S = “*** and *** will be replaced,
//	but aa24 and a872 will not”.
	private static void ex4() {
		String s = "a70 and z72 will be replaced, but aa24 and a872 will not";
		s = s.replaceAll("\\b[a-zA-Z]{1}\\d{2}\\b", "***");
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		ex1();
		ex2();
		ex3();
		ex4();
	}
}
