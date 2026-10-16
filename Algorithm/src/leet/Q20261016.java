package leet;

public class Q20261016 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;

        for (int num : distance) {
            sum += num;
        }

        int x = 0;

        for (int i = Math.min(start, destination); i < Math.max(start, destination); i++) {
            x += distance[i];
        }

        return Math.min(sum - x, x);
    }
}
