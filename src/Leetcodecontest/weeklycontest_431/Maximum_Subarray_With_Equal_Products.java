package Leetcodecontest.weeklycontest_431;

public class Maximum_Subarray_With_Equal_Products {
    public static void main(String[] args) {


    }
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper method to compute LCM of two numbers
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;         // Product of the current subarray
            int curGcd = nums[i];  // GCD of the current subarray
            int curLcm = nums[i];  // LCM of the current subarray

            for (int j = i; j < n; j++) {
                // Update product
                prod *= nums[j];

                // Update GCD and LCM dynamically
                curGcd = gcd(curGcd, nums[j]);
                curLcm = lcm(curLcm, nums[j]);

                // Check the condition
                if (prod == (long) curGcd * curLcm) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
