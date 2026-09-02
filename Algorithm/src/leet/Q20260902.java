package leet;

public class Q20260902 {

    public int countKDifference(int[] nums, int k) {
        int result = 0;
        int size = nums.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
