package leet;

public class Q20261011 {

    public int dominantIndex(int[] nums) {
        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > max && i != maxIndex) {
                maxIndex = -1;
                break;
            }
        }

        return maxIndex;
    }
}
