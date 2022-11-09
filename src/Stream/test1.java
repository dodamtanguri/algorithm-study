package Stream;


import java.util.*;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) {
        List<String> originList = new ArrayList<>();

        originList.add("G0001");
        originList.add("G0013");
        originList.add("G0020");
        originList.add("G0059");

        List<String> requestList = new ArrayList<>();

        requestList.add("G0001");
        requestList.add("G0003");
        requestList.add("G0059");
        requestList.add("G0013");

        //우서는 update 될 항목들 찾기 -> originList 랑 requestList랑 중복인거
        List<String> updateList = originList.stream().filter(
                seq -> requestList.stream()
                        .anyMatch(req -> req.equals(seq))
        ).collect(Collectors.toList());

        System.out.println(updateList);

        HashSet<String> setOriginList = new HashSet<>();

        setOriginList.add("G0001");
        setOriginList.add("G0013");
        setOriginList.add("G0020");
        setOriginList.add("G0059");

        HashSet<String> setRequestList = new HashSet<>();

        setRequestList.add("G0001");
        setRequestList.add("G0003");
        setRequestList.add("G0059");
        setRequestList.add("G0013");

        List<String> result = setOriginList.stream().filter(
                seq ->  {
                    return setRequestList.stream()
                                .anyMatch(req -> req.contains(seq));
                }

        ).collect(Collectors.toList());


        System.out.println(result);
    }


}
