package DP;

public class DecodeWays {
	public int numDecodings(String s) {
        // http://blog.csdn.net/linhuanmars/article/details/24570759
        if(s == null || s.length() < 1 || s.charAt(0) == '0') return 0;
        int num1 = 1, num2 = 1, num3 = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    num3 = num1;
                else
                    return 0;
            } else if (s.charAt(i) >= '7' && s.charAt(i) <= '9') {
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '2')
                    num3 = num2;
                else 
                    num3 = num1 + num2;
            } else { // 1~6
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3')
                    num3 = num2;
                else 
                    num3 = num1 + num2;
            }
            num1 = num2;
            num2 = num3;
        }
        return num2;
    }
}
