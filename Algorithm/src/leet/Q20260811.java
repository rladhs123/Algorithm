package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260811 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int i = 0;

        for (String word : words) {
            if (word.contains(Character.toString(x))) {
                list.add(i);
            }
            i++;
        }

        return list;
    }
}
