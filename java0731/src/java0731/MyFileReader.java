package java0731;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyFileReader {

	public static void main(String[] args) throws IOException{
		Reader reader = new FileReader("C:/Temp/text/file.txt");
		
		char[] buf = new char[100];
		int readNum = reader.read(buf);
		if(readNum != -1) {
			for (char ch : buf) {
				System.out.print(ch);
			}
			System.out.println();
		}
		reader.close();
	}

}
