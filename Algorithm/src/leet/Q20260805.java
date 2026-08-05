package leet;

public class Q20260805 {

    public int searchInsert(int[] nums, int target) {
        int result = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (nums[i] < target) {
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}
