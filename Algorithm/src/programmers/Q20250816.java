package programmers;

import java.util.HashMap;

public class Q20250816 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        answer = new int[photo.length];
        int index = 0;

        for (String[] p : photo) {
            for (int i = 0; i < p.length; i++) {
                if (map.containsKey(p[i]))  {
                    answer[index] += map.get(p[i]);
                }
            }
            index++;
        }

        return answer;
    }
}
