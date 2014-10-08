package Implementation;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null) 
			return false;
	    if(s.length() == 0)
	    	return true;
	    int left = 0, right = s.length() - 1;
	    while(left < right) {
	    	if(!isValid(s.charAt(left))) {  
	            left++;  
	            continue;  
	        }  
	    	if(!isValid(s.charAt(right))) {  
	            right++;  
	            continue;  
	        }
	    	if(!isSame(s.charAt(left), s.charAt(right)))  
	            return false;  
	        
	        left++;  
	        right--;  
	    }
	    return true;
	}
	
	
	
	
	
	private boolean isValid(char c) {  
	    if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')  
	        return true;  
	    return false;  
	} 
	
	private boolean isSame(char c1, char c2) {  
	    if(c1 >= 'A' && c1 <= 'Z')  
	        c1 = (char)(c1 - 'A' + 'a');  
	    if(c2 >= 'A' && c2 <= 'Z')  
	        c2 = (char)(c2 - 'A' + 'a');  
	    return c1 == c2;  
	         
	} 
}
