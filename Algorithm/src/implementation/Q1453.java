package implementation;

import java.util.Scanner;

public class Q1453 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[101];
        int result = 0;

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            if (!check[input]) {
                check[input] = true;
            } else {
                result++;
            }
        }

        System.out.println(result);
    }
}
