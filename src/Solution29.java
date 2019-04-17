class Solution29 {
    public int divide(int dividend, int divisor) {
        boolean isMinus = (dividend ^ divisor) < 0;
        long _dividend = Math.abs((long)dividend);
        long _divisor = Math.abs((long)divisor);
        int cnt = 0;
        for (int i = 31; i >= 0; --i) {
            if (_dividend >> i >= _divisor) {
                cnt += 1 << i;
                _dividend -= _divisor << i;
            }
        }
        if (isMinus) cnt = -cnt;
        if (isMinus == false && cnt < 0) cnt = Integer.MAX_VALUE;
        return cnt;
    }
}