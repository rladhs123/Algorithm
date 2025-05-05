package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질 2
 *
 * 수빈이는 동생과 숨바꼭질을 하고 있다.
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다.
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때,
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고,
 * 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.
 */
public class Q12851 {

    static final int size = 100001;
    static int start, target;
    static int[] map;
    static int min, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[size];
        start = sc.nextInt();
        target = sc.nextInt();
        min = Integer.MAX_VALUE;

        if (start == target) {
            System.out.println(0 + "\n" + 1);
            return;
        }

        bfs();

        System.out.println(min + "\n" + count);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        map[start] = 0;

        while (!queue.isEmpty()) {
            Integer currPosition = queue.poll();

            for (int nextPosition : new int[]{currPosition + 1, currPosition - 1, currPosition * 2}) {
                if (nextPosition < 0 || nextPosition >= size) continue;

                if (nextPosition == target) {
                    if (min > map[currPosition] + 1) {
                        min = map[currPosition] + 1;
                        count = 1;
                    } else if (min == map[currPosition] + 1) {
                        count++;
                    }
                } else if (map[nextPosition] == 0 || map[nextPosition] == map[currPosition] + 1) {
                    map[nextPosition] = map[currPosition] + 1;
                    queue.offer(nextPosition);
                }
            }
        }
    }
}
