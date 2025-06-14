package Leetcodecontest.biweekly_contest_147;

public class Substring_Matching_Pattern {

    public static void main(String[] args) {
        String s="xlddxddlldxxdxxl";
        String p="x*dxd";
        System.out.println(hasMatch(s,p));

    }
    public static boolean hasMatch(String s, String p) {
        int i=p.indexOf('*');
        String left=p.substring(0,i);
        String right=p.substring(i+1);
        if(p.length()==1)return true;
        for (int j = 0; j <s.length() ; j++) {
            if(left.length()!=0){
                if(s.charAt(j)!=left.charAt(0)){
                    continue;
                }
                int si=j;
                int l=0;
                while((si<s.length()&&l<left.length())&&s.charAt(si)==left.charAt(l)){
                    si++;
                    l++;
                }
                if(l>=left.length()&&right.length()==0){
                    return true;
                }
                if(l<left.length())continue;

                while(si<s.length()){
                    int ri=0;
                    int sii=si;
                    while((sii<s.length()&&ri<right.length())&&s.charAt(sii)==right.charAt(ri)){
                        sii++;
                        ri++;
                    }
                    if(ri>=right.length())return true;
                    si++;
                }
            }
            else{
                int ri=0;
                int si=j;
                while((si<s.length()&&ri< right.length())&&right.charAt(ri)==s.charAt(si)){
                    si++;
                    ri++;
                }
                if(ri>=right.length())return true;
            }
        }
        return false;

    }
}
