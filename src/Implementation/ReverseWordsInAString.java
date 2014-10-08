package Implementation;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}
		s = s.trim();
		String[] arr = s.split("\\s+");
		StringBuffer sb = new StringBuffer();
		if(arr.length == 0) return "";
		for(int i = arr.length - 1; i >= 0; i--) {
		    if(i != 0)
		        sb.append(arr[i] + " ");
		    else
		        sb.append(arr[i]);
		}
		return sb.toString();
    }
}
