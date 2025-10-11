package graph.dfs;

import java.util.Scanner;

/**
 * 양 한마리.. 양 두마리..
 *
 *얼마전에 나는 불면증에 시달렸지... 천장이 뚫어져라 뜬 눈으로 밤을 지새우곤 했었지.
 * 그러던 어느 날 내 친구 광민이에게 나의 불면증에 대해 말했더니 이렇게 말하더군. "양이라도 세봐!"
 * 정말 도움이 안되는 친구라고 생각했었지. 그런데 막상 또 다시 잠을 청해보려고 침대에 눕고 보니 양을 세고 있더군...
 * 그런데 양을 세다보니 이걸로 프로그램을 하나 짜볼 수 있겠단 생각이 들더군 후후후... 그렇게 나는 침대에서 일어나 컴퓨터 앞으로 향했지.
 * 양을 # 으로 나타내고 . 으로 풀을 표현하는 거야.
 * 서로 다른 # 두 개 이상이 붙어있다면 한 무리의 양들이 있는거지. 그래... 좋았어..! 이걸로 초원에서 풀을 뜯고 있는 양들을 그리드로 표현해 보는거야!
 * 그렇게 나는 양들을 그리드로 표현하고 나니까 갑자기 졸렵기 시작했어.
 * 하지만 난 너무 궁금했지. 내가 표현한 그 그리드 위에 몇 개의 양무리가 있었는지!
 * 그래서 나는 동이 트기 전까지 이 프로그램을 작성하고 장렬히 전사했지.
 * 다음날 내가 잠에서 깨어났을 때 내 모니터에는 몇 개의 양무리가 있었는지 출력되어 있었지.
 */
public class Q11123 {

    static int T, R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            R = sc.nextInt();
            C = sc.nextInt();
            map = new char[R][C];
            isVisited = new boolean[R][C];
            int count = 0;

            for (int j = 0; j < R; j++) {
                String input = sc.next();
                for (int k = 0; k < C; k++) {
                    map[j][k] = input.charAt(k);
                }
            }

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (map[j][k] == '#' && !isVisited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < R && nX < C) {
                if (map[nY][nX] == '#' && !isVisited[nY][nX]) {
                    dfs(nY, nX);
                }
            }
        }
    }
}
