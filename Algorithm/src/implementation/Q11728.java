package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Q11728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] array = new int[x + y];

        for (int i = 0; i < x + y; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < x + y; i++) {
            sb.append(array[i]).append(' ');
        }

        System.out.println(sb);
    }
}
