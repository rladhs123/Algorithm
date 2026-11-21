package leet;

public class Q20261121 {

    public int largestAltitude(int[] gain) {
        int[] arr = new int[gain.length + 1];

        for (int i = 0; i < gain.length; i++) {
            arr[i + 1] = arr[i] + gain[i];
        }

        int max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}
