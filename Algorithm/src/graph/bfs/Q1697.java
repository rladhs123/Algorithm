package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질
 *
 * 수빈이는 동생과 숨바꼭질을 하고 있다.
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *
 * 수빈이와 동생의 위치가 주어졌을 때,
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */
public class Q1697 {

    static final int size = 100001;
    static int start, target;
    static int[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[size];
        start = sc.nextInt();
        target = sc.nextInt();

        bfs();

        System.out.println(map[target]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[size];
        isVisited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer currPosition = queue.poll();

            int frontPosition = currPosition + 1;
            if (frontPosition >= 0 && frontPosition < size) {
                if (!isVisited[frontPosition]) {
                    isVisited[frontPosition] = true;
                    map[frontPosition] = map[currPosition] + 1;
                    queue.offer(frontPosition);
                }
            }

            int backPosition = currPosition - 1;
            if (backPosition >= 0 && backPosition < size) {
                if (!isVisited[backPosition]) {
                    isVisited[backPosition] = true;
                    map[backPosition] = map[currPosition] + 1;
                    queue.offer(backPosition);
                }
            }

            int teleportPosition = currPosition * 2;
            if (teleportPosition >= 0 && teleportPosition < size) {
                if (!isVisited[teleportPosition]) {
                    isVisited[teleportPosition] = true;
                    map[teleportPosition] = map[currPosition] + 1;
                    queue.offer(teleportPosition);
                }
            }

        }
    }
}
