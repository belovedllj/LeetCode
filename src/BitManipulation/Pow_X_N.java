package BitManipulation;

public class Pow_X_N {
	public double pow(double x, int n) {
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        double res = 1.0;
        if(n < 0) {
            if(x > 0 && x <= 1 / Double.MAX_VALUE)
                return Double.MAX_VALUE;
            else if(x < 0 && x >= 1 / Double.MIN_VALUE)
                return Double.MIN_VALUE;
            else
                x = 1 / x;
            if(n == Integer.MIN_VALUE) {
                res *= x;
                n++;
            }
        }
        int isNeg = 1;
        n = Math.abs(n);
        if(x < 0 && (n & 1) == 1) 
            isNeg = -1;
        x = Math.abs(x);
        while(n > 0) {
            if((n & 1) == 1) {
                if(res >= Double.MAX_VALUE / x)
                    return Double.MAX_VALUE;
                res *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return res * isNeg;
    }
}
