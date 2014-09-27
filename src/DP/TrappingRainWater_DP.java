package DP;

public class TrappingRainWater_DP {
	public int trap(int[] A) {  
	    if(A==null || A.length==0)  
	        return 0;  
	    int max = 0;  
	    int res = 0;  
	    int[] container = new int[A.length];  
	    for(int i=0;i<A.length;i++) {  
	        container[i]=max;  
	        max = Math.max(max,A[i]);  
	    }  
	    max = 0;  
	    for(int i=A.length-1;i>=0;i--) {  
	        container[i] = Math.min(max,container[i]);  
	        max = Math.max(max,A[i]);  
	        res += container[i]-A[i]>0?container[i]-A[i]:0;  
	    }      
	    return res;  
	}  
}
