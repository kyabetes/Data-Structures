class Node {
    int item;
    Node next;

    public Node(int item) {
        this.item = item;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void removeAfter(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    public Node copy() {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.item);
        Node current = head.next;
        Node newCurrent = newHead;
        while (current != null) {
            newCurrent.next = new Node(current.item);
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }

    public void removeDuplicate(int key) {
        if (head == null) {
            return;
        }
        while (head != null && head.item == key) {
            head = head.next;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.item == key) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public int max() {
        if (head == null) {
            return 0;
        }
        int max = head.item;
        Node current = head.next;
        while (current != null) {
            if (current.item > max) {
                max = current.item;
            }
            current = current.next;
        }
        return max;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(4);

        System.out.println("Original list:");
        list.printList();

        System.out.println("Removing node after head:");
        list.removeAfter(list.head);
        list.printList();

        System.out.println("Copying the list:");
        Node copiedHead = list.copy();
        LinkedList copiedList = new LinkedList();
        copiedList.head = copiedHead;
        copiedList.printList();

        System.out.println("Removing duplicates of 2:");
        list.removeDuplicate(2);
        list.printList();

        System.out.println("Maximum value in the list: " + list.max());
    }
}