package leetcodedailyquestion.Jan2025;
import java.util.*;
public class Word_Subsets {
    public static void main(String[] args) {

    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>ans=new ArrayList<>();
        HashMap<Character,Integer>temp=helper(words2);
        for(String i:words1){
            HashMap<Character,Integer>a=getnumberofchar(i);
            boolean f=true;
            for(char j:temp.keySet()){
                if(!a.containsKey(j)){
                    f=false;
                    break;
                }
                if(a.get(j)<temp.get(j)){
                    f=false;
                    break;
                }
            }
            if(f)ans.add(i);
        }
        return ans;
    }
    private HashMap<Character, Integer> helper(String[] words2) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(String i:words2){
            HashMap<Character,Integer>b=getnumberofchar(i);
            for(char j: b.keySet()){
                if(map.containsKey(j)){
                    int max=map.get(j)<b.get(j)?b.get(j):map.get(j);
                    map.put(j,max);
                }
                else{
                    map.put(j,b.get(j));
                }
            }

        }
        return map;
    }

    private HashMap<Character, Integer> getnumberofchar(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return map;
    }
}
