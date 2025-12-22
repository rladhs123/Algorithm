package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9205 {

    static Node[] list;
    static boolean[] isVisited;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            list = new Node[n + 2];
            isVisited = new boolean[n + 2];

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list[j] = new Node(y, x);
            }

            bfs(n + 2);

            if (isVisited[n + 1]) {
                sb.append("happy");
            } else {
                sb.append("sad");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            if (curr == n - 1) {
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    int dist = Math.abs(list[curr].x - list[i].x) + Math.abs(list[curr].y - list[i].y);

                    if (dist <= 1000) {
                        isVisited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
