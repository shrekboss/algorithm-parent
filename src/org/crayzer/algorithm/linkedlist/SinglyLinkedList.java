package org.crayzer.algorithm.linkedlist;


/**
 * class_name: SinglyLinkedList
 * package: org.crayzer.algorithm.linkedlist
 * describe:
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 **/
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;

        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }

        return p;
    }

    public void insertToHead(int value) {
        Node newNode = createNode(value);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToTail(int value) {
        Node newNode = createNode(value);
        insertToTail(newNode);
    }

    public void insertToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }

            newNode.next = p.next;
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = createNode(value);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null || head == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = createNode(value);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q.next != p) {
            q = q.next;
        }

        newNode.next = q.next;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (head == null || p == null) {
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q.next != p) {
            q = q.next;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value, boolean isRepeat) {
        if (head == null) {
            return;
        }

        if (isRepeat) {
            if (head.data == value) {
                head = head.next;
            }

            Node p = head;
            while (p.next != null) {
                if (p.next.data == value) {
                    p.next = p.next.next;
                    continue;
                }
                p = p.next;
            }
        } else {
            Node p = head;
            Node q = null;

            while (p.data != value) {
                q = p;
                p = p.next;
            }

            if (q == null) {
                head = head.next;
            } else {
                q.next = q.next.next;
            }
        }
    }

    public Node createNode(int value) {
        return new Node(value);
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 1
     * <p>
     * 2 1
     * <p>
     * 2 1 3 4
     * <p>
     * 2 1 3 5 4
     * 2 1 3 5 6 4
     * <p>
     * 7 2 1 3 5 6 4
     * 7 2 1 8 3 5 6 4
     * <p>
     * 7 2 1 3 5 6 4
     * 2 1 3 5 6 4
     * <p>
     * 2 1 3 5 6 4 6
     * 2 1 3 5 4
     */
    public static void main(String[] args) {

        SinglyLinkedList link = new SinglyLinkedList();
        link.insertToHead(1);
        link.printAll();
        link.deleteByNode(link.findByValue(1));
        link.printAll();

        link.insertToHead(1);
        link.insertToHead(2);
        link.printAll();
        System.out.println();

        link.insertToTail(3);
        link.insertToTail(4);
        link.printAll();
        System.out.println();

        // System.out.println(link.findByIndex(5));
        // System.out.println(link.findByValue(5));

        link.insertAfter(link.findByIndex(2), 5);
        link.printAll();
        link.insertAfter(link.findByValue(5), 6);
        link.printAll();
        System.out.println();

        link.insertBefore(link.findByValue(2), 7);
        link.printAll();
        link.insertBefore(link.findByIndex(3), 8);
        link.printAll();
        System.out.println();

        link.deleteByNode(link.findByIndex(3));
        link.printAll();
        link.deleteByValue(7, false);
        link.printAll();
        System.out.println();

        link.insertToTail(6);
        link.printAll();
        link.deleteByValue(6, true);
        link.printAll();
    }
}
