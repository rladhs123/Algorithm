package mathematics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();

            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        Arrays.sort(array);

        sb.append(getAverage(array)).append('\n');
        sb.append(getMidValue(array)).append('\n');
        sb.append(getMaxCountValue(map)).append('\n');
        sb.append(getScope(array)).append('\n');

        System.out.print(sb);
    }

    static int getAverage(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return Math.round((float) sum / array.length);
    }

    static int getMidValue(int[] array) {
        return array[(array.length - 1) / 2];
    }

    static int getMaxCountValue(Map<Integer, Integer> map) {
        int[] countArray = new int[map.size()];
        int index = 0;
        for (Integer i : map.keySet()) {
            countArray[index] = i;
            index++;
        }

        Arrays.sort(countArray);

        int max = -1;
        int maxIndex = -1;
        boolean check = false;

        for (int i = 0; i < countArray.length; i++) {
            int curr = map.get(countArray[i]);

            if (curr > max) {
                max = curr;
                maxIndex = i;
                check = true;
            } else if (curr == max && check) {
                maxIndex = i;
                check = false;
            }
        }

        return countArray[maxIndex];
    }

    static int getScope(int[] array) {
        return array[array.length - 1] - array[0];
    }
}
