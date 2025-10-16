package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 정수 a를 k로 만들기
 *
 * 입력으로 양의 정수 A와 K가 주어지면, 아래 연산을 이용하여 A를 K로 변경하려고 한다. 정수 A를 변경할 때 사용할 수 있는 연산 종류는 다음과 같다.
 * 연산 1: 정수 A에 1을 더한다.
 * 연산 2: 정수 A에 2를 곱한다.
 * 정수 A를 정수 K로 만들기 위해 필요한 최소 연산 횟수를 출력하자.
 */
public class Q25418 {

    static int A, K;

    static class Node {
        int n, count;

        public Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        K = sc.nextInt();

        int result = bfs();

        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 0));
        boolean[] isVisited = new boolean[K + 1];
        isVisited[A] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.n == K) {
                return curr.count;
            }

            if (curr.n + 1 <= K && !isVisited[curr.n + 1]) {
                isVisited[curr.n + 1] = true;
                queue.offer(new Node(curr.n + 1, curr.count + 1));
            }

            if (curr.n * 2 <= K && !isVisited[curr.n * 2]) {
                isVisited[curr.n * 2] = true;
                queue.offer(new Node(curr.n * 2, curr.count + 1));
            }
        }

        return 0;
    }
}
