package backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q5568 {

    static int N, K;
    static String[] array;
    static boolean[] isVisited;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        array = new String[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.next();
        }

        isVisited = new boolean[N];
        dfs(0, "");

        System.out.println(set.size());
    }

    static void dfs(int depth, String num) {
        if (depth == K) {
            set.add(num);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(depth + 1, num + array[i]);
                isVisited[i] = false;
            }
        }
    }
}
