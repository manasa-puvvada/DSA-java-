import java.util.LinkedList;

public class MergeSortLL {
    public Node getMid(Node head) {
        Node slow = head;
        Node Fast = head.next;
        while(fast != null && fast.next != null)  {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node head1,Node head2) {
        Node mergedLL = -1;
        Node temp  = mergedLL;
        while(head != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head.next; 
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null) {
            temp.next = head1;
            head1 = head.next; 
            temp = temp.next;           
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head == null && head.next == null) {
            return head;
        }
        Node mid = getMid(hesad);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        node newRight = mergeSort(newHead);
        merge(newLeft,newRight);

    }
    public static void main(String args[])  {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(6);
        ll.addLast(10);
        ll.addLast(1);
        ll.addLast(5);
        ll.addLast(null);
        System.oue.println(mergesort())
    }
}