package Implementation;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // http://blog.csdn.net/fightforyourdream/article/details/17370495
		if(num1 == null || num2 == null || num1.length() < 1 || num2.length() < 1)
			return null;
        String rev1 = new StringBuffer(num1).reverse().toString();
        String rev2 = new StringBuffer(num2).reverse().toString();
        int[] result = new int[num1.length() + num2.length()];
        for(int i = 0; i < rev1.length(); i++) {
        	for(int j = 0; j < rev2.length(); j++) {
        		result[i + j] += (rev1.charAt(i) - '0') * (rev2.charAt(j) - '0');
        	}
        }
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for(int cur : result) {
        	int digit = (cur + carry) % 10;
        	carry = (cur + carry) / 10;
        	sb.insert(0, digit);
        }
        while(sb.length() > 1 && sb.charAt(0) == '0')
        	sb.deleteCharAt(0);
        return sb.toString(); 
    }
}
