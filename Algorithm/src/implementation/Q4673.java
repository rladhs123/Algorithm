package implementation;

public class Q4673 {

    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];

        for (int i = 1; i < arr.length; i++) {
            int sum = i;
            String s = Integer.toString(i);

            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - '0';
            }

            if (sum <= 10000) {
                arr[sum] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}
