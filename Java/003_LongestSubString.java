package leetCode;

import java.util.HashMap;

public class longestSubstring {

//	public static int lengthOfLongestSubstring(String s) {
//        
//		int max = 0;
//		int templength = 0;
//		char c;
//		int i;
//		String maxSubString = "";
//		int length = s.length();
//		String jump = "";
//		
//		for (i = 0; i < length; i++) {	
//			
//			for(int j = i; j < length; j++) {
//				
//				c = s.charAt(j);
//				if(maxSubString.contains(c+"")) {
//					maxSubString = "";
//					break;
//					
//				} else {
//					maxSubString = maxSubString+c;
//					templength++;
//				}
//			}
//			max = templength > max ? templength : max;
//			templength = 0;
//		}	
//		return max;
//	}	
	
	public static int lengthOfLongestSubstring(String s) {
		
        if (s.length()==0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){

                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            int temp = i-j+1;
            max = Math.max(max,temp);
        }
        return max;
    }

	public static void main(String[] args) {
		String s = "abcddcfeg";
		System.out.println(lengthOfLongestSubstring(s));
	}
}



///*package leetCode;
//
//public class longestSubstring {
//
//	public static int lengthOfLongestSubstring(String s) {
//        
//		int max = 0;
//		int templength = 0;
//		char c;
//		int i;
//		String maxSubString = "";
//		int length = s.length();
//		String jump = "";
//		
//		for (i = 0; i < length; i+=jump.length()) {	
//			
//			for(int j = i; j < length; j++) {
//				
//				c = s.charAt(j);
//				if(maxSubString.contains(c+"")) {
//					
//					maxSubString = "";
//					break;
//					
//				} else {
//					maxSubString = maxSubString+c;
//					jump = maxSubString;
//					System.out.println(jump);
//					templength++;
//				}
//			}
//			max = templength > max ? templength : max;
//			templength = 0;
//		}	
//		return max;
//	}	
//
//	public static void main(String[] args) {
//		String s = "abcdddefghijk";
//		System.out.println(lengthOfLongestSubstring(s));
//	}
//}*/

