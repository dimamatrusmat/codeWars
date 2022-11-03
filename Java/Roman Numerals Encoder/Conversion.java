public class Conversion {
	
	public static int getTen(int n, int del) {
		
		if (n >= del) {
			if (del == 1) {
				return getTen(n, del*10)/10;
			} else {
				return getTen(n, del*10);
			}
			
		} else {
			return del;
		}
		

	}
	
	public static String getCode(int switcher, int res) {
		StringBuilder sb = new StringBuilder("");
		
		switch (switcher) {
			case 1: {sb.append("I");} break;
			case 5: {sb.append("V");} break;
			case 10: {sb.append("X");} break;
			case 50: {sb.append("L");} break;
			case 100: {sb.append("C");} break;
			case 500: {sb.append("D");} break;
			case 1000: {sb.append("M");} break;
		}
		
		return sb.toString();
	}
	
	public static int getSwitcher(int n, int ten, int ost) {
		
		if (ost > 3 && ost < 8) {
			
			return ten * 5;

		} else if (ost > 8) {
			
			return ten * 10;
		} else {
			return ten;
		}	
	}

    public static String solution(int n) {
		
		//StringBuilder sb = new StringBuilder("");
		
		//while (n != 0) {
		//	int ten = getTen(n, 1);
		//	
		//	int ost = n / ten;
		//	
		//	int switcher = getSwitcher();
		//	
		//	sb.append(getCode(switcher, ost));
		//	
		//	n -= ost * ten;
		//}
		int ten = getTen(n, 1);
	
		int ost = n / ten;
		
		System.out.println(getSwitcher(n, ten, ost));
        return "";
    }
	
	public static void main (String [] args) {
		solution(701);
	}
}