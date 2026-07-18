package leet;

public class Q20260718 {

    public int minimumOperations(int[] nums) {
        int result = 0;

        for (int i : nums) {

            if ((i + 1) % 3 == 0) {
                result++;
            } else if ((i - 1) % 3 == 0) {
                result++;
            }
        }

        return result;
    }
}
