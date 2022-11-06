import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WeightSort {
	
	public static int countInt(String str) {
		int ans = 0;
		
		for (int i = 0; i < str.length(); i++) {
			ans += Integer.parseInt(str.split("")[i]);	
		}
		
		return ans;
	}
	
	public static boolean getSortEqual(long a , long b) {
		boolean ans = false;
		
		String aS = String.valueOf(a);
		String bS = String.valueOf(b);
		
		int i = 0;
		
		int min = aS.length();
		
		if (min > bS.length()) {
			min = bS.length();
		}
		
		while (true) {
			if (Integer.parseInt(aS.split("")[i]) > Integer.parseInt(bS.split("")[i])) {
				return true;
			} else if (Integer.parseInt(aS.split("")[i]) == Integer.parseInt(bS.split("")[i])) {
				
				i++;
				
				if (min == i) {
					if (a > b) {
						return true;
					} else {
						break;
					}
				}					
				continue;
			} else {
				break;
			}

		}
		
		return ans;
	}
	
	public static long [] getSort(long [] oldArr, long [] newArr) {


		int idnex = newArr.length;
		int i = 0;
		
		boolean a = false;
		
		while (true) {
									
			if (newArr[i] > newArr[i+1]) {
				long a1 = oldArr[i];
				long a2 = oldArr[i+1];
				
				oldArr[i] = a2;
				oldArr[i+1] = a1;
				
				long b1 = newArr[i];
				long b2 = newArr[i+1];
				
				newArr[i] = b2;
				newArr[i+1] = b1;
				
				a = true;
			} else if (newArr[i] == newArr[i+1]) {
				
				if (oldArr[i] != 0) {
					long a1 = oldArr[i];
					long a2 = oldArr[i+1];
					
					long b1 = newArr[i];
					long b2 = newArr[i+1];
					
					if (getSortEqual(oldArr[i],oldArr[i+1])) {
											
						oldArr[i] = a2;
						oldArr[i+1] = a1;
						
						newArr[i] = b2;
						newArr[i+1] = b1;
						
						a = true;
					}
				}
			}
			
			i++;
			
			if (idnex - 1 <= i) {
				i = 0;
				
				if (a) {
					a = false;
				} else {
					break;
				}
			}	

		}
		
		
		return oldArr;
		
	}
	
	public static String orderWeight(String strng) {
		System.out.println(strng);
		String [] arrS = strng.split(" ");
		long [] arrN = new long [arrS.length];
		long [] arrO = new long [arrS.length];
		
		for (int i = 0; i < arrS.length; i++) {
			
			if (!arrS[i].isEmpty()){
				arrO[i] = Long.parseLong(arrS[i]);
				arrN[i] = countInt(arrS[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		
		if (!(arrO.length == 1)) {
		  long [] newAr = getSort(arrO, arrN);

		  for (int i = 0; i < newAr.length; i++) {
				sb.append(newAr[i]);

				if (i != newAr.length -1) {
				  sb.append(" ");
				}
		  }

		} 
		 
		 return sb.toString();
	}
	
	
	public static void main (String [] arg) {
		System.out.println(orderWeight("387087 176 351832 100 430372 8 58052 54 175432 120 269974 147 309754 91 200 404858 67 271476 164 295747 111 2 40"));
	}
	
}