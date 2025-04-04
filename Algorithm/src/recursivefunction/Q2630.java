package recursivefunction;

import java.util.Scanner;

/**
 * 색종이 만들기
 *
 * 입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때
 * 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램을 작성하시오.
 */
public class Q2630 {

    static int N, whiteCount, blueCount;
    static int[][] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        paper = new int[N][N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, N);

        sb.append(whiteCount).append('\n').append(blueCount);
        System.out.println(sb);
    }

    static void divide(int r, int c, int size) {

        if (check(r, c, size)) {
           if (paper[r][c] == 1) {
               blueCount++;
           } else {
               whiteCount++;
           }
           return;
        }

        int halfSize = size / 2;

        divide(r, c, halfSize);
        divide(r, c + halfSize, halfSize);
        divide(r + halfSize, c, halfSize);
        divide(r + halfSize, c + halfSize, halfSize);
    }

    static boolean check(int r, int c, int size) {

        int sign = paper[r][c];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (paper[r + i][c + j] != sign) {
                    return false;
                }
            }
        }

        return true;
    }
}
