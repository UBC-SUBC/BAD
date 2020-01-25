package BADtesting;
import java.sql.SQLOutput;
import java.util.Scanner;

public class BADCode {
	public class BADtestCode {

		public int assignInstruction() {
			Scanner input = new Scanner(System.in);
			double theta, deltaT, acceleration;
			System.out.println("Enter theta: ");
			theta = input.nextInt();
			System.out.println("Enter change in angle (deltaT): ");
			deltaT = input.nextInt();
			System.out.println("Enter acceleration: ");
			acceleration = input.nextInt();

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
					instruction = L*10 + 2;
					break;
				//Case 7
				case 221: instruction = R*10 + 3;
					break;
				//Case 8, 13
				case 222:
				case 200:
					instruction = R*10 + 2;
					break;
				//Case 10
				case 10:
					updated = check(instruction, theta, deltaT, acceleration);
					if(updated < 100)       //this includes the possibility where everything is equal or whenever theta is still 0
						break;
					else if(updated < 200)
						instruction = L*10 + 1;
					instruction = R*10 + 1;
					break;
				//Case 11
				case 20:
					updated = check(instruction, theta, deltaT, acceleration);
					if(updated < 100)       //this includes the possibility where everything is equal or whenever theta is still 0
						break;
					else if(updated < 200)
						instruction = R*10 + 1;
					instruction = L*10 + 1;
					break;
				//Case 2, 4 **MAY NEED CHANGING
				case 121:
				case 122:
					updated = check(instruction, theta, deltaT, acceleration);
					if(updated<200)
						instruction = L*10 + 2;
					else
						instruction += R*10 + 1;
				//Case 5, 6 **MAY NEED CHANGING
				case 211:
				case 212:
					updated = check(instruction, theta, deltaT, acceleration);
					if(updated<100 || updated>=200)
						instruction = R*10 + 2;
					else
						instruction += L*10 + 1;
					break;
				//Case 9
				default : return instruction;
			}
			return instruction;
		}
	}

	public int check(int currInstr, double prevTheta, double prevDelta, double prevAcc)	{

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
		theta = input.nextInt();
		System.out.println("Enter change in angle (deltaT): ");
		deltaT = input.nextInt();
		System.out.println("Enter acceleration: ");
		acceleration = input.nextInt();

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
}
