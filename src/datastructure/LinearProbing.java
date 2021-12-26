package datastructure;

/*
폐쇄 해슁 또는 Close hashing 기법 중 하나
>> 해쉬테이블 저장공간 안에서 충돌문제를 해결하는 기법
 */
public class LinearProbing {
    public Slot[] hashTable;

    public LinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                //해당 슬롯이 존재하는지 확인
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        //그 다음 슬롯으로 이동
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currentAddress = address;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        return this.hashTable[currentAddress].value;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinearProbing mainObject = new LinearProbing(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(mainObject.getData("fun-coding"));

    }
}