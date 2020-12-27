package BADtesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvInputTest {

	public static void main(String[] args){
		String filePath = "C:\\Users\\cxson\\OneDrive\\Desktop\\Documents\\SUBC\\BADtesting\\src\\main\\java\\BADtesting\\badTest.csv";
		File file = new File(filePath);

		//read from file
		Scanner inputStream;
		{
			try {
				inputStream = new Scanner(file);
				while(inputStream.hasNext()){
					String data = inputStream.next(); //data is the entire line
					String[] values = data.split(",");
					System.out.println(values[2] + "***"); //this means get all the values in the 3rd column
				}
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
