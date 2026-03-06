package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {
                sb.append(stack.pop()).append('\n');
            } else if (command == 3) {
                sb.append(stack.size()).append('\n');
            } else if (command == 4) {
                sb.append(stack.isEmpty()).append('\n');
            } else {
                sb.append(stack.print()).append('\n');
            }
        }

        System.out.print(sb);
    }

    static class Stack {
        int[] arr = new int[1_000_000];
        int stackPointer = -1;

        void push(int x) {
            arr[++stackPointer] = x;
        }

        int pop() {
            if (isEmpty() == 1) {
                return -1;
            }

            return arr[stackPointer--];
        }

        int size() {
            return stackPointer + 1;
        }

        int isEmpty() {
            if (stackPointer < 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int print() {
            if (isEmpty() == 1) {
                return -1;
            } else {
                return arr[stackPointer];
            }
        }
    }
}
