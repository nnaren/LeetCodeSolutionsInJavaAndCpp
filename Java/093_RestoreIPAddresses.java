public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for (int a = 1; a <= 3; a++)
        for (int b = 1; b <= 3; b++)
        for (int c = 1; c <= 3; c++) {
            int d = len - a - b - c;
            if (d > 0 && d <= 3 && a+b+c+d == s.length()) {
                StringBuilder sb = new StringBuilder();
                int A = Integer.parseInt(s.substring(0, a));
                int B = Integer.parseInt(s.substring(a, a+b));
                int C = Integer.parseInt(s.substring(a+b, a+b+c));
                int D = Integer.parseInt(s.substring(a+b+c));
                if (A > 255 || B > 255 || C > 255 || D > 255) continue;
                sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                if(sb.length() == len + 3)
                    res.add(sb.toString());
            }
        }
        return res;
    }
}
