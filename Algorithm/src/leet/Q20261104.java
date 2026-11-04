package leet;

public class Q20261104 {

    public int minMoves(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int result = 0;

        for (int num : nums) {
            result += max - num;
        }

        return result;
    }
}
