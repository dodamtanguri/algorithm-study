import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next().toUpperCase();

        int[] freq = new int[26]; // 알파벳은 총 26개
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'A']++;
        }

        int maxIndex = 0;
        int maxCount = 0;
        boolean duplicate = false;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxIndex = i;
                duplicate = false;
            } else if (freq[i] == maxCount) {
                duplicate = true;
            }
        }

        System.out.println(duplicate ? "?" : (char) (maxIndex + 'A'));
        scanner.close();
    }
}
