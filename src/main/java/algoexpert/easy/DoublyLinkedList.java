package algoexpert.easy;

public class DoublyLinkedList {

    static class DoublyLinkedListImpl {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            Node oldhead = head;
            head = node;
            head.next = oldhead;
            oldhead.prev = head;
        }

        public void setTail(Node node) {
            Node oldtail = tail;
            oldtail.next = node;
            tail = node;
            tail.prev = oldtail;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            Node prev = node.prev;
            prev.next = nodeToInsert;
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            Node after = node.next;
            after.prev = nodeToInsert;
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            Node current = head;
            Node prev = null;
            Node next = head.next;
            while (position != 1) {
                prev = current;
                current = current.next;
                next = current.next;
                position--;
            }
            current = nodeToInsert;
            if (prev != null) prev.next = current;
            next.prev = current;
        }

        public void removeNodesWithValue(int value) {
            Node currentNode = head;
            while (true) {
                if (currentNode == tail) {
                    if (currentNode.value == value) currentNode = null;
                    return;
                }
                Node next = currentNode.next;
                if (currentNode.value == value) {
                    currentNode = null;
                }
                currentNode = next;
            }
        }

        public void remove(Node node) {
            // Write your code here.
        }

        public boolean containsNodeWithValue(int value) {
            Node current = head;
            while (current != tail) {
                current = current.next;
                if (current.value == value) return true;
            }
            return false;
        }

        static class Node {
            public int value;
            public Node prev;
            public Node next;

            public Node(int value) {
                this.value = value;
            }
        }
    }
}