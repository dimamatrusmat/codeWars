public class RgbToHex {
	
	public static int cheackInt(int a) {
		if (a < 0) {
			return 0;
		}
		
		if (a > 255) {
			return 255;
		}
		
		return a;
	}
	
	public static String getCode (int n) {
		String ans = "";
		
		if (n <= 9) {
			ans = String.valueOf(n);
		} else {
			switch (n) {
				case 10: ans = "A"; break;
				case 11: ans = "B"; break;
				case 12: ans = "C"; break;
				case 13: ans = "D"; break;
				case 14: ans = "E"; break;
				case 15: ans = "F"; break;
			}
		}
		
		return ans;
	}
	
	public static String getEncode(int a) {
		String ans = "";
		
		
		if (a <= 9 ) {
			ans = "0" + String.valueOf(a);
			
		} else {
			int ost = a % 16;
			
			while (ost <= 16) {
				int del = a / 16;
				
				ost = a % 16;
				
				ans += getCode(ost);
				
				
				a = del;
				if (a <= 16) {
					ans = getCode(a) + ans;
					break;
				} 
				
			}				
	
		}
		
		return ans;
	}

    public static String rgb(int r, int g, int b) {
        StringBuilder sb = new StringBuilder("");
		
		sb.append(getEncode(cheackInt(r)));
		sb.append(getEncode(cheackInt(g)));
		sb.append(getEncode(cheackInt(b)));
		
		return sb.toString();
    }
	
	public static void main (String [] args) {
		
		
		System.out.println(rgb(127,0,0));
	}
}
