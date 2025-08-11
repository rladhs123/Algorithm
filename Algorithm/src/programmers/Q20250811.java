package programmers;

public class Q20250811 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int indexOfCards1 = 0;
        int indexOfCards2 = 0;

        for (int i = 0; i < goal.length; i++) {
            String currWord = goal[i];

            if (indexOfCards1 < cards1.length && cards1[indexOfCards1].equals(currWord)) {
                indexOfCards1++;
            } else if (indexOfCards2 < cards2.length && cards2[indexOfCards2].equals(currWord)) {
                indexOfCards2++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}
