// The idea is simple. G(i) = i^ (i/2).
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}

// rescursive
public class Solution {
	public List<Integer> grayCode(int n) {
	    List<Integer> res = new LinkedList<>();
	    res.add(0);
	    for (int i = 0; i < n; i++) {
	    	int curCount = res.size();
	    	while (curCount-- > 0) {
	    		int curNum = res.get(curCount);
	    		curNum += (1 << i);
	    		res.add(curNum);
	    	}
	    }
	    return res;
	}
}

