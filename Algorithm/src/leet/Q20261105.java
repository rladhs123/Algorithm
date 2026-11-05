package leet;

public class Q20261105 {

    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = start + 2 * i;
            result ^= arr[i];
        }

        return result;
    }
}
