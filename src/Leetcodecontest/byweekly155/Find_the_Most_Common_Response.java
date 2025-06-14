package Leetcodecontest.byweekly155;

import java.util.*;

public class Find_the_Most_Common_Response {
    public static void main(String[] args) {

    }
    static class pair{
        String s;
        int count;

        public pair(String s,int count) {
            this.s=s;
            this.count = count;
        }
    }
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer>map=new HashMap<>();
        for(List<String>i:responses){
            HashSet<String>internal=new HashSet<>();
            for(String j:i){
                if(!internal.contains(j)){
                    internal.add(j);
                    map.put(j,map.getOrDefault(j,0)+1);
                }
            }
        }
        ArrayList<pair>arr=new ArrayList<>();
        for(String i:map.keySet()){
            arr.add(new pair(i, map.get(i)));
        }
        arr.sort((a, b) -> {
            if (a.count > b.count) return 1;
            if (a.count < b.count) return -1;
            return a.s.compareTo(b.s);
        });


        return arr.get(0).s;

    }
}

