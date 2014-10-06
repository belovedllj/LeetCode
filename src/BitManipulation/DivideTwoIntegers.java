package BitManipulation;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(divisor == Integer.MIN_VALUE) {
        	if(dividend == Integer.MIN_VALUE) return 1;
        	else return 0;
        }
        int res = 0;
        if(dividend == Integer.MIN_VALUE) {
        	res++;
        	dividend += Math.abs(divisor);
        }
        int isNeg = ((dividend ^ divisor) >>> 31 == 1) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while(divisor <= (dividend >> 1)) {
        	divisor <<= 1;
        	digit++;
        }
        while(digit >= 0) {
        	if(dividend >= divisor) {
        		res += 1 << digit;
        		dividend -= divisor;
        	}
        	if(dividend == 0) break;
        	digit--;
        	divisor >>= 1;
        }
        return res * isNeg;
    }
}
