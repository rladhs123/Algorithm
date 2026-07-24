package leet;

public class Q20260724 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n + 1];
        int result = 0;

        for (int i : nums) {
            check[i] = true;
        }

        for (int i = 0; i < n + 1; i++) {
            if (!check[i]) {
                result = i;
                break;
            }
        }

        return result;
    }
}
