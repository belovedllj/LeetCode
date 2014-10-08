package Implementation;

public class ReverseInteger {
    public int reverse(int x) {   
        int res = 0;  
        while(x != 0) {
            if(x > 0 && res > (Integer.MAX_VALUE - x % 10) / 10)
                return Integer.MAX_VALUE;
            if(x < 0 && res < Integer.MIN_VALUE / 10 - x % 10 / 10)
                return Integer.MIN_VALUE;
            res = res * 10 + x % 10;  
            x /= 10;  
        }  
        return res;
    }
}
