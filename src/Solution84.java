class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        int result=0;
        for(int i=0;i<len;i++){
            int lowest=heights[i];
            for (int j=i;j<len;j++){
                lowest=Integer.min(lowest,heights[j]);
                result=Integer.max(result,lowest*(j-i+1));
            }
        }
        return result;
    }
}