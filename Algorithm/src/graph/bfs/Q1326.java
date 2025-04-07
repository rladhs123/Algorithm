package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 폴짝폴짝
 *
 * 개구리가 일렬로 놓여 있는 징검다리 사이를 폴짝폴짝 뛰어다니고 있다.
 * 징검다리에는 숫자가 각각 쓰여 있는데,
 * 이 개구리는 매우 특이한 개구리여서 어떤 징검다리에서 점프를 할 때는
 * 그 징검다리에 쓰여 있는 수의 배수만큼 떨어져 있는 곳으로만 갈 수 있다.
 * 이 개구리는 a번째 징검다리에서 b번째 징검다리까지 가려고 한다.
 * 이 개구리가 a번째 징검다리에서 시작하여 최소 몇 번 점프를 하여 b번째 징검다리까지 갈 수 있는지를 알아보는 프로그램을 작성하시오.
 */
public class Q1326 {

    static int N, a, b;
    static int[] array;
    static int result = -1;

    static class Node {
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = sc.nextInt();
        }

        a = sc.nextInt();
        b = sc.nextInt();


        if (a == b) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(result);
        }


    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 0));
        boolean[] isVisited = new boolean[N + 1];
        isVisited[a] = true;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (currNode.num == b) {
                result = currNode.count;
                return;
            }

            for (int i = currNode.num; i <= N; i += array[currNode.num]) {
                if (!isVisited[i]) {
                    queue.offer(new Node(i, currNode.count + 1));
                    isVisited[i] = true;
                }
            }

            for (int i = currNode.num; i > 0; i -= array[currNode.num]) {
                if (!isVisited[i]) {
                    queue.offer(new Node(i, currNode.count + 1));
                    isVisited[i] = true;
                }
            }
        }
    }
}
