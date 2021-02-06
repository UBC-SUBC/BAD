package BADtesting; 

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static BADtesting.overallBuoyancy.convertToData;
import static BADtesting.overallBuoyancy.readLinesFromFile;

/*
* This code determines the change required in the centre of buoyancy based on the values of θ, θ', and θ"
* These values are inputted using a CSV
* */

public class improvedCoB{

		public static void main(String[] args) throws IOException{

			//copy the values from the CSV to four different arraylists - one for each column

			//first declare the four arraylists
			ArrayList<Double> thetaList = new ArrayList<>();
			ArrayList<Double> deltaTList = new ArrayList<>();
			ArrayList<Double> accList = new ArrayList<>();

			double theta, deltaT, acceleration;
			String filePath = "C:\\Users\\cxson\\OneDrive\\Desktop\\Documents\\SUBC\\BADtesting\\src\\main\\java\\BADtesting\\badTest.csv";
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

					//Case 7
					case 121:
						instruction = R * 10 + 1;
						break;
					
					//Case 19
					case 211:
						instruction = L * 10 + 1;
						break;

                    //Case 3, 5, 10, 11 and 12 
                    case 112: 
                    case 100: 
                    case 11: 
                    case 10: 
                    case 12: 
                        instruction = L * 10 + 2; 
                        break;

                    //Case 16, 17, 18, 23, 27
                    case 21:
                    case 20:
                    case 22:
                    case 200:
                    case 222:
                        instruction = R * 10 + 2; 
                        break;
                        
                    //Case 25 and 26
                    case 221:
                    case 220:
                        instruction = R * 10 + 3;
                        break;

					//Case 1 and 2 
                    case 111: 
                    case 110: 
                        instruction = L * 10 + 3; 
                        break; 
                    
                    //Case 14 
                    case 0: 
                        instruction = 0; 
                        break; 
                    
                    //Observe further cases (ie. Case 8, 9, 20, 21) (the blue ones)
                    default: 
                        instruction = -1; 
				}
				returnFunc(instruction);
			}
		}

		public static int check(double prevTheta, double prevDelta, double prevAcc)	{
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