package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12869 {

    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println((array[0] + 8) / 9);
        } else {
            int result = bfs(array);

            System.out.println(result);
        }
    }

    static int bfs(int[] array) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[61][61][61];
        queue.offer(array);
        isVisited[array[0]][array[1]][array[2]] = true;

        while (!queue.isEmpty()) {
            int[] currStatus = queue.poll();

            for (int i = 0; i < 6; i++) {
                int[] arr = new int[4];

                arr[0] = Math.max(currStatus[0] - attack[i][0], 0);
                arr[1] = Math.max(currStatus[1] - attack[i][1], 0);
                arr[2] = Math.max(currStatus[2] - attack[i][2], 0);
                arr[3] = currStatus[3] + 1;

                if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                    return arr[3];
                }

                if (!isVisited[arr[0]][arr[1]][arr[2]]) {
                    isVisited[arr[0]][arr[1]][arr[2]] = true;
                    queue.offer(arr);
                }
            }
        }

        return 0;
    }
}
