package sort;

import java.util.Scanner;

public class Q2947 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
        }

        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;

                for (int j = 0; j < 5; j++) {
                    sb.append(array[j]).append(' ');
                }
                sb.append('\n');
                flag = true;
            }

            if (i == 3 && flag) {
                i = -1;
                flag = false;
            }
        }

        System.out.print(sb);
    }
}
