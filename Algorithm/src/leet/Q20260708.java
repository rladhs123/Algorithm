package leet;

import java.util.LinkedList;
import java.util.Queue;

public class Q20260708 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            q.offer(i);
        }

        int result = 0;

        while (!q.isEmpty()) {
            int currentPerson = q.poll();
            int currentTicket = tickets[currentPerson]--;

            if (currentTicket == 1) {
                if (currentPerson == k) {
                    result++;
                    break;
                }
            } else {
                q.offer(currentPerson);
            }

            result++;
        }

        return result;
    }
}
