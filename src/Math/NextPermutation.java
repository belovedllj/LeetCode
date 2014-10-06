package Math;

public class NextPermutation {
	public void nextPermutation(int[] num) { 
        if (num == null || num.length <= 0) return;
        int len = num.length;
        int lastVal = num[len - 1];
        int pos;
        for (pos = len - 2; pos >= 0; pos--) {
            int curVal = num[pos];
            if (curVal <  lastVal) {
                swapAndReverse(num, pos);
                return;
            } else {
                lastVal = curVal;
            }
        }
        reverse(num, 0);
    }
    
    private void swapAndReverse(int[] num, int pos) { // find the closest
        int index;
        for (index = pos; index < num.length - 1; index++) {
            if (num[index + 1] <= num[pos]) // must include "<="
                break;
        }
        swap(num, pos, index);
        reverse(num, pos + 1);
        
    }
    
    private void reverse(int[] num, int pos) {
        int start = pos;
        int end = num.length - 1;
        while (start < end) {
            swap(num, start, end);
            start++; end--;
        }
    }
    
    private void swap(int[] num, int first, int second) {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
}
