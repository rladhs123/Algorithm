package leet;

import java.util.LinkedList;
import java.util.Queue;

public class Q20260707 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for (int i : students) {
            q.offer(i);
        }

        int failCount = 0;
        int index = 0;

        while (!q.isEmpty()) {
            if (q.peek() == sandwiches[index]) {
                index++;
                q.poll();
                failCount = 0;
            } else {
                failCount++;
                q.offer(q.poll());
            }

            if (failCount == q.size()) {
                break;
            }
        }

        return q.size();
    }
}
