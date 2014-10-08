package Implementation;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) return "not a valid number";
        String strCoutAndSay = "";
        strCoutAndSay = "1";
        for (int cout = 2; cout <= n; cout++) {
            strCoutAndSay = coutAndSayHelper(strCoutAndSay);
        }
        return strCoutAndSay;
    }
    
    private String coutAndSayHelper(String str) {
        if (str.length() <= 0) 
            return null;
        int counter = 1;
        StringBuffer strBufForRetr = new StringBuffer();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) 
                counter++;
            else {
                strBufForRetr.append(counter);
                strBufForRetr.append(str.charAt(i - 1));
                counter = 1;
            }
        }
        strBufForRetr.append(counter);
        strBufForRetr.append(str.charAt(str.length() - 1));
        return strBufForRetr.toString();
    }
}
