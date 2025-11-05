package graph.dfs;

import java.util.Scanner;

/**
 * 점프 점프
 *
 * 영우는 개구리다 개굴개굴개굴
 * 영우는 지금 n개의 돌이 일렬로 놓여있는 돌다리에 있다. 그리고 돌다리의 돌에는 숫자가 하나씩 적혀있다.
 * 영우는 이 숫자가 적혀있는 만큼 왼쪽이나 오른쪽으로 점프할 수 있는데, 이때 돌다리 밖으로 나갈 수는 없다.
 * 영우는 이 돌다리에서 자기가 방문 가능한 돌들의 개수를 알고 싶어한다.
 * 방문 가능하다는 것은 현재위치에서 다른 돌을 적절히 밟아 해당하는 위치로 이동이 가능하다는 뜻이다.
 * 현재 위치가 주어졌을 때, 영우가 방문 가능한 돌들의 개수를 출력하시오.
 */
public class Q14248 {

    static int N, START;
    static int[] map;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
        }

        START = sc.nextInt();

        dfs(START - 1);

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int curr) {
        if (curr < 0 || curr >= N) {
            return;
        }

        if (isVisited[curr]) {
            return;
        }

        isVisited[curr] = true;

        dfs(curr + map[curr]);
        dfs(curr - map[curr]);
    }
}
