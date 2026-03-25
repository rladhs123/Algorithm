package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            if (c == '<') {
                reverse(stack, sb);
                sb.append(c);
                check = true;
                continue;
            }

            if (c == '>') {
                sb.append(c);
                check = false;
                continue;
            }

            if (check) {
                sb.append(c);
            } else {
                if (c != ' ') {
                    stack.push(c);
                } else {
                    reverse(stack, sb);
                    sb.append(' ');
                }
            }
        }

        reverse(stack, sb);

        System.out.println(sb);
    }

    static void reverse(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
