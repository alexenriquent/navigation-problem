import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class IO {
	
	public IO() {
		
	}
	
	public String[] readFile(String path) throws IOException {
		FileReader file = new FileReader(path);
		BufferedReader buffer = new BufferedReader(file);
		int lineCount = readLines(path);
		String lines[] = new String[lineCount];
		
		for (int i = 0; i < lineCount; i++) {
			lines[i] = buffer.readLine();
		}
		
		buffer.close();
		return lines;
	}
	
	private int readLines(String path) throws IOException {
		FileReader file = new FileReader(path);
		BufferedReader buffer = new BufferedReader(file);
		int lineCount = 0;
		
		while (buffer.readLine() != null) {
			lineCount++;
		}
		
		buffer.close();
		return lineCount;
	}
	
	public void writeLines(String path, List<String> data) throws IOException {
		FileWriter file = new FileWriter(path);
		BufferedWriter buffer = new BufferedWriter(file);
		Iterator<String> iterator = data.iterator();
		String output = "";
		
		while (iterator.hasNext()) {
			output = output.concat(iterator.next());
			output = output.concat("\n");
		}
		
		buffer.write(output.substring(0, output.length() - 1));
		
		buffer.close();
	}
}
