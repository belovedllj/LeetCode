package Implementation;

public class ValidNumber {
	public boolean isNumber(String s) {
        if(s == null) 
            return false;  
        s = s.trim();  
        if(s.length() == 0)  
            return false; 
        char[] chArr = s.toCharArray();
        boolean dotFlag = false;
        boolean eFlag = false;
        for(int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '.') { // ".1" is ture "3." is ture "-." is false
                if(dotFlag || eFlag || 
                   (i != 0 && !(chArr[i - 1] >= '0' && chArr[i - 1] <= '9' || 
                   ((chArr[i - 1] == '+' || chArr[i - 1] == '-') && i != chArr.length - 1 &&
                   chArr[i + 1] >= '0' && chArr[i + 1] <= '9'))) ||
                   (i != chArr.length - 1 && !(chArr[i + 1] >= '0' && chArr[i + 1] <= '9' || 
                   ((chArr[i + 1] == 'e' || chArr[i + 1] == 'E') && i != 0))) || chArr.length == 1) // "." is false
                    return false;
                dotFlag = true;
            } else if(chArr[i] == '+' || chArr[i] == '-') { // "+.8" is true
                if((i != 0 && chArr[i - 1] != 'e' && chArr[i - 1] != 'E') ||
                    i == chArr.length - 1 || !(chArr[i + 1] >= '0' && chArr[i + 1] <= '9' || chArr[i + 1] == '.'))
                    return false;
            } else if(chArr[i] == 'E' || chArr[i] == 'e') {
                if(i == 0 || i == chArr.length - 1 || eFlag)
                    return false;
                eFlag = true;
            } else if(chArr[i] < '0' || chArr[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
