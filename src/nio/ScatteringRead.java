package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatteringRead {


	public static void main(String[] args) {

		try {
			RandomAccessFile aFile = new RandomAccessFile("res/nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			ByteBuffer header = ByteBuffer.allocate(10);
			ByteBuffer body   = ByteBuffer.allocate(10);

			ByteBuffer[] bufferArray = { header, body };
			
			
			// LEGGE E DIVIDE SUI DUE BUFFER HEADER E BODY PER RISPETTIVAMENTE 8 E 16 BYTE
			
			// RICORDATI CHE LEGGE ANCHE I CARATTERI \n\r  VALIDI 1 BYTE CADUNO...
			long bytesRead = inChannel.read(bufferArray);
			while (bytesRead != -1) {

				// SOMMA TUTTI I BYTE LETTI...
				System.out.println("Read " + bytesRead);
				
				bufferArray[0].flip();
				bufferArray[1].flip();

				while (bufferArray[0].hasRemaining()) {
					System.out.print((char) bufferArray[0].get());
				}
				while (bufferArray[1].hasRemaining()) {
					System.out.print((char) bufferArray[1].get());
				}

				bufferArray[0].clear();
				bufferArray[1].clear();
				
				bytesRead = inChannel.read(bufferArray);
				
			}
			aFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
