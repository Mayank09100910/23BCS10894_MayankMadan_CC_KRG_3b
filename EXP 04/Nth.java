public class Nth {
}class Solution {
    static final int MOD = 1_000_000_007;

    public int nthMagicalNumber(int n, int a, int b) {
        long low = Math.min(a, b);
        long high = (long) n * Math.min(a, b);

        long lcm = lcm(a, b);

        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = mid / a + mid / b - mid / lcm;

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % MOD);
    }

    private long gcd(long x, long y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }
}
