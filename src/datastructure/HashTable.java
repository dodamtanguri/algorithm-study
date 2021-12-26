package datastructure;

public class HashTable {
    public Slot[] hashTable;

    public HashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;

        Slot(String value, String key) {
            this.key = key;
            this.next = null;
            this.value = value;
        }
    }

    //Key가 문자열 일 때, 문자열의 앞 글자를 숫자로 변환해서 Division기법을 사용해 Key에 대한 주소(인덱스 번호) 계산
    //Division 기법: 가장 간단한 해쉬 함수 중 하나로, 나누기를 통해, 나머지 값을 사용하는 기법
    public int hahFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    //chaining 기법 Hashtable 저장공간 외의 공간을 활용하는 기법>> LinkedList 자료구조를 사용해서
    // 링크드 리스트로 데이터를 추가로 뒤에 연결시켜 저장하는 기법
    public boolean saveData(String key, String value) {
        //해당 키에 대한 주소를 가져오기.
        Integer address = this.hahFunc(key);
        if (this.hashTable[address] != null) {
            //LinkedList의 헤드부분이 됨.
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                //findslot이 내가 찾는 키인지확인 하기
                if (findSlot.key == key) {
                    //update
                    findSlot.value = value;
                    return true;
                } else {
                    //순회회
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            //찾는 슬롯이 비어있다면,,
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hahFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable test = new HashTable(20);
        test.saveData("dodam", "1234");
        test.saveData("fun-coding", "12345");
        System.out.println(test.getData("fun-coding"));
    }
}
