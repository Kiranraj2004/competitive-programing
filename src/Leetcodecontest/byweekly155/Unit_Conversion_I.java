package Leetcodecontest.byweekly155;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Unit_Conversion_I {
    public static void main(String[] args) {

    }
    static class Pair{
        int node;
        int convert;

        public Pair(int node,int convert) {
            this.node = node;

            this.convert=convert;
        }
    }
    public int[] baseUnitConversions(int[][] conversions) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        int n=conversions.length+1;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []i:conversions){
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        }
        Queue<Pair>q=new LinkedList<>();
        int []ans=new int[n];
        q.add(new Pair(0,1));
        ans[0]=1;

        while(!q.isEmpty()){
            int node=q.peek().node;
            int convert=q.peek().convert;
            q.poll();
            for(Pair i:adj.get(node)){
                int res=i.convert+convert;
                q.add(new Pair(i.node,res));
                ans[i.node]=res;
            }

        }
        return ans;
    }
}
