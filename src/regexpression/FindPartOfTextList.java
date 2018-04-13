package regexpression;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPartOfTextList {

	public static void main(String[] args) {
	
		String[] arraysOfStringToSearch = {"titolo1", "titolo2", "titolo3", "niente",
											"sititolosi", "abc", "provaprovaprova"};
		LinkedList<String> results = new LinkedList<>();
		
		String toFind = "titolo";
		Pattern p = Pattern.compile(toFind); // the pattern to search for
		Matcher m;
		
		for(int i = 0;  i < arraysOfStringToSearch.length; i++) {
			 m = p.matcher(arraysOfStringToSearch[i]);
			 if (m.find()) {
				System.out.println("Found a match: " + m.group(0));
				results.add(arraysOfStringToSearch[i]);
			 }
		}
		System.out.println(Arrays.toString(results.toArray()));
	}
}
