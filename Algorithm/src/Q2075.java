import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                long x = Long.parseLong(st.nextToken());

                if (priorityQueue.size() < n) {
                    priorityQueue.add(x);
                } else if (x > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(x);
                }
            }
        }

        System.out.println(priorityQueue.peek());
    }
}
