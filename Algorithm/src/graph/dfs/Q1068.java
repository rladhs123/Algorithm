package graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1068 {

    static int N;
    static List<Integer>[] list;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        int root = -1;

        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();

            if (parent == -1) {
                root = i;
                continue;
            }

            list[parent].add(i);
        }

        int removeNode = sc.nextInt();
        if (removeNode == root) {
            System.out.println(0);
            return;
        }

        for (List<Integer> children : list) {
            if (children.contains(removeNode)) {
                children.remove((Integer) removeNode);
            }
        }

        dfs(root);

        System.out.println(result);
    }

    static void dfs(int root) {
        if (list[root].isEmpty()) {
            result++;
        }

        for (Integer i : list[root]) {
            dfs(i);
        }
    }
}
