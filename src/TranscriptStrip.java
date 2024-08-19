import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TranscriptStrip
{
	public static void main(String[] args) throws IOException {
		
		File readFile = new File("Interview.txt");
		Scanner inFile = new Scanner(readFile);
		inFile.useDelimiter("\n");
		
		File writeFile = new File("outFile.txt");
		FileWriter fw = new FileWriter(writeFile);
		
		String party1 = "Nicholas";
		
		int party = 0;
		
		while(inFile.hasNext()) {
			String line = inFile.next();
			
			if(!line.equals("")) {
				Scanner inLine = new Scanner(line);
				String firstWord = inLine.next();
				
				if(firstWord.equals(party1)) {
					if(party != 1) {
						fw.write("\n\n");
						fw.write(line);
						party = 1;
					}
					else {
						line = line.substring(22);
						fw.write(line);
					}
				}
				else {
					if(party != 2) {
						fw.write("\n\n");
						fw.write(line);
						party = 2;
					}
					else {
						line = line.substring(12);
						fw.write(line);
					}
				}
				inLine.close();
			}
		}
		
		inFile.close();
		fw.close();
	}
}
