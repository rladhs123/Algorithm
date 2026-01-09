package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15723 {

    static int[][] array = new int[26][26];
    static boolean[] isVisited;
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int from = s.charAt(0) - 'a';
            int to = s.charAt(s.length() - 1) - 'a';
            array[from][to] = 1;
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            int from = s.charAt(0) - 'a';
            int to = s.charAt(s.length() - 1) - 'a';
            isVisited = new boolean[26];
            find = false;
            dfs(from, to);

            if (find) {
                sb.append("T");
            } else {
                sb.append("F");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int from, int to) {
        for (int i = 0; i < 26; i++) {
            if (array[from][i] == 1 && !isVisited[i]) {
                if (i == to) {
                    find = true;
                }
                isVisited[i] = true;
                dfs(i, to);
                isVisited[i] = false;
            }
        }
    }
}
