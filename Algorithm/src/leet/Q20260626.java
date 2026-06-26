package leet;

public class Q20260626 {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int x = 0;
        int y = n;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[x];
                x++;
            } else {
                result[i] = nums[y];
                y++;
            }
        }

        return result;
    }
}
