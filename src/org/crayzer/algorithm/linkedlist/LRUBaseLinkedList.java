package org.crayzer.algorithm.linkedlist;

import java.util.Scanner;

/**
 * class_name: LRUBaseLinkedList
 * package: org.crayzer.algorithm.linkedlist
 * describe: 基于单链表LRU算法（java）
 * <p>
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，
 * 并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 如果此时缓存未满，则将此结点直接插入到链表的头部；
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 **/
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 5;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteNextElem(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteNextElem(SNode preNode) {
        preNode.next = preNode.next.next;
        // SNode temp = preNode.getNext();
        // preNode.setNext(temp.getNext());
        // temp = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        ptr.next = ptr.next.next;
        // SNode tmp = ptr.getNext();
        // ptr.setNext(null);
        // tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public class SNode<T> {

        private T element;

        private SNode<T> next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode<T> next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
