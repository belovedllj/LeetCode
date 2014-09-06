package BinarySearch;

public class SqrtX {
	public int sqrt(int x) {
	       if(x < 0) return -1;
		   int end = (int)Math.sqrt(Integer.MAX_VALUE);
		   int start = 0;
		   while(start <= end) { // must have "=="
		        int mid = (start + end) / 2;
		        int sqr = mid * mid;
		        if (sqr == x) return mid;
		        if(sqr < x)
		        	start = mid + 1;
		        else 
		        	end = mid - 1;	        	
		    }
		    return (start + end) / 2;	        
	    }
}
