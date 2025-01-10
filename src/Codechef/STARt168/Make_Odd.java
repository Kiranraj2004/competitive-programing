package Codechef.STARt168;
import java.util.*;
public class Make_Odd {



        public static void main(String[] args) throws java.lang.Exception {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt(); // Number of test cases

            while (t-- > 0) {
                int n = in.nextInt();
                String a = in.next(); // First binary string
                String b = in.next(); // Second binary string

                if (canTransform(a, b, n)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        private static boolean canTransform(String a, String b, int n) {
            int a1 = 0, b1 = 0;

            // Count the number of '1's in both strings
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') a1++;
                if (b.charAt(i) == '1') b1++;
            }

            // Conditions for transformation
            if (a1 == 0 && b1 == 0) return false; // Both are all '0's
            if (a1 != b1) return true; // Unequal number of '1's
            if (a1 % 2 == 1 || b1 % 2 == 1) return true; // Odd number of '1's

            // Check if there's any mismatch between corresponding bits
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return true;
                }
            }

            return false;
        }
        
}
