package _2023.마이다스아이티;

import java.util.*;
import java.util.Arrays;

public class intermediate_2 {
    public static String[] suggestSearchTerms(String[] history, String[][] options, String keyword) {
        boolean exactMatch = false;
        boolean restrictLength = false;
        boolean wildcard = false;

        for (String[] option : options) {
            if (option[0].equals("W") && option[1].equals("T")) {
                exactMatch = true;
            } else if (option[0].equals("R") && option[1].equals("T")) {
                restrictLength = true;
            } else if (option[0].equals("WC") && option[1].equals("T")) {
                wildcard = true;
            }
        }

        List<String> suggestions = new ArrayList<>();

        for (String sentence : history) {
            if (!exactMatch && !restrictLength && !wildcard && sentence.equals(keyword)) {
                suggestions.add(sentence);
                continue;
            }

            if (wildcard && keyword.equals("*")) {
                suggestions.add(sentence);
                continue;
            }

            String[] words = sentence.split(" ");

            if (exactMatch) {
                if (Arrays.asList(words).contains(keyword)) {
                    suggestions.add(convertSentence(sentence, restrictLength));
                }
            } else if (wildcard) {
                if (keyword.endsWith("*")) {
                    String temp = keyword.replace("*", "");

                    if (sentence.startsWith(temp)) {
                        suggestions.add(convertSentence(sentence, restrictLength));
                    }
                } else if (keyword.startsWith("*")) {
                    String temp = keyword.replace("*", "");

                    if (sentence.endsWith(temp)) {
                        suggestions.add(convertSentence(sentence, restrictLength));
                    }
                }
            }
        }

        String[] ans = new String[suggestions.size()];
        return suggestions.toArray(ans);
    }
    public static String convertSentence(String sentence, boolean isRestrictLength) {
        if (!isRestrictLength) {
            return sentence;
        }
        if (sentence.length() <= 10) {
            return sentence;
        }

        return sentence.substring(0, 10) + "...";
    }
}
