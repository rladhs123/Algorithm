package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16953 {

    static long A, B;

    static class Node {
        long n;
        int count;

        public Node(long n, int count) {
            this.n = n;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (currNode.n == B) {
                return currNode.count;
            }

            if (currNode.n * 2 <= B) {
                queue.offer(new Node(currNode.n * 2,currNode.count + 1));
            }

            if ((currNode.n * 10) + 1 <= B) {
                queue.offer(new Node((currNode.n * 10) + 1,currNode.count + 1));
            }
        }

        return -1;
    }
}
