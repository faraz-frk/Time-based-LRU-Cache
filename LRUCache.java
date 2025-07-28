import java.util.HashMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final long expiryMillis;

    private class Node {
        K key;
        V value;
        long timestamp;
        Node prev, next;

        Node(K key, V value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final HashMap<K, Node> map;
    private Node head, tail;

    public LRUCache(int capacity, long expiryMillis) {
        this.capacity = capacity;
        this.expiryMillis = expiryMillis;
        this.map = new HashMap<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);

        if (System.currentTimeMillis() - node.timestamp > expiryMillis) {
            removeNode(node);
            map.remove(key);
            return null;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        long now = System.currentTimeMillis();

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.timestamp = now;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value, now);
            if (map.size() == capacity) {
                map.remove(tail.key);
                removeNode(tail);
            }
            addNodeAtHead(newNode);
            map.put(key, newNode);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNodeAtHead(node);
    }

    private void addNodeAtHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;
        head = node;

        if (tail == null)
            tail = node;
    }

    private void removeNode(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }

    public void displayCache() {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.key + "=" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }
}
