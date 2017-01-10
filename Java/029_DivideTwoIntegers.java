package leetCode;

public class DividTwoInt {
	
	public int divide(int divident, int divisior) {
		
		if(divisior == 0 || (divident == Integer.MIN_VALUE && divisior == -1)) {
			return Integer.MAX_VALUE;
		}
		int sign = ((divident < 0) ^ (divisior < 0)) ? -1 : 1;
		if(divisior == 1) return divident;
		if(divisior == -1) return -divident;
		
		long a = divident;
		a = Math.abs(a);
		long b = divisior;
		b = Math.abs(b);
		int res = 0;
		while(a >= b) {
			long temp = b, multipal = 1;
			while(a >= (temp << 1)) {
				temp <<= 1;
				multipal <<= 1;
			}
			a -= temp;
			res += multipal;
		}
		return sign == 1? res : -res;
	}
	
	
	public static void main(String[] args) {
		int a = 70;
		int b = 2;
		DividTwoInt d = new DividTwoInt();
		int res = d.divide(a, b);
		System.out.println(res);
	}
}
