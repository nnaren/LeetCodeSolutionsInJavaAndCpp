package leetCode;

import java.util.HashMap;
import java.util.Map;

public class IntToRoma {

	public int romanToInt(String s) {
		Map<Character, Integer> table = new HashMap<Character, Integer>() {
			{   put('I' , 1);
				put('V' , 5);
				put('X' , 10);
				put('L' , 50);
				put('C' , 100 );
				put('D' , 500 );
				put('M' , 1000);
			}
		};
		
		int num = table.get(s.charAt(s.length()-1));
		
		for(int i = s.length()-2; i >= 0; i--) {
			
			num = table.get(s.charAt(i)) >= table.get(s.charAt(i+1)) 
				  ? num+table.get(s.charAt(i)) : num-table.get(s.charAt(i)); 
		}
		
		return num;
	}
	
	
	
	public static void main(String[] args) {
		IntToRoma i = new IntToRoma();
		String s = "MCMLXXVI";
		System.out.println(i.romanToInt(s));
	}

}


//int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//
//StringBuilder sb = new StringBuilder();
//
//for(int i=0;i<values.length;i++) {
//    while(num >= values[i]) {
//        num -= values[i];
//        sb.append(strs[i]);
//    }
//}
//return sb.toString();
//}

//public String intToRoman(int num) {
//	
//	String[][] c = {
//			{"","I","II","III","IV","V","VI","VII","VIII","IX"},
//			{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
//			{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
//			{"","M","MM","MMM"}
//			};
//	
//	String roman = new String();
//	roman += c[3][num / 1000 % 10];
//	roman += c[2][num / 100 % 10];
//	roman += c[1][num / 10 % 10];
//	roman += c[0][num % 10];
//	
//	return roman;
//}










//public int romanToInt(String s) {
//	int integer = 0;
//    String[][] c = {
//    		{"","I","II","III","IV","V","VI","VII","VIII","IX"},
//			{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
//			{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
//			{"","M","MM","MMM"}};
//    
//    for(int i = c[3].length; i > 0; i--) {
//    	if(s.startsWith(c[3][i-1])) {
//    		integer += 1000 * (i-1);
//    		s = s.substring(c[3][i-1].length(), s.length());
//    	}
//    }
//    
//    for(int i = c[2].length; i > 0; i--) {
//    	if(s.startsWith(c[2][i-1])) {
//    		integer += 100 * (i-1);
//    		s = s.substring(c[2][i-1].length(), s.length());
//    	}
//    }
//    
//    for(int i = c[1].length; i > 0; i--) {
//    	if(s.startsWith(c[1][i-1])) {
//    		integer += 10 * (i-1);
//    		s = s.substring(c[1][i-1].length(), s.length());
//    	}
//    }
//    
//    for(int i = c[0].length; i > 0; i--) {
//    	if(s.startsWith(c[0][i-1])) {
//    		integer += (i-1);
//    		s = s.substring(c[0][i-1].length(), s.length());
//    	}
//    }
//    
//    return integer;
//    
//}
