package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260914 {

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    if (!list.contains(words[j])) {
                        list.add(words[j]);
                    }
                } else if (words[j].contains(words[i])) {
                    if (!list.contains(words[i])) {
                        list.add(words[i]);
                    }
                }
            }
        }

        return list;
    }
}
