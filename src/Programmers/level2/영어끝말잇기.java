package Programmers.level2;

import com.sun.tools.classfile.Type;
import com.sun.tools.javac.util.List;
import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;

import java.util.ArrayList;
import java.util.HashSet;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {

        HashSet<String> array = new HashSet<>();
        int depth = 0; //몇번돌았는지
        int current = 0; //몇번째사람인지
        //1. 앞사람이 말한 단어의 마지막문자로 시작하는 단어

        for (int i = 0; i < words.length; i++) {
            // 앞에문자의 마지막 글자 뒤에단어의 첫번째 글자가 같지않다면
            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || array.contains(words[i])) {
                depth = (i / n) + 1;
                current = (i % n) + 1;
                return new int[]{current, depth};
            } else {
                array.add(words[i]);
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        영어끝말잇기 test = new 영어끝말잇기();
        String[] testStr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(test.solution(3, testStr));
        System.out.println(testStr.length);
    }
}
