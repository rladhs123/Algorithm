package leet;

public class Q20261003 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean check = true;

            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result++;
            }
        }

        return result;
    }
}
