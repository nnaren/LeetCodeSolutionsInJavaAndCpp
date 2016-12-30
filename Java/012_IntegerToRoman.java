package leetCode;

public class IntToRoma {

	public String intToRoman(int num) {
		
		String[][] c = {
				{"","I","II","III","IV","V","VI","VII","VIII","IX"},
				{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
				{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
				{"","M","MM","MMM"}
				};
		
		String roman = new String();
		roman += c[3][num / 1000 % 10];
		roman += c[2][num / 100 % 10];
		roman += c[1][num / 10 % 10];
		roman += c[0][num % 10];
		
		return roman;
    }
	
	public static void main(String[] args) {
		IntToRoma i = new IntToRoma();
		int num = 1984;
		System.out.println(i.intToRoman(num));
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
