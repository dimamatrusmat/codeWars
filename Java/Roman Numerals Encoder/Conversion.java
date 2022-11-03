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
		
		switch (switcher) {
			1: return "I"; break;
			5: return "V"; break;
			10: return "X"; break;
			50: return "L"; break;
			100: return "C"; break;
			500: return "D"; break;
			1000: return "M"; break;
		}
		
	}
	
	public static int getSwitcher(int n, int ten, int ost) {
		
		if (ten * ost < 5 * ten) {
			return 1 * ten;
		} else {
			return 5 * ten;
		}
		
	}

    public static String solution(int n) {
		
		StringBuilder sb = new StringBuilder("");
		
		while (n != 0) {
			int ten = getTen(n, 1);
			
			int ost = n / ten;
			
			int switcher = getSwitcher();
			
			sb.append(getCode(switcher, ost));
			
			n -= ost * ten;
		}
		
		
        return "";
    }
	
	public static void main (String [] args) {
		solution(1000);
	}
}