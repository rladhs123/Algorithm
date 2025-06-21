package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q11651 {

    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y != o.y) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for (Node node : list) {
            sb.append(node.x).append(' ').append(node.y).append('\n');
        }

        System.out.println(sb);
    }
}
