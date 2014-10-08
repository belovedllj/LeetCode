package Implementation;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (length < 1) return null;
        for (int i = length - 1; i >= 0; i--) {
            int num = digits[i];
            if (num == 9) {
                if (i == 0) return oneMoreArray(length);
                else {
                    digits[i] = 0;
                    continue;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
    private int[] oneMoreArray(int length) {
        int[] oneMoreDigitArray = new int[length + 1];
        oneMoreDigitArray[0] = 1;
        return oneMoreDigitArray;
    }
}
