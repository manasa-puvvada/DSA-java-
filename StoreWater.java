import java.util.ArrayList;
public class StoreWater {
    public static int storeMaxWater(ArrayList<Integer> height) {
        //bruteforce - O(n^2)
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int width = j - i;
                int waterLevel = Math.min(height.get(i),height.get(j));
                int currWater = width*waterLevel;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }
    public static int storeMaxWater2(ArrayList<Integer> height) {
        //2 pointer approach - O(n)
        int lp = 0;
        int rp = height.size() - 1;
        int maxWater = 0;
        while(lp<rp) {
            int width = rp-lp;
            int ht = Math.min(height.get(lp),height.get(rp));
            int currWater = width*ht;
            if(lp<rp) {
                lp++;
            } else {
                rp--;
            }
            maxWater = Math.max(currWater,maxWater);
        }
        return maxWater;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
       
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeMaxWater2(height));

    }
}