package _2023.마이다스아이티;







import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] history, String[][] option, String keyword) {
        // 옵션 파싱
        boolean isOptionW = false;
        boolean isOptionR = false;
        boolean isOptionWC = false;

        for (int i = 0; i < option.length; i++) {
            if (option[i][0].equals("W")) {
                isOptionW = option[i][1].equals("T");
            } else if (option[i][0].equals("R")) {
                isOptionR = option[i][1].equals("T");
            } else if (option[i][0].equals("WC")) {
                isOptionWC = option[i][1].equals("T");
            }
        }

        // 검색 가능한 키워드 추출
        List<String> recommendKeywords = new ArrayList<>();

        for (int i = 0; i < history.length; i++) {
            String[] words = history[i].split(" ");
            boolean isMatched = false;

            for (int j = 0; j < words.length; j++) {
                String word = words[j];

                // W 옵션 체크
                if (isOptionW && word.equals(keyword)) {
                    isMatched = true;
                }

                // WC 옵션 체크
                if (isOptionWC && keyword.contains("*")) {
                    String pattern = keyword.replace("*", ".*");

                    if (word.matches(pattern)) {
                        isMatched = true;
                    }
                }

                if (isMatched) {
                    if (isOptionR && words.length > 10) {
                        recommendKeywords.add(String.join(" ", Arrays.copyOf(words, 10)) + "...");
                    } else {
                        recommendKeywords.add(history[i]);
                    }

                    break;
                }
            }
        }

        if (recommendKeywords.isEmpty()) {
            return new String[]{"empty"};
        }

        if (keyword.equals("*")) {
            return recommendKeywords.toArray(new String[0]);
        }

        List<String> filteredKeywords = recommendKeywords.stream().filter(k -> k.contains(keyword)).collect(Collectors.toList());

        if (filteredKeywords.isEmpty()) {
            return new String[]{"empty"};
        }

        return filteredKeywords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] history = {"hello i am david",
                "hello kail",
                "hi tina"};
        String[][] option = {{"W", "T"},{"R","T"}};
        String keyword = "hello";
        Solution test = new Solution();
        System.out.println(Arrays.toString(test.solution(history, option, keyword)));
    }
    }
