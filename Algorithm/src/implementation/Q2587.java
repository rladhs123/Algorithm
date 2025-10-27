package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Q2587 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        Arrays.sort(array);

        System.out.println(sum / 5 + "\n" + array[2]);
    }
}
