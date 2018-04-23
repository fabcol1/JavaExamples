package competitive.adhoc;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class BlowingFuses_Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);

		final int[] inp_line = new int[3];

		String[] inp_line_str;
		int[] devices;
		boolean[] operations;
		int sequenceCounter = 0;

		StringBuilder sb = new StringBuilder();

		while (sc.hasNextLine()) {
			inp_line_str = sc.nextLine().trim().replaceAll("\\s+", " ").split(" ");

			for (int i = 0; i < 3; i++) {
				inp_line[i] = Integer.parseInt(inp_line_str[i]);
			}

			if (inp_line[0] == 0 && inp_line[1] == 0 && inp_line[2] == 0) {
				break;
			}

			devices = new int[inp_line[0]];
			operations = new boolean[inp_line[0]];

			int pc = 0;
			int maxPc = 0;
			String s_temp;

			for (int i = 0; i < devices.length; i++) {
				s_temp = sc.nextLine();
				devices[i] = Integer.parseInt(s_temp);
			}

			sb.append("Sequence ").append(++sequenceCounter).append("\n");

			int nextInt;
			boolean blow = false;

			for (int i = 0; i < inp_line[1]; i++) {

				s_temp = sc.nextLine();
				nextInt = Integer.parseInt(s_temp) - 1;

				if (operations[nextInt]) {
					pc -= devices[nextInt];
					operations[nextInt] = false;
				} else {
					pc += devices[nextInt];
					operations[nextInt] = true;
				}

				if (pc > inp_line[2] && !blow) {
					sb.append("Fuse was blown.\n\n");
					blow = true;
				}

				if (pc > maxPc) {
					maxPc = pc;
				}

			}
			if (!blow) {
				sb.append("Fuse was not blown.\n").append("Maximal power consumption was ").append(maxPc)
						.append(" amperes.\n\n");
			}
		}

		System.out.print(sb.toString());
		sc.close();
	}
}