package DP;

public class Candy {
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1) return 0;
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1])
                nums[i] = nums[i - 1] + 1;
            else
                nums[i] = 1;
        }
        int sum = 0;
        sum += nums[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if(ratings[i] > ratings[i + 1])
                cur = nums[i + 1] + 1;
            cur = Math.max(nums[i], cur);
            nums[i] = cur;
            sum += cur;
        }
        return sum;
    }
}
