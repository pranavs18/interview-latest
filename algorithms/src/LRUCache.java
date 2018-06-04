import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> cacheMap;
    int size;
    int capacity;
    Node leastRecent, mostRecent = null;


    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        mostRecent = new Node();
        leastRecent = new Node();
    }

    public void put(int key, int value) {

       /* if(cacheMap.containsKey(key)) {
            Node temp = cacheMap.get(key);
            temp.value = value;
            cacheMap.put(key, temp);
        }*/

        if(this.size == capacity) {
            // remove the LRU element
            cacheMap.remove(leastRecent.key);
            if(leastRecent.next != null) {
                leastRecent = leastRecent.next;
                leastRecent.previous = null;
            }

            size--;
        }

        Node current = new Node(key, value);
        cacheMap.put(key, current);
        mostRecent.next = current;
        current.next = null;
        current.previous = mostRecent;
        mostRecent = current;
        size++;
        if(size == 1) {
            leastRecent = mostRecent;
        }

    }

    public int get(int key) {
       if(!cacheMap.containsKey(key)) {
           return -1;
       }


        Node temp = cacheMap.get(key);
        if(temp == null) {
            return -1;
        }

        if(temp.key == mostRecent.key) {
            return temp.value;
        }

        else if(temp.key == leastRecent.key) {
            leastRecent = leastRecent.next;
            leastRecent.previous = null;
            size--;
            cacheMap.remove(key, temp);

        } else {
            // access the middle element
            Node prev = temp.previous;
            prev.next = temp.next;
            temp.next.previous = prev;
        }

        Node newNode = new Node(key, temp.value);
        newNode.next = null;
        newNode.previous = mostRecent;
        mostRecent.next = newNode;
        mostRecent = newNode;
        cacheMap.put(key, newNode);
        size++;
        return temp.value;
    }


    public static void main(String[] args) {
        int capacity = 2;
        LRUCache lru = new LRUCache(capacity);
       /* lru.put(1,1);
        lru.put(2,2);
        System.out.printf("OUTPUT %d \n ", lru.get(1));
        lru.put(3,3);
        System.out.printf("OUTPUT %d \n", lru.get(2));
        lru.put(4,4);
        System.out.printf("OUTPUT %d \n", lru.get(1));
        System.out.printf("OUTPUT %d \n", lru.get(3));
        System.out.printf("OUTPUT %d \n", lru.get(4));*/

      /*  lru.put(2,1);  // capacity 1
        System.out.printf("OUTPUT %d \n",lru.get(2));
        lru.put(3,2);
        System.out.printf("OUTPUT %d \n",lru.get(2));
        System.out.printf("OUTPUT %d \n ", lru.get(3));*/

        System.out.printf("OUTPUT %d \n", lru.get(2));
        lru.put(2,6);
        System.out.printf("OUTPUT %d \n", lru.get(1));
        lru.put(1,5);
        lru.put(1,2);
        System.out.printf("OUTPUT %d \n", lru.get(1));
        System.out.printf("OUTPUT %d \n", lru.get(2));

        lru.cacheMap.keySet().forEach(System.out::println);


    }

}

class Node {
    Node next;
    Node previous;
    int key;
    int value;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}