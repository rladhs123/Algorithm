package leet;

import java.util.List;

public class Q20260722 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index;

        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else {
            index = 2;
        }

        int result = 0;

        for (List item : items) {
            if (item.get(index).equals(ruleValue)) {
                result++;
            }
        }

        return result;
    }
}
