package implementation;

import java.util.Scanner;

public class Q2605 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int input = sc.nextInt();
            array[i] = i;

            for (int j = i; j > i - input; j--) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(array[i]).append(' ');
        }

        System.out.println(sb);
    }
}
