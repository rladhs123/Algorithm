package recursivefunction;

import java.util.Scanner;

/**
 * 하노이 탑
 */
public class Q11729 {

    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        hanoi(N, 1, 2 , 3);

        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int N, int from, int mid, int to) {
        count++;
        if (N == 1) {
            sb.append(from + " " + to).append("\n");
            return;
        }

        hanoi(N - 1, from, to, mid);
        sb.append(from + " " + to).append("\n");
        hanoi(N - 1, mid, from, to);
    }
}
