package BADtesting;

public class BADtestCode {

	public static int assignInstruction(double theta, double deltaT, double acceleration) {
		int instruction = 0;
		int R = 0;
		int L = 1;

		//"code" that gives the signs of the three parameters
		//Add nothing if any of the parameters = 0
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
			case 111: instruction = L*10 + 3;
								break;
			case 122: //TODO: continue to monitor
			case 112:
			case 100:
			case 10:
				instruction = L*10 + 2;
				break;
			case 121: //TODO: continue to monitor
			case 212: //TODO: continue to monitor
			case 211: //TODO: continue to monitor
			case 221: instruction = R*10 + 3;
								break;
			case 222:
			case 200:
			case 20:
				instruction = R*10 + 2;
				break;
			default : return instruction;
		}
		return instruction;
	}
}
