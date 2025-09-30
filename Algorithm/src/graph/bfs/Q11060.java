package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 점프점프
 *
 * 재환이가 1×N 크기의 미로에 갇혀있다. 미로는 1×1 크기의 칸으로 이루어져 있고, 각 칸에는 정수가 하나 쓰여 있다.
 * i번째 칸에 쓰여 있는 수를 Ai라고 했을 때, 재환이는 Ai이하만큼 오른쪽으로 떨어진 칸으로 한 번에 점프할 수 있다.
 * 예를 들어, 3번째 칸에 쓰여 있는 수가 3이면, 재환이는 4, 5, 6번 칸 중 하나로 점프할 수 있다.
 *
 * 재환이는 지금 미로의 가장 왼쪽 끝에 있고, 가장 오른쪽 끝으로 가려고 한다.
 * 이때, 최소 몇 번 점프를 해야 갈 수 있는지 구하는 프로그램을 작성하시오.
 * 만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.
 */
public class Q11060 {

    static int N;
    static int[] map;

    static class Node {
        int x, count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N];
        queue.offer(new Node(0, 0));
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == N - 1) {
                return curr.count;
            }

            for (int i = 1; i <= map[curr.x]; i++) {
                int nX = curr.x + i;
                if (nX < N && !isVisited[nX]) {
                    isVisited[nX] = true;
                    queue.offer(new Node(nX, curr.count + 1));
                }
            }
        }

        return -1;
    }
}
