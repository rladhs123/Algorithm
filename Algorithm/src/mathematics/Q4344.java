package mathematics;

import java.util.Scanner;

/**
 * 평균은 넘겠지
 *
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 */
public class Q4344 {

    static int C, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();

        for (int i = 0; i < C; i++) {
            N = sc.nextInt();
            int[] array = new int[N];
            int sum = 0;

            for (int j = 0; j < N; j++) {
                array[j] = sc.nextInt();
                sum += array[j];
            }

            float avg = (float) sum / N;
            int num = 0;

            for (int j = 0; j < N; j++) {
                if (array[j] > avg) {
                    num++;
                }
            }

            float result = (float) num / N * 100;

            System.out.printf("%.3f%%\n", result);

        }
    }
}
