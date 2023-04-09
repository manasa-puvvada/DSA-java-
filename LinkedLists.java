public class LinkedLists {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data) {
        //step1 - create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // newNode next = head
        newNode.next = head;
        // head = newNode
        head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print() {
        if( head ==null) {
            System.out.println("linked list is empty");
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }   
        System.out.println("null"); 
    }
    public void add(int idx,int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst() {
        if(size == 0) {
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast() {
        if(size == 0){
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null; 
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0;i < size-2;i++){
        prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int itrSearch(int key) {
        int i = 0;
        Node temp = head;
        while(temp !=  null) {
            if(temp.data == key) {
                return i;
            
        }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head,int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        } 
        int idx = helper(head.next,key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key) {
        return helper(head,key);
    }
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void deleteNthNode(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n == sz) {
            head = head.next;
            return;
        }
        int i = 0;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;//slow+1
            fast = fast.next.next;//fast+2
        }
        return slow;
    }
    public boolean checkPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        //step 1 - find mid
        Node mid = findMid(head);
        // step 2 - reverse second half
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //step 3 - check if first and second half are equal
        Node right  = prev;
        Node left = head;
        while(right != null) {
            if(right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }
    public static boolean isCycle(Node head) {//floyd's cycle finding algoirthm
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
            return false;
    }
    public static void removeCycle(Node head) {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow  == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle == false)  {
            return;
        }
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast   = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null) {
            if(head1.data<= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head) {
        if(head == null || head.next == null ) {
            return head;
        }
        Node mid  = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft,newRight);
    }
    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow =slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next ;
        while(curr != null) {
            next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }
        
        Node left = head;
        Node right = prev;
        Node nextL ;
        Node nextR;
        //alternate merging
        while(left != null && right != null ) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;

        }

    }
    public void deleteMNodes(int n,int m) {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        if(size == 1) {
            head = tail = null;
            return;
        }
        Node temp = head;
        int count = 0;
        while(n != 1) {
            temp = temp.next;
            n--;
        }
        while(m != 1) {
            temp.next = temp.next.next;
            m--;
        }
        return;
    }
        
    public static void main(String args[]) {
        LinkedLists ll = new LinkedLists(); 
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3); 
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.print();
        ll.deleteMNodes(2,2);
        ll.print();
        // head = new Node(1); // creating ll for cycle/loop in linked list
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        //1->2->3->1
          
        // System.out.println(isCycle(head)); 
        // removeCycle(head);
        // System.out.println(isCycle(head));     
        // LinkedLists ll = new LinkedLists ();
       
        // ll.addFirst(2);
        
        // ll.addFirst(1);
       
        // ll.addLast(3);
        
        // ll.addLast(4);

        // ll.add(2,9);

        // ll.print();

        // System.out.println(ll.checkPalindrome());

        // ll.print();
        
        //System.out.println(size);

    }
}