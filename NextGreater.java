import java.util.*;
public class NextGreater {
    public static void main(String args[]) {//O(n)
        Stack <Integer> s = new Stack<>();
        int arr[] = {6,8,0,1,3};
        int nxtGreater[] = new int [arr.length];
        for(int i = arr.length -1 ; i >= 0; i--) {
            while(!s.isEmpty() &&   arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
        //nextGreater right
        //next greater left
        //next smallest left
        //next smallest right
    }
}