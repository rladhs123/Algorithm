package graph;

import java.util.*;

/**
 * 숨바꼭질 3
 *
 * 수빈이는 동생과 숨바꼭질을 하고 있다.
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
public class Q13549 {

    static int N, K;
    static int[] map = new int[100001];

    static class Node implements Comparable<Node>{
        int position, time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Arrays.fill(map, Integer.MAX_VALUE);

        dijkstra();

        System.out.println(map[K]);
    }

    static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(N, 0));
        map[N] = 0;

        while (!queue.isEmpty()) {
            Node currPosition = queue.poll();

            if (currPosition.position == K) return;

            int teleportPosition = currPosition.position * 2;

            if (teleportPosition < map.length && map[teleportPosition] > currPosition.time) {
                map[teleportPosition] = currPosition.time;
                queue.offer(new Node(teleportPosition, currPosition.time));
            }

            int[] dx = {1, -1};

            for (int i : dx) {
                int nextPosition = currPosition.position + i;

                if (nextPosition >= 0 && nextPosition < map.length && map[nextPosition] > currPosition.time + 1) {
                    map[nextPosition] = currPosition.time + 1;
                    queue.offer(new Node(nextPosition, currPosition.time + 1));
                }
            }
        }
    }
}
