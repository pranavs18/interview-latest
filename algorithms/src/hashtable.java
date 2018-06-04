public class hashtable {
    Pair storage[];
    int size;

    public hashtable(int size) {
        this.storage = new Pair[size];
        this.size = size;
        for(int i=0;i<size;i++) {
            storage[i] = null;
        }
    }


    public void insert(int key, int value) {
        int hashValue = hashFunction(key);
        while(storage[hashValue] != null && storage[hashValue].getKey() != key) {
                hashValue = (hashValue + 1)%size;
        }
        storage[hashValue] = new Pair(key, value);
    }


    public int get(int key) {
        int hashValue = hashFunction(key);

        while(storage[hashValue] != null && storage[hashValue].getKey() != key) {
            hashValue = (hashValue + 1)%size;
        }

        if(storage[hashValue] == null) {
            return -1;
        }

        return storage[hashValue].getValue();
    }

    public Pair iterator(int i) {
        return storage[i] != null? storage[i]: new Pair(0,0);
    }

    private int hashFunction(int key) {
        return key%size;
    }

}


class Pair {
    int key;
    int value;


    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return key + "-" + value;
    }
}

class Solution {

    public static void main(String args[]) {
        hashtable h = new hashtable(5);
        h.insert(1,10);
        h.insert(2,20);
        h.insert(7,34);
        System.out.println(h.get(1));
        System.out.println(h.get(3));
        System.out.println(h.get(7));
        for(int i=0;i<h.size;i++) {
            System.out.println(h.iterator(i).toString());
        }

    }
}