import java.util.*;

public class BrainLuck {
	
	final int MAX = 255;
	final int MIN = 0;
	
	String code;
	int prt; // data pointer
	byte memory [] = new byte[MAX];;

    public BrainLuck(String code) {
		this.code = code;
		prt = 0;
    }

    public String process(String input) {
	 	String output = "";

		System.out.println(input);
		output = goProcces(input);
		
		return output;
    }
	
	public void inCrementPointer() {
		if (prt == MAX - 1) {
			prt = 0;
		} else {
			prt++;
		}
	}
	
	public void deCrementPointer() {
		if (prt == 0) {
			prt = MAX - 1;
		} else {
			prt--;
		}
	}
	
	public String goProcces(String s) {
		//ArrayList <String> codes = new ArrayList<>(Arrays.asList(code.split("")));
		StringBuilder output = new StringBuilder("");
		int sInt = 0; //index pointer
		//Iterator<String> iter = codes.iterator();
		int c = 0;
		
		for (int i = 0; i < code.length(); i++){
			
			if (code.charAt(i) == '+') {
				//memory[prt]++;
				deCrementPointer();
			} else if (code.charAt(i) == '-') {
				//memory[prt]--;
				inCrementPointer();
			} else if (code.charAt(i) == '.') {
				output.append((char)(memory[prt]));
				memory[prt] = 0;
				sInt++;
			} else if (code.charAt(i) == ',') {
				
				System.out.println("sInt " + sInt);
				
				memory[prt] = (byte)(s.charAt(sInt));
				
			} else if (code.charAt(i) == '<') {
				deCrementPointer();
				
			} else if (code.charAt(i) == '>') {
				inCrementPointer();
				
			} else if (code.charAt(i) == '[') {
				
				if (memory[prt] == 0) {
					
					i++;
					while (c > 0 || code.charAt(i) != ']') {
						if (code.charAt(i) == '[') {
							c++;
						} else if (code.charAt(i) == ']'){
							c--;
						}
						i++;
					}
				} else {
					int num = code.substring(0, (i - 1)).length();
					i = num + code.substring((i - 1)).indexOf(']');
				}
				
			} else if (code.charAt(i) == ']') {
				
				if (memory[prt] != 0) {
					i--;
					while (c > 0 || code.charAt(i) != '[') {
						if (code.charAt(i) == ']') {
							c++;
						} else if (code.charAt(i) == '['){
							c--;
						}
						i--;
					}
				} else {
					int num = code.substring(0, (i + 1)).length();
					i = num + code.substring((i + 1)).indexOf('[');
				}
			} 
			System.out.println(memory[prt]);
			
		}
		
		
		return output.toString();
	}
	
	public static void main(String [] args) {
		final int[] input = {8, 9};

		
		System.out.println(String.valueOf("Ответ: "  + new BrainLuck(",,,-.").process("Codewars")));
		
	}	
}