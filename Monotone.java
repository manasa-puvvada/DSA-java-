import java.util.*;
public class Monotone {
    public static boolean monotone(ArrayList<Integer> list) {
        boolean inc = true,dec = true;
        // for (int i = 0; i < list.size() - 1; i++) {
        //     if ((list.get(i) <= list.get(i + 1))) {
        //         inc = true;
        //     }
        //     if ((list.get(i) >= list.get(i + 1))) {
        //         dec = true;
        //     }
        // }
        // return inc || dec;
        boolean incmonotone = true;
        boolean decmonotone = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i) > list.get(i + 1))) {
                incmonotone = false;
            }
            if ((list.get(i) < list.get(i + 1))) {
                decmonotone = false;
            }
        }
        return incmonotone || decmonotone;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        //[1,2,2,3]
        //[6,5,4,4]
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(monotone(list));
    }
}