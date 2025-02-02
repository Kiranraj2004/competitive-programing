package Leetcodecontest.jan2025;
import java.util.*;
public class Count_mention_in_users {
    public static void main(String[] args) {

    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((x, y) -> {
            int timeComparison = Integer.parseInt(x.get(1)) - Integer.parseInt(y.get(1));
            if (timeComparison == 0) {
                if (x.get(0).equals("OFFLINE") && !y.get(0).equals("OFFLINE")) {
                    return -1;
                } else if (!x.get(0).equals("OFFLINE") && y.get(0).equals("OFFLINE")) {
                    return 1;
                }
            }
            return timeComparison;
        });
        int[] mentions=new int[numberOfUsers];
        int []offline=new int[numberOfUsers];
        int all=0;
        for(List<String>i:events){
            int timestamp=Integer.parseInt(i.get(1));
            if(i.get(0).equals("MESSAGE")){
                    if(i.get(2).equals("ALL")){
                        all++;
                    }
                    else if(i.get(2).equals("HERE")){
                        for (int j = 0; j <numberOfUsers ; j++) {
                            if(offline[j]<=timestamp){
                                mentions[j]++;
                            }
                        }
                    }
                    else{
                        String []s=i.get(2).split(" ");
                       for(String j:s){
                           String a=j.substring(2);
                           int index=Integer.parseInt(a);
                           mentions[index]++;
                       }

                    }
            }
            else{
                int index=Integer.parseInt(i.get(2));
                offline[index]=timestamp+60;
            }
        }
        for (int i = 0; i <numberOfUsers ; i++) {
            mentions[i]+=all;
        }
        return mentions;
    }
}
