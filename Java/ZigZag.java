package leetCode;

public class ZigZa {

	
	    public String convert(String s, int numRows) {
		        
		    	
		        if(numRows <= 1)
		            return s;
		        
		        char[] c = s.toCharArray();
		        int len = s.length();
		        
		        StringBuffer[] str = new StringBuffer[numRows];
		        for(int i = 0; i < numRows; i++) {
		        	str[i] = new StringBuffer();
		        }
		        
		        int step = 1, row = 0;
		        for(int i = 0; i < len; i++) {
		        	
		            str[row].append(c[i]);
		            
		            if(row == 0)
		                step = 1;
		            else if(row == numRows-1)
		                step = -1;
		                
		            row += step;     
		        }
		        
		        for(int i = 1; i < numRows; i++) {
		            str[0].append(str[i]);
		        }
		        return str[0].toString();
		    }
	    
	    public static void main(String[] args) {
	    	ZigZa z = new ZigZa();
	    	String s = "A";
	    	
	    	System.out.println(z.convert(s, 2));
	    }
}
	


