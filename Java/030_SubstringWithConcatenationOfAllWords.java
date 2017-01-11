public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for	(String e : words) {
        	counts.put(e, 0);
        }
        for	(String e : words) {
        	counts.put(e, counts.get(e)+1);
        }
        
        int n = s.length(), num = words.length, len = words[0].length();
        List<Integer> res = new LinkedList<Integer>();
       
        for (int i = 0; i < n-num*len+1; i++) {
        	
        	Map<String, Integer> seen = new HashMap<String, Integer>();
        	int j = 0;
        	for (; j < num; j++) {
        		String word = s.substring(i+j*len, i+j*len+len);
        		if (counts.containsKey(word)) {
        			if (seen.containsKey(word)) {
        				seen.put(word, seen.get(word)+1);
        			} else {
        				seen.put(word, 1);
        			}
        			if (seen.get(word) > counts.get(word))
        				break;
        		} else break;
        	}
        	if (j == num) res.add(i);
        }
        return res;
	}
}
