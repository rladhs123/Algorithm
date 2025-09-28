package programmers;

public class Q20250928 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char curr = targets[i].charAt(j);
                int min = Integer.MAX_VALUE;

                for (String s : keymap) {
                    for (int k = 0; k < s.length(); k++) {
                        if (s.charAt(k) == curr && k + 1 < min) {
                            min = k + 1;
                        }
                    }
                }

                if (min != Integer.MAX_VALUE) {
                    answer[i] += min;
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
