package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1094 {

    static class Stick implements Comparable<Stick> {

        int length;

        public Stick(int length) {
            this.length = length;
        }

        @Override
        public int compareTo(Stick o) {
            return length - o.length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        /*
        1. 지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
            1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
            2. 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
        2. 이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
         */

        int sum = 64;
        Queue<Stick> queue = new PriorityQueue<>();
        queue.offer(new Stick(64));

        while (sum > x) {
            Stick min = queue.poll();
            int minHalf = min.length / 2;

            if (sum - min.length + minHalf < x) {
                queue.offer(new Stick(min.length / 2));
            }

            queue.offer(new Stick(min.length / 2));

            sum = 0;

            for (Stick stick : queue) {
                sum += stick.length;
            }
        }

        System.out.println(queue.size());
    }
}
