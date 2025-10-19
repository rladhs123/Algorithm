package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q25305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        System.out.println(array[n - 1 - k + 1]);
    }
}
