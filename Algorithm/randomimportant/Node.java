package randomimportant;

public class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node() {
    }
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
