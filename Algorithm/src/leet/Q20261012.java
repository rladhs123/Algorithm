package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q20261012 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Character, String> map = new HashMap<>();
        int index = 0;

        for (String s : arr) {
            char c = (char) ('a' + index);
            map.put(c, s);
            index++;
        }

        Set<String> set = new HashSet<>();

        for (String word : words) {
            String s = "";

            for (int i = 0; i < word.length(); i++) {
                s += map.get(word.charAt(i));
            }

            if (!set.contains(s)) {
                set.add(s);
            }
        }

        return set.size();
    }
}
