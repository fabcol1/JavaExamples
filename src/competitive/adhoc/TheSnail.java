package competitive.adhoc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/////////////// UVa NUMERO: 573 https://uva.onlinejudge.org/external/5/573.pdf
public class TheSnail {
	public static void main(String[] args) throws UnsupportedEncodingException {
		InputStream inputData;

		String data = "2 2 2 20\r\n" + 
				"8 6 5 30\r\n" + 
				"97 56 3 10\r\n" + 
				"56 3 1 5\r\n" + 
				"85 26 19 10\r\n" + 
				"59 17 13 11\r\n" + 
				"97 73 23 17\r\n" + 
				"0 0 0 0";

		inputData = new ByteArrayInputStream(data.getBytes("UTF-8"));

		InputStream old = System.in;

		System.setIn(inputData);

		Scanner sc = new Scanner(System.in);

		int[] values = new int[4];

		while (sc.hasNextLine()) {

			values = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			if (values[0] == 0) {
				break;
			}

			// values[0] == H WELL HIGHT
			// values[1] == U UP SPEED
			// values[2] == D DOWN SPEED
			// values[3] == F FATIGUE %

			float trip = 0;
			int days = 0;
			float down = values[2];

			float up = values[1];

			float fatigue = Math.abs(percentage(values[1], values[3]));
			// System.out.println("0 - day: "+days+" dist: " +up +" hday: " + trip + "
			// hnight: " + (trip - down));

			boolean success = false;
			//
			int i = 1;
			do {
				days++;
				trip = day(trip, up);

				float day = trip;

				if (trip > values[0]) {
					success = true;
					break;
				}
				trip = night(trip, down);
				float night = trip;
//				System.out.println(i++ + " - day: " + days + " dist: " + up + " hday: " + day + " hnight: " + night
//									+ " up: " + up);

				up -= fatigue;
				if (up < 0) { // ERRORE CHE FACEVO: UP NON PUò ESSERE POSITIVA PERCHè VUOL DIRE CHE DURANTE IL
								// GIORNO SCENDE.... SBAGLIATO!!!!
					up = 0;
				}

			} while (trip >= 0);
			//
			if (success) {
				System.out.println("success on day " + days);
			} else {
				System.out.println("failure on day " + days);
			}

		}

		sc.close();
		System.setIn(old);
	}

	public static float day(float trip, float up) {
		return trip + up;
	}

	public static float night(float trip, float down) {
		return trip - down;
	}

	public static float percentage(float h, float fatigue) {
		return h * fatigue / 100f;
	}
}
