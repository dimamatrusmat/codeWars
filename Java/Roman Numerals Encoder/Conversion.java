import java.util.Arrays;

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
	
	public static String getEncode(int switcher) {
		
		StringBuilder sb = new StringBuilder();
		
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
	
	public static String getCode(int switcher, int dore, int ten) {
		
		String sb = getEncode(switcher);
		
		if (dore > 0) {
			for (int i = 0; i < dore; i++) {
				sb += getEncode(ten);
			}
			
		} else {
			for (int i = 0; i > dore; i--) {
				sb = getEncode(ten) + sb;
			}
		}
				
		
		return sb;
	}
	
	public static int[] getSwitcher(int n, int ten, int ost) {
		int [] ans = new int [2];
		
		if (ost > 3 && ost <= 8) {
			ans[0] = ten * 5;
			ans[1] = (ost - 5); 

		} else if (ost > 8) {
			ans[0] = ten * 10;
			ans[1] = (ost - 10); 

		} else {
			ans[0] = ten;
			ans[1] = (ost - 1);
			
		}	
		
		return ans;
	}

    public static String solution(int n) {
		
		StringBuilder sb = new StringBuilder("");
		
		while (n != 0) {
			int ten = getTen(n, 1);
			
			int ost = n / ten;
			
			int [] switchers = getSwitcher(n, ten, ost);
			int switcher = switchers[0];
			int dore = switchers[1];
			
			sb.append(getCode(switcher, dore, ten));
			
			n -= ost * ten;
		}

        return sb.toString();
    }
	
	public static void main (String [] args) {
		System.out.println(solution(89));
	}
}