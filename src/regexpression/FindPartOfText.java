package regexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPartOfText {

	public static void main(String[] args) {
		String stringToSearch = "Four score and seven years ago our fathers ...";

		String toFind = "score";

		Pattern p = Pattern.compile(toFind); // the pattern to search for
		Matcher m = p.matcher(stringToSearch);

		// now try to find at least one match
		if (m.find()) {
			System.out.println("Found a match: " + m.group(0));
		} else {
			System.out.println("Did not find a match");
		}
	}
}