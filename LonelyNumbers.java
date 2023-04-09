import java.util.*;
public class LonelyNumbers  {
    public static void alone(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < a.size()-1; i++) {
            
            if (((a.get(i-1)+1) != ((a.get(i))) && ((a.get(i)+1) != ((a.get(i+1)))))) {
                res.add(a.get(i));

            }
        }
        if(a.size() == 1) {
            res.add(0);
        }
        if(a.size()>1){
            if((a.get(0)+1)!=a.get(1)) {
                res.add(a.get(0));
            }
            if(a.get(a.size()-2)!=a.get(a.size()-1)){
                res.add(a.get(a.size()-1));
            }
        }
        System.out.println(res);
    }
    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(6);
        a.add(5);
        a.add(8);
        alone(a);
    }
}