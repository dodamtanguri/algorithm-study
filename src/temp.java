import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class temp {
    public static void main(String[] args) {
        System.out.println(solution("PM 11:59:59", 1));
    }

    public static String solution(String p, int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a hh:mm:ss");
        LocalTime localTime = LocalTime.parse(p, formatter);
        localTime = localTime.plusSeconds(n);

        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
