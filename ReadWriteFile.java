

import java.net.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class ReadWriteFile {
	public String[][] read(String filename) throws IOException {
		String line = null;
		String[][] ret = null;
		try {
			FileReader fileReader = new FileReader(filename);
			File File = new File(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int lnr = countLines(filename);
			System.out.println(lnr);
			int i = 0;
			String[][] abc = new String[lnr][4];
			while ((line = bufferedReader.readLine()) != null) {
				if(i>0){
				String[] elems = line.split("\\s+");
				for (int j = 0; j < 4; j++) {
					abc[i-1][j] = elems[j];
				}
				}
				i++;
			}
			bufferedReader.close();
			ret = abc;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + filename + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + filename + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return ret;
	}

	public void write(String[][] arr, String filename) {

		try {
			File file = new File(filename);
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("C PN Neigh1 Neigh2  ");
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < 4; j++) {
					printWriter.write(arr[i][j] + " ");
				}
				printWriter.write("");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int countLines(String filename) throws IOException {
	LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
	int cnt = 0;
	String lineRead = "";
	while ((lineRead = reader.readLine()) != null) {}

	cnt = reader.getLineNumber(); 
	reader.close();
	return cnt;
	}
}
