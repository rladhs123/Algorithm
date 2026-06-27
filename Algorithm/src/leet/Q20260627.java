package leet;

public class Q20260627 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                result++;
            } else {
                max = Math.max(max, result);
                result = 0;
            }
        }

        max = Math.max(max, result);

        return max;
    }
}
