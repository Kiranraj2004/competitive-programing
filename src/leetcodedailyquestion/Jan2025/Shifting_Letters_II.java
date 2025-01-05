package leetcodedailyquestion.Jan2025;

public class Shifting_Letters_II {
    public static void main(String[] args) {
        System.out.println(backshift("abg",0,2));

    }

//    brute force method;
    public static String shiftingLetters1(String s, int[][] shifts) {
        for (int i = 0; i <shifts.length ; i++) {
            if(shifts[i][2]==0){
                s=backshift(s,shifts[i][0],shifts[i][1]);
            }
            else{
                s=forwardshift(s,shifts[i][0],shifts[i][1]);
            }
        }
        return s;
    }

    private static String forwardshift(String s, int start, int end) {
        StringBuilder s1=new StringBuilder(s);
        for (int i = start; i <=end ; i++) {
            if(s1.charAt(i)=='z'){
                s1.setCharAt(i,'a');
                continue;
            }
            int j=s.charAt(i)-'a';
            j++;
            s1.setCharAt(i, (char) ((char)j+'a'));
        }
        return s1.toString();
    }

    private static String backshift(String s, int start, int end) {
        StringBuilder s1=new StringBuilder(s);
        for (int i = start; i <=end ; i++) {
           if(s1.charAt(i)=='a'){
               s1.setCharAt(i,'z');
               continue;
           }
            int j=s.charAt(i)-'a';
           j--;
           s1.setCharAt(i, (char) ((char)j+'a'));
        }
        return s1.toString();
    }


//optimal based on difference range
    public static String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int []shift=new int[n];
        for (int[] ints : shifts) {
            if(ints[2]==0){
                shift [ints[0]]-=1;
                if(ints[1]<n){
                    shift[ints[1]+1]+=1;
                }
            }
            else{
                shift [ints[0]]+=1;
                if(ints[1]<n){
                    shift[ints[1]+1]-=1;
                }
            }
        }
        StringBuffer s1=new StringBuffer(s);
        int numberofshifts=0;
        for (int i = 0; i <s.length() ; i++) {
           numberofshifts=(numberofshifts+shift[i])%26;
           if(numberofshifts<0){
               numberofshifts+=26;
           }
           char a=(char)('a'+((s.charAt(i)-'a'+numberofshifts)%26));
           s1.setCharAt(i,a);
        }
        return s1.toString();
    }
}
