package leetCode;

public class StringToNum {
	
	public int myAtoi(String str) {
		int sign = 1;
		int base = 0;
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
			sign = str.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && (str.charAt(i)-'0') > 7)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			
			base = base*10 + (str.charAt(i++)-'0');
		}
		
		return base * sign;
    }
	
	
	public static void main(String[] args) {
		
		String str = "";
		
		//StringToNum s = new StringToNum();
		System.out.println();
	}

}
