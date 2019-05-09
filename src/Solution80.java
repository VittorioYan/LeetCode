class Solution80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int minusLen = 0;
        boolean flag = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                if (flag) {
                    minusLen++;
                } else {
                    flag = true;
                    if (minusLen > 0) nums[i - minusLen] = nums[i];
                }
            } else {
                flag = false;
                if (minusLen > 0) nums[i - minusLen] = nums[i];
            }

        }
        return len-minusLen;

    }
}