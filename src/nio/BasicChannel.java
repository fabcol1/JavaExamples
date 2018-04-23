package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicChannel {

	public static void main(String[] args) {

		try {
			RandomAccessFile aFile = new RandomAccessFile("res/nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			ByteBuffer buf = ByteBuffer.allocate(48);

			// LEGGE 48 BYTE ALLA VOLTA ....
			// UN CARATTERE UTF-8 E' CODIFICATO CON 8 BIT = 1 BYTE...
			// QUINDI LEGGE 48 CARATTERI ALLA VOLTA....
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {

				System.out.println("Read " + bytesRead);
				
				// FLIP FROM READ TO WRITE !!!
				buf.flip();

				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}

				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
