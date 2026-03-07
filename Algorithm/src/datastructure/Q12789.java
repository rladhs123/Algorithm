package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int index = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            while (!stack.isEmpty() && stack.peekLast() == index) {
               stack.pollLast();
               index++;
            }

            if (x == index) {
                index++;
            } else {
                stack.addLast(x);
            }
        }

        while (!stack.isEmpty() && stack.peekLast() == index) {
            stack.pollLast();
            index++;
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
