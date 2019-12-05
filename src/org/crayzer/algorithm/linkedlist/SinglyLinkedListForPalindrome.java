package org.crayzer.algorithm.linkedlist;

public class SinglyLinkedListForPalindrome extends SinglyLinkedList{

    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            Node p = head;
            Node q = head;

            if (q.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            while (q.next != null && q.next.next != null) {
                q = q.next.next;
                p = p.next;
            }

            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            //　p 一定为整个链表的中点，且节点数目为奇数
            if (q.next == null) {
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点"+leftLink.data);
                System.out.println("右边第一个节点"+rightLink.data);
            } else {
                //p q　均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }

            return TFResult(leftLink, rightLink);
        }
    }

    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        boolean flag=true;
        System.out.println("left_:"+l.data);
        System.out.println("right_:"+r.data);
        while(l != null && r != null){
            if (l.data == r.data){
                l = l.next;
                r = r.next;
                continue;
            }else{
                flag=false;
                break;
            }

        }

        System.out.println("什么结果");
        return flag;
       /* if (l==null && r==null){
           System.out.println("什么结果");
           return true;
        }else{
           return false;
        }*/
    }

    private Node inverseLinkList(Node middleNode) {
        Node pre = null;
        Node cur = head;
        Node tmp;

        while (cur != middleNode) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        cur.next = pre;
        return pre;
    }

    public static void main(String[] args) {
        SinglyLinkedListForPalindrome link = new SinglyLinkedListForPalindrome();

        // int data[] = {1,2,2,1};
        int data[] = {1,2,5,2,1};
        // int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            link.insertToTail(data[i]);
        }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
