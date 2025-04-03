package recursivefunction;

import java.util.Scanner;

/**
 * Z
 *
 * 한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다.
 * 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
 * N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 */
public class Q1074 {

    static int N, r, c, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int size = (int)Math.pow(2, N);

        search(size, r, c);

        System.out.println(count);
    }

    static void search(int size, int r, int c) {
        if (size == 1) {
            return;
        } else if (r < size / 2 && c < size / 2) {
            search(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            count += (size / 2) * (size / 2);
            search(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) {
            count += size * (size / 2);
            search(size / 2, r - size / 2, c);
        } else {
            count += 3 * (size / 2) * (size / 2);
            search(size / 2, r - size / 2, c - size / 2);
        }
    }
}
