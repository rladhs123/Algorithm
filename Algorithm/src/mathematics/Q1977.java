package mathematics;

import java.util.Scanner;

public class Q1977 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int min = 0;
        int sum = 0;
        boolean check = false;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (i * i >= m && i * i <= n) {
                sum += i*i;

                if (!check) {
                    min = i*i;
                }

                check = true;
            }
        }

        if (check) {
            System.out.println(sum + "\n" + min);
        } else {
            System.out.println(-1);
        }
    }
}
