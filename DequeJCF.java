import java.util.*;
public class DequeJCF {
    public static void main(String args[]) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addLast(4);
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
        d.removeFirst();
        System.out.println(d);
        System.out.println(d.getFirst() +":first element in the deque");
        System.out.println(d.getLast() + ":lasta element in the deque");
    }
}