package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Q5800 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= k; i++) {
            sb.append("Class ").append(i).append('\n');

            int n = sc.nextInt();
            int[] array = new int[n];

            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }

            Arrays.sort(array);
            sb.append("Max ").append(array[n - 1]).append(", ");
            sb.append("Min ").append(array[0]).append(", ");

            int maxGap = -1;

            for (int j = 0; j < n - 1; j++) {
                int gap = array[j + 1] - array[j];

                if (gap > maxGap) {
                    maxGap = gap;
                }
            }

            sb.append("Largest gap ").append(maxGap).append('\n');
        }

        System.out.println(sb);
    }
}
