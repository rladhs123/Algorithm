package graph.bfs;

import java.util.*;

/**
 * 숨바꼭질 4
 *
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
public class Q13913 {

    static final int MAX = 100000;
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int[] map = new int[MAX + 1];
        boolean[] isVisited = new boolean[MAX + 1];
        map[N] = -1;
        StringBuilder sb = new StringBuilder();

        bfs(map, isVisited);

        List<Integer> path = new ArrayList<>();

        for (int i = K; i != -1; i = map[i]) {
            path.add(i);
        }

        Collections.reverse(path);
        sb.append(path.size() - 1).append('\n');

        for (Integer i : path) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs(int[] map, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        isVisited[N] = true;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            if (curr == K) {
                return;
            }

            int[] nextPositions = {curr + 1, curr - 1, curr * 2};

            for (int nextPosition : nextPositions) {
                if (nextPosition < 0 || nextPosition > MAX) {
                    continue;
                }

                if (!isVisited[nextPosition]) {
                    isVisited[nextPosition] = true;
                    map[nextPosition] = curr;
                    queue.add(nextPosition);
                }
            }
        }
    }
}
