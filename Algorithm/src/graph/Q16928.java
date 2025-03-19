package graph;

import java.util.*;

/**
 * 뱀과 사다리 게임
 *
 * 플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다.
 * 예를 들어, 플레이어가 i번 칸에 있고, 주사위를 굴려 나온 수가 4라면, i+4번 칸으로 이동해야 한다.
 * 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다.
 * 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다. 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다.
 * 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.
 * 게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.
 * 게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값을 구해보자.
 */
public class Q16928 {

    static int N, M;
    static int[] map = new int[101];
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static int[] dx = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            ladder.put(from, to);
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            snake.put(from, to);
        }

        bfs();

        System.out.println(map[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            if (queue.contains(100)) return;

            for (int i = 0; i < dx.length; i++) {
                int nextNode = currNode + dx[i];

                if (nextNode < map.length) {
                    if (ladder.containsKey(nextNode)) {
                        if (map[ladder.get(nextNode)] == 0 || map[ladder.get(nextNode)] > map[currNode] + 1) {
                            map[ladder.get(nextNode)] = map[currNode] + 1;
                            queue.offer(ladder.get(nextNode));
                        }
                    } else if (snake.containsKey(nextNode)) {
                        if (map[snake.get(nextNode)] == 0 || map[snake.get(nextNode)] > map[currNode] + 1) {
                            map[snake.get(nextNode)] = map[currNode] + 1;
                            queue.offer(snake.get(nextNode));
                        }
                    } else {
                        if (map[nextNode] == 0 || map[nextNode] > map[currNode] + 1) {
                            map[nextNode] = map[currNode] + 1;
                            queue.offer(nextNode);
                        }
                    }
                }
            }
        }
    }
}
