package leetCode;

public class longestCommonPre {
    
//	public String longestCommonPrefix(String[] strs) {
//		if(strs.length == 0)
//			return "";
//		int minIndex = 0;
//		for(int i = 1; i < strs.length; i++) {
//			if(strs[i].length() < strs[minIndex].length()) {
//				minIndex = i;
//			}
//		}
//	
//		String pattern = strs[minIndex];
//		
//		for(int i = 0; i < strs.length; i++) {
//			String temp = strs[i].substring(0, pattern.length());
//			while(!pattern.equals(temp)) {
//				pattern = pattern.substring(0, pattern.length()-1);
//				temp = strs[i].substring(0, pattern.length());
//			}
//			
//			if(i == strs.length-1) {
//				break;
//			}
//		}
//		return pattern;
//    }
	
//	public String longestCommonPrefix(String[] strs) {
//		if(strs.length == 0)
//			return "";
//		int minIndex = 0;
//		for(int i = 1; i < strs.length; i++) {
//			if(strs[i].length() < strs[minIndex].length()) {
//				minIndex = i;
//			}
//		}
//	
//		String pattern = strs[minIndex];
//		int i = 0;
//		while(i < strs.length) {
//			String temp = strs[i].substring(0, pattern.length());
//			while(!pattern.equals(temp)) {
//				pattern = pattern.substring(0, pattern.length()-1);
//				temp = strs[i].substring(0, pattern.length());
//			}
//			
//			i++;
//		}
//		return pattern;
//    }
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		
		String pre = strs[0];
		int i = 1;
		while(i < strs.length) {
			while(strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length()-1);
			}
			i++;
		}
		return pre;
    }
	
	
	public static void main(String[] args) {
		String[] s = new String[3];
		s[0] = "flower";
		s[1] = "flow";
		s[2] = "flight";
		//s[3] = "abcdaqda";
		//String ss = "abcd"; 
		longestCommonPre l = new longestCommonPre();
		System.out.println(l.longestCommonPrefix(s));
		//System.out.println(ss != s[0]);
	}
	
}
