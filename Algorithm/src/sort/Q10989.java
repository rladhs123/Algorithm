package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 정렬하기 3
 *
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */
public class Q10989 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int[] array = new int[10001];

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            array[input]++;
        }

        for (int i = 0; i < 10001; i++) {
            while (array[i]-- > 0) {
                sb.append(i + "\n");
            }
        }

        System.out.print(sb);
    }
}
