import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class IO {

	private String path;
	
	public IO(String path) {
		this.path = path;
	}
	
	public String[] readFile() throws IOException {
		FileReader file = new FileReader(path);
		BufferedReader buffer = new BufferedReader(file);
		int lineCount = readLines();
		String lines[] = new String[lineCount];
		
		for (int i = 0; i < lineCount; i++) {
			lines[i] = buffer.readLine();
		}
		
		buffer.close();
		return lines;
	}
	
	int readLines() throws IOException {
		FileReader file = new FileReader(path);
		BufferedReader buffer = new BufferedReader(file);
		String line;
		int lineCount = 0;
		
		while ((line = buffer.readLine()) != null) {
			lineCount++;
		}
		
		buffer.close();
		return lineCount;
	}
}
