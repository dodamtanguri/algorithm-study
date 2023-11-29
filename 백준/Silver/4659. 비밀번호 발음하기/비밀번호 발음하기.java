import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String password = scanner.nextLine();
            if (password.equals("end")) {
                break;
            }
            System.out.println("<" + password + "> " + (isValidPassword(password) ? "is acceptable." : "is not acceptable."));
        }
    }

    private static boolean isValidPassword(String password) {
        boolean hasVowel = false;
        char prevChar = ' ';
        int consecutiveSameType = 1;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            // Check for vowels
            if (isVowel(ch)) {
                hasVowel = true;
                if (prevChar == ch && (ch != 'e' && ch != 'o')) {
                    return false;
                }
            } else {
                if (prevChar == ch) {
                    return false;
                }
            }

            // Check for consecutive same type characters
            if (i > 0) {
                if ((isVowel(ch) && isVowel(prevChar)) || (!isVowel(ch) && !isVowel(prevChar))) {
                    consecutiveSameType++;
                    if (consecutiveSameType == 3) {
                        return false;
                    }
                } else {
                    consecutiveSameType = 1;
                }
            }

            prevChar = ch;
        }

        return hasVowel;
    }

    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
