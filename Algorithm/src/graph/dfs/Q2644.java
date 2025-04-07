package graph.dfs;

import java.util.*;

/**
 * 촌수계산
 *
 * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때,
 * 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
 */
public class Q2644 {

    static int n, start, target, m;
    static List<ArrayList<Integer>> graph = new LinkedList<>();
    static boolean[] isVisited;
    static int[] array;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();
        target = sc.nextInt();
        m = sc.nextInt();
        isVisited = new boolean[n + 1];
        array = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(start);

        if (array[target] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[target]);
        }
    }

    static void dfs(int currNode) {
        isVisited[currNode] = true;

        if (currNode == target) {
            Arrays.fill(isVisited, true);
            return;
        }

        for (int i = 0; i < graph.get(currNode).size(); i++) {
            if (!isVisited[graph.get(currNode).get(i)]) {
                array[graph.get(currNode).get(i)] = array[currNode] + 1;
                dfs(graph.get(currNode).get(i));
            }
        }
    }
}
