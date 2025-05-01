package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {

    static int N;

    static class Tower {
        int index, height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < h) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0 + " ");
            } else {
                sb.append(stack.peek().index + " ");
            }

            stack.push(new Tower(i, h));
        }

        System.out.println(sb);
    }
}
