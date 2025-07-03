package mathematics;

import java.util.Scanner;

public class Q11050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = K;
        int a = 1;
        int b = 1;

        for (int i = 0; i < M; i++) {
            a *= N;
            N--;
            b *= K;
            K--;
        }

        System.out.println(a / b);
    }
}
