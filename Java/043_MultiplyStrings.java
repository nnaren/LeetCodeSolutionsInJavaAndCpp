//`num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

public class Solution {
    public String multiply(String num1, String num2) {
        int lenA = num1.length();
        int lenB = num2.length();
        
        int[] num3 = new int[lenA+lenB];
        for(int i = lenA-1; i >= 0; i--) {
        	for(int j = lenB-1; j >= 0; j--) {
        		int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
        		int p1 = i + j, p2 = i + j + 1;
        		int sum = mul + num3[p2];
        		
        		num3[p1] += sum / 10;
        		num3[p2] = sum % 10;
        	}
        }
        
        StringBuilder res = new StringBuilder();
        for(int n : num3) if(res.length() != 0 || n != 0) res.append(n);
        return res.length() == 0 ? "0" : res.toString();
    }
}


