package leet;

public class Q20261107 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = nums[0];
            int minIndex = 0;

            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}
