import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TestMain {

	private static InputStream changeSysInputStream() {
		InputStream testInput = null;
		try {
			// CHANGE SYSTEM.IN

			String data = "ciao prova \r\n"
					+ "ciaoooooooo";
			
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

			Scanner sc = new Scanner(System.in);
			StringBuilder sb = new StringBuilder();

			while (sc.hasNextLine()) {
				sb.append(sc.nextLine());
				// System.out.println(sb);
				sb.append("\r\n");
			}
			
			System.out.println(sb);
			sc.close();
		} finally {
			System.setIn(old);
		}
	}

}
