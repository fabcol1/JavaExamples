package nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class NIOSimpleDemo {

	public static void main(String[] args) throws IOException {
		// current directory
		Path currentDir = Paths.get("");
		System.out.println("currentDir: " + currentDir.toAbsolutePath());
		
		// load file from dir
		Path path = Paths.get("res"+ System.getProperty("file.separator")+"source.txt");
		boolean exists = Files.exists(path);
		System.out.println("exists: " + exists);
		boolean isDirectory = Files.isDirectory(path);
		System.out.println("isDirectory: " + isDirectory);
		boolean isExecutable = Files.isExecutable(path);
		System.out.println("isExecutable: " + isExecutable);
		boolean isHidden = Files.isHidden(path);
		System.out.println("isHidden: " + isHidden);
		boolean isReadable = Files.isReadable(path);
		System.out.println("isReadable: " + isReadable);
		boolean isRegularFile = Files.isRegularFile(path);
		System.out.println("isRegularFile: " + isRegularFile);
		boolean isWritable = Files.isWritable(path);
		System.out.println("isWritable: " + isWritable);
		long size = Files.size(path);
		System.out.println("size: " + size);
		
		// Copies a file
		Files.copy(Paths.get("res"+System.getProperty("file.separator")+"source.txt"),
					Paths.get("res"+System.getProperty("file.separator")+"dest.txt"),
					StandardCopyOption.REPLACE_EXISTING );
		// Reads a text file
		List<String> lines = Files.readAllLines(Paths.get("res"+System.getProperty("file.separator")+"source.txt"),
												Charset.forName("UTF-8"));
		for (String line : lines) {
		 System.out.println(line);
		}
		
		// Deletes a file
//		Files.delete(path);
		
		// save a file
		
	}

}
