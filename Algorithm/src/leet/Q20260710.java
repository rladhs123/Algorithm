package leet;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q20260710 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            maxHeap.add(i);
        }

        while(!maxHeap.isEmpty() && maxHeap.size() != 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x != y) {
                maxHeap.add(y - x);
            }
        }

        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.poll();
        }
    }
}
