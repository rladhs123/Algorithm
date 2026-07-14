package leet;

public class Q20260714 {

    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[2 * n - i - 1] = nums[i];
        }

        return arr;
    }
}
