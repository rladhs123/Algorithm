package graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q13023 {

    static List<Integer>[] graph;
    static boolean[] isVisited;
    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }


        for (int i = 0; i < n; i++) {
            isVisited = new boolean[n];
            isVisited[i] = true;
            dfs(i, 0);

            if (check) {
                System.out.println(1);
                return;
            }

        }

        System.out.println(0);
    }

    static void dfs(int n, int depth) {
        if (depth == 4) {
            check = true;
            return;
        }

        for (Integer i : graph[n]) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, depth + 1);
                isVisited[i] = false;

                if (check) {
                    return;
                }
            }
        }
    }
}
