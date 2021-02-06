package BAD;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static BAD.overallBuoyancy.convertToData;
import static BAD.overallBuoyancy.readLinesFromFile;

/*
* This code determines the change required in the centre of buoyancy based on the values of θ, θ', and θ"
* These values are inputted using a CSV
* */

public class centreOfBuoyancy {

		public static void main(String[] args) throws IOException{

			//copy the values from the CSV to four different arraylists - one for each column

			//first declare the four arraylists
			ArrayList<Double> thetaList = new ArrayList<>();
			ArrayList<Double> deltaTList = new ArrayList<>();
			ArrayList<Double> accList = new ArrayList<>();
			//ArrayList<Double> depthList = new ArrayList<>();

			double theta, deltaT, acceleration;
			String filePath = "C:\\Users\\cxson\\OneDrive\\Desktop\\Documents\\SUBC\\BAD\\src\\main\\java\\BADtesting\\badTest.csv";
			File file = new File(filePath);

			//read from file
			Scanner inputStream;
			{
				try {
					inputStream = new Scanner(file);
					String data = inputStream.next(); //ignore first line
					while(inputStream.hasNext()){
						data = inputStream.next(); //data is the entire line
						String[] values = data.split(",");
						thetaList.add(Double.parseDouble(values[0]));
						deltaTList.add(Double.parseDouble(values[1]));
						accList.add(Double.parseDouble(values[2]));
						//depthList.add(Double.parseDouble(values[3]));

						System.out.println(values[0]); //this means get all the values in the 3rd column
					}
					inputStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

			for(int i = 0; i < thetaList.size(); i++) {

				theta = thetaList.get(i);
				deltaT = deltaTList.get(i);
				acceleration = accList.get(i);

				int instruction = 0;
				int R = 0;
				int L = 1;
				int updated;

				/*
				encoding that gives the signs of the three parameters
				Add nothing if any of the parameters = 0
				1 = positive
				2 = negative
				*/
				int code = 0;

				if (theta > 0.0)
					code += 100;
				else if (theta < 0.0)
					code += 200;

				if (deltaT > 0.0)
					code += 10;
				else if (deltaT < 0.0)
					code += 20;

				if (acceleration > 0.0)
					code += 1;
				else if (acceleration < 0.0)
					code += 2;

				switch (code) {
					//Case 1
					case 111:
						instruction = L * 10 + 3;
						break;
					//Case 3, 12
					case 112:
					case 100:
					case 10:
						instruction = L * 10 + 2;
						break;
					//Case 7
					case 221:
						instruction = R * 10 + 3;
						break;
					//Case 8, 11, 13
					case 222:
					case 200:
					case 20:
						instruction = R * 10 + 2;
						break;
					//Case 2, 4
					case 121:
					case 122:
						updated = check(instruction, theta, deltaT, acceleration);
						if (updated >= 200 || updated < 100) {
							if (code == 121)
								instruction = R * 10 + 1;
							else
								instruction = R * 10 + 2;
						} else
							instruction = L * 10 + 1;
						break;
					//Case 5, 6 **MAY NEED CHANGING
					case 211:
					case 212:
						updated = check(instruction, theta, deltaT, acceleration);
						if (updated < 200)
							if (code == 212)
								instruction = L * 10 + 1;
							else
								instruction = L * 10 + 2;
						else
							instruction = R * 10 + 1;
						break;
					//Case 9
					default:
						instruction = 0;
				}
				returnFunc(instruction);
			}
		}

		public static int check(int currInstr, double prevTheta, double prevDelta, double prevAcc)	{
			/*
			 * Comparison legend (new value is ________ prev value):
			 *   equal = 0
			 *   greater than = 1
			 *   less than = 2
			 */

			int returnCode = 0;

			//Essentially, get updated input values
			Scanner input = new Scanner(System.in);
			double theta, deltaT, acceleration;
			System.out.println("Enter theta: ");
			theta = input.nextDouble();
			System.out.println("Enter change in angle (deltaT): ");
			deltaT = input.nextDouble();
			System.out.println("Enter acceleration: ");
			acceleration = input.nextDouble();

			if(theta>prevTheta)
				returnCode += 100;
			else if(theta<prevTheta)
				returnCode += 200;

			if(deltaT>prevDelta)
				returnCode += 10;
			else if (deltaT<prevDelta)
				returnCode += 20;

			if(acceleration>prevAcc)
				returnCode += 1;
			else if (acceleration<prevAcc)
				returnCode +=2;

			return returnCode;
		}

		public static int returnFunc(int instruction){
			System.out.println("Instruction "+ instruction);
			return instruction;
		}
}
