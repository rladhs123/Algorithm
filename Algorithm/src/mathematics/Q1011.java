package mathematics;

import java.util.Scanner;

/**
 * Fly me to the Alpha Centauri
 *
 * 공간이동 장치는 이동 거리를 급격하게 늘릴 경우 기계에 심각한 결함이 발생하는 단점이 있어서,
 * 이전 작동시기에 k광년을 이동하였을 때는 k-1 , k 혹은 k+1 광년만을 다시 이동할 수 있다.
 * x지점에서 y지점을 향해 최소한의 작동 횟수로 이동하려 한다.
 * 하지만 y지점에 도착해서도 공간 이동장치의 안전성을 위하여 y지점에 도착하기 바로 직전의 이동거리는 반드시 1광년으로 하려 한다.
 * x지점부터 정확히 y지점으로 이동하는데 필요한 공간 이동 장치 작동 횟수의 최솟값을 구하는 프로그램을 작성하라.
 */
public class Q1011 {

    static int T, start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            int distance = end - start;
            int maxSpeed = (int)Math.sqrt(distance);

            if (maxSpeed * maxSpeed == distance) {
                sb.append(2 * maxSpeed - 1).append('\n');
            } else if (maxSpeed * maxSpeed < distance && distance <= maxSpeed * (maxSpeed + 1)) {
                sb.append(2 * maxSpeed).append('\n');
            } else {
                sb.append(2 * maxSpeed + 1).append('\n');
            }
        }

        System.out.print(sb);
    }
}
