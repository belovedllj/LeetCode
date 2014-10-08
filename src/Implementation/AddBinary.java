package Implementation;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() <= 0 || b.length() <= 0) return null;
        String longStr, shortStr;
        if (a.length() >= b.length()) {
            longStr = a; 
            shortStr = b;
        } else {
            longStr = b;
            shortStr = a;
        }
        int carry = 0;
        StringBuffer strBuf = new StringBuffer();
        int shortLen = shortStr.length() - 1;
        int longLen = longStr.length() - 1;
        // loop for short
        for (int index = 0; index <= shortLen; index++) {
            // getNumericValue(char ch)
            int curDigit = shortStr.charAt(shortLen - index) - '0' + 
                    longStr.charAt(longLen - index) - '0' + carry;
            carry = curDigit / 2;
            curDigit %= 2;
            strBuf.insert(0, curDigit);
        }
        // loop for long
        for (int index = shortLen + 1; index <= longLen; index++) {
            int curDigit = longStr.charAt(longLen - index) - '0' + carry;
            carry = curDigit / 2;
            curDigit %= 2;
            strBuf.insert(0, curDigit);           
        }
        if (carry > 0) 
            strBuf.insert(0, carry);
        return strBuf.toString();
	}
}
