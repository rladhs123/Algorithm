package datastructure;

import java.util.*;

public class Q10845 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sc.nextLine();


        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];

            if (command.equals("push")) {
                int n = Integer.parseInt(input[1]);
                deque.add(n);
            } else {
                if (command.equals("front")) {
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                } else if (command.equals("back")) {
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n');
                    }
                } else if (command.equals("size")) {
                    sb.append(deque.size()).append('\n');
                } else if (command.equals("pop")) {
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                } else {
                    if (deque.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
