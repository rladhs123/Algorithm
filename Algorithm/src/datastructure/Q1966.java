package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1966 {

    static class Node {
        int num, weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<Node> deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                deque.add(new Node(j, Integer.parseInt(st.nextToken())));
            }

            int remove = -1;
            int result = 0;

            while (remove != m && !deque.isEmpty()) {
                Node firstNode = deque.pollFirst();
                boolean check = false;

                for (Node node : deque) {
                    if (node.weight > firstNode.weight) {
                        check = true;
                        break;
                    }
                }

                if (check) {
                    deque.addLast(firstNode);
                } else {
                    remove = firstNode.num;
                    result++;
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
