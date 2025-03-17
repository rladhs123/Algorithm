package backtracking;

import java.util.Scanner;

/**
 * 스타트와 링크
 * <p>
 * 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다.
 * 축구는 평일 오후에 하고 의무 참석도 아니다. 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다.
 * 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
 * 축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.
 */
public class Q14889 {

    static int N;
    static int[][] map;
    static boolean[] isVisited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        backTracking(0, 0);

        System.out.println(MIN);
    }

    static void backTracking(int depth, int index) {
        if (depth == N / 2) {
            calculateScore();
            if (MIN == 0) {
                return;
            }
            return;
        }

        for (int i = index; i < N; i++) {
            isVisited[i] = true;
            backTracking(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }

    static void calculateScore() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    startScore += map[i][j];
                    startScore += map[j][i];
                } else if (!isVisited[i] && !isVisited[j]) {
                    linkScore += map[i][j];
                    linkScore += map[j][i];
                }
            }
        }

        int score = Math.abs(startScore - linkScore);

        MIN = Math.min(MIN, score);
    }
}
