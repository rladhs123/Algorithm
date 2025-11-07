package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Q9076 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int[] array = new int[5];

            for (int j = 0; j < 5; j++) {
                array[j] = sc.nextInt();
            }

            Arrays.sort(array);

            if (array[3] - array[1] >= 4) {
                sb.append("KIN");
            } else {
                sb.append(array[1] + array[2] + array[3]);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
