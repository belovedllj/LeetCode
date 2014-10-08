package Implementation;

public class StringToInteger_atoi {
	public int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        boolean isNeg = false;
        str = str.trim();
        int i = 0;
        char firCh = str.charAt(0);
        if(firCh == '+' || firCh == '-') {
            if(firCh == '-')
                isNeg = true;
            i++;
        }
        int res = 0;
        for(; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch > '9' || ch < '0')
                break;
            int digit = ch - '0';
            if(isNeg) {
                // must be bacause -Integer.MIN_VAlUE = 2147483648 > Integer.MAX_VALUE(2147483647)
                // and digit could be 0 so must be devided first
                if(res > -((Integer.MIN_VALUE + digit) / 10))
                    return Integer.MIN_VALUE;
            } else {
                if(res > (Integer.MAX_VALUE - digit) / 10)
                    return Integer.MAX_VALUE;
            }
            res = 10 * res + digit;
        }
        return isNeg ? -res : res;
    }
}
