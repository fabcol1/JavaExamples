package competitive.adhoc;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/////////////// UVa NUMERO: 573  https://uva.onlinejudge.org/external/5/573.pdf
public class TheSnail_Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);

		final int[] values = new int[4];

		while (sc.hasNextLine()) {

			final String[] arr = sc.nextLine().split(" ");
			final int size = arr.length;

			for (int i = 0; i < size; i++) {
				values[i] = Integer.parseInt(arr[i]);
			}

			if (values[0] == 0) {
				break;
			}

			final float down = values[2];
			final float fatigue = values[1] * values[3] / 100f;

			float trip = 0;
			int days = 0;

			float up = values[1];
			boolean success = false;

			do {
				days++;
				trip += up;

				if (trip > values[0]) {
					success = true;
					break;
				}
				trip -= down;
				up -= fatigue;
				if (up < 0) { // ERRORE CHE FACEVO: UP NON PUò ESSERE POSITIVA PERCHè VUOL DIRE CHE DURANTE IL
								// GIORNO SCENDE.... SBAGLIATO!!!!
					up = 0;
				}

			} while (trip >= 0);

			if (success) {
				System.out.println("success on day " + days);
			} else {
				System.out.println("failure on day " + days);
			}

		}
		sc.close();
	}
}
