package leet;

public class Q20261023 {

    public int minElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            String s = Integer.toString(nums[i]);

            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - '0';
            }

            nums[i] = sum;
        }

        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }
}
