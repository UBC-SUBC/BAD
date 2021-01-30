package BAD;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
* The idea behind how much the buoyancy should be increased/decreased is determined upon take three measurements
* from the depth sensor. For example, if we observe that the sub is moving towards the floor of the sub at an
* increasing rate, ie. the change in distance between the 2nd and 3rd points is larger than between the 1st and
* 2nd for the same time interval, then we would need to greatly increase the overall buoyancy of the sub.
* */
public class overallBuoyancy {

	static Scanner input = new Scanner(System.in);
	private static String CSV_PATH = input.next();
	public static ArrayList<String> aList = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		readLinesFromFile(CSV_PATH); //should modify aList directly
		double depth1 = 0.0, depth2 = 0.0, depth3 = 0.0;
		double delta1, delta2;
		ArrayList<Data> dataList = convertToData(aList);

		for(int i = 0; i < dataList.size(); i++){
			depth1 = dataList.get(i).getDepth();
			i++;
			depth2 = dataList.get(i).getDepth();
			i++;
			depth3 = dataList.get(i).getDepth();
		}

		delta1 = depth2 - depth1;
		delta2 = depth3 - depth2;

		int encoding = 0;
		int instruction = 0;
		int positive = 1, increase = 1;
		int negative = 2, decrease = 2;

		/*
		* Encoding:
		*   The tens digit will represent the sign of delta1 and the ones digit the sign of delta 2
		*/
		if(delta1 > 0)
			encoding += positive*10;
		else if(delta1 < 0)
			encoding += negative*10;

		if(delta2 > 0)
			encoding += positive;
		else if(delta2 < 0)
			encoding += negative;

		/*
		 * Tens digit will represent whether we should increase or decrease overall buoyancy
		 *   1 - increase
		 *   2 - decrease
		 * Ones digit will represent the magnitude
		 *   1 - a little bit
		 *   2 - a bit more
		 *   3 - a lot
		 *
		 * 0 means do nothing!
		 */

		if(delta1>delta2){
			switch(encoding){
				case 11:
				case 12:
					instruction += decrease*10 + 1;
					break;
				//Note: delta1>delta2 has a different meaning when it comes to negative numbers
				case 22:
					instruction += increase*10 + 3;
				case 21:
					instruction += increase*10 + 1;
					break;
				case 2:
					instruction += increase*10 + 2;
					break;
				//default includes case 10 where we want instruction to be 0
				default:
					instruction = 0;
			}
		}

		if(delta2>delta1){
			switch(encoding){
				case 11:
					instruction += decrease*10 + 3;
					break;
				case 12:
				case 22:
					instruction += increase*10 + 1;
					break;
				case 21:
					instruction += decrease*10 + 1;
					break;
				case 1:
					instruction += decrease*10 + 2;
					break;
				//default includes case 20 where we want instruction to be 0
				default:
					instruction = 0;
			}
		}

		if(delta1 == delta2){
			switch(encoding){
				case 11:
					instruction += decrease*10 + 2;
					break;
				case 22:
					instruction += increase*10 + 2;
					break;
				//default includes cases 11, 12 where we want instruction to be 0
				default:
					instruction = 0;
			}
		}
	}

	public static ArrayList<String> readLinesFromFile(String path) throws IOException{
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		while((line = bufferedReader.readLine()) != null){
			aList.add(line);
		}
		bufferedReader.close();
		return aList;
	}

	public static ArrayList<Data> convertToData(ArrayList<String> lineStrings){
		ArrayList<Data> data = new ArrayList<>();
		lineStrings.remove(0); //removes first line with the category names

		for(String line : lineStrings){
			String[] parts = line.split(",");
			double theta = Double.valueOf(parts[0]);
			double deltaT = Double.valueOf(parts[1]);
			double acceleration = Double.valueOf(parts[2]);
			double depth = Double.valueOf(parts[3]);
			data.add(new Data(theta, deltaT, acceleration, depth));
		}
		return data;
	}
}


