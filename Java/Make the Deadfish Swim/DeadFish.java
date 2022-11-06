import java.util.ArrayList;

public class DeadFish {
    public static int[] parse(String data) {
		ArrayList <Integer> array = new ArrayList<Integer>();
		int number = 0;
		
		for (int i = 0; i < data.length(); i++) {
			String ch = data.split("")[i];
			
			switch (ch) {
				case "i": number++; break;
				case "d": number--; break;
				case "s": number *= number; break;
				case "o": array.add(number); break;
			}
			System.out.println(number);
		}
		
		return array.stream().mapToInt(i -> i).toArray();
    }
}
