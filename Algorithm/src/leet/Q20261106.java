package leet;

public class Q20261106 {

    public int minOperations(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                result++;
            }
        }

        return result;
    }
}
