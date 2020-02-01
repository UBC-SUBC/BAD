//Change the "polling" cases for what to do


package BADtesting;
import java.sql.SQLOutput;
import java.util.Scanner;

public class BADCode {
		public static void main(String[] args) {
			//public int assignInstruction() {
				Scanner input = new Scanner(System.in);
				double theta, deltaT, acceleration;

				System.out.println("Enter theta: ");
				theta = input.nextDouble();
				System.out.println("Enter change in angle (deltaT): ");
				deltaT = input.nextDouble();
				System.out.println("Enter acceleration: ");
				acceleration = input.nextDouble();

				int instruction = 0;
				int R = 0;
				int L = 1;
				int updated;

				//encoding that gives the signs of the three parameters
				//Add nothing if any of the parameters = 0
				//1 = positive
				//2 = negative
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

				switch(code){
					//Case 1
					case 111:
						instruction = L*10 + 3;
						break;
					//Case 3, 12
					case 112:
					case 100:
					case 10:
						instruction = L*10 + 2;
						break;
					//Case 7
					case 221: instruction = R*10 + 3;
						break;
					//Case 8, 11, 13
					case 222:
					case 200:
					case 20:
						instruction = R*10 + 2;
						break;
					//Case 2, 4
					case 121:
					case 122:
						updated = check(instruction, theta, deltaT, acceleration);
						if(updated>=200 || updated<100) {
							if (code == 121)
								instruction = R * 10 + 1;
							else
								instruction = R * 10 + 2;
						}else
							instruction = L*10+1;
						break;
					//Case 5, 6 **MAY NEED CHANGING
					case 211:
					case 212:
						updated = check(instruction, theta, deltaT, acceleration);
						if(updated<200)
							if(code == 212)
								instruction = L*10 + 1;
							else
								instruction = L*10 + 2;
						else
							instruction = R*10 + 1;
						break;
					//Case 9
					default : instruction = 0;
				}
				returnFunc(instruction);
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
