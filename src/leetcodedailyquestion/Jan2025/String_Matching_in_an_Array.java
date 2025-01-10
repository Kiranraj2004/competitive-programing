package leetcodedailyquestion.Jan2025;
import java.util.*;
public class String_Matching_in_an_Array {
    public static void main(String[] args) {
        String []s={"mass","ass","heras","superhero"};
        System.out.println(stringMatching(s));

    }
    public static List<String> stringMatching(String[] words) {
        List<String>ans=new ArrayList<>();
        Arrays.sort(words, (x, y) -> y.length()-x.length());
//        Arrays.sort(words, (x, y) -> Integer.compare(y.length(), x.length()));
        StringBuffer s=new StringBuffer();
        for (int i = 0; i <words.length ; i++) {
            String temp=words[i];
            if(s.indexOf(temp)!=-1){
                ans.add(temp);
            }
            s.append(temp);
            s.append(" ");
        }

        return ans;
    }
}
