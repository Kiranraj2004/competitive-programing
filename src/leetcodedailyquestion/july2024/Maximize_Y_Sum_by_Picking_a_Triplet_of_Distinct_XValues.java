package leetcodedailyquestion.july2024;

import java.util.ArrayList;
import java.util.HashSet;

public class Maximize_Y_Sum_by_Picking_a_Triplet_of_Distinct_XValues {
    public static void main(String[] args) {

    }
    class pair{
        int val;
        int index;

        public pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n=x.length;
        ArrayList<pair>arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new pair(y[i],x[i]));
        }
        arr.sort((x1,y1)->y1.val-x1.val);
        int max=0;
        int i=0;
        HashSet<Integer>map=new HashSet<>();
        while(i<n&&map.size()!=3){
            if(!map.contains(arr.get(i).index)){
                max+=arr.get(i).val;
                map.add(arr.get(i).index);
            }
        }
        if(map.size()<3)return -1;
        return max;
    }
}
