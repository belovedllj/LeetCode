package Implementation;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows <= 1 || s == null || s.length() < 1) return s;
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += 2*nRows-2) {
                strBuf.append(s.charAt(j));
                if (i != 0 && i != nRows-1 && j + (nRows- i - 1) * 2 < s.length())
                    strBuf.append(s.charAt(j + (nRows- i - 1) * 2));
            }
        }
        return strBuf.toString();
    }
}
