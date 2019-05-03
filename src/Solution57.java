import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution57 {
    class Corres implements Comparable<Corres>{
        int left;
        int right;
        Corres(int l,int r){
            left=l;
            right=r;
        }


        @Override
        public int compareTo(Corres o) {
            if(left==o.left)return 0;
            if(left<o.left)return -1;
            else return 1;
        }
    }

    public int[][] insert(int[][] intervals,int[] newInterval) {
        List<Corres> interval=new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            interval.add(new Corres(intervals[i][0],intervals[i][1]));
        }
        if(newInterval.length!=0)
        interval.add(new Corres(newInterval[0],newInterval[1]));
        if(interval.size()==0)return intervals;
        Collections.sort(interval);

        int point=0;
        int[][] result=new int[interval.size()][2];
        int nowL=interval.get(0).left;
        int nowR=interval.get(0).right;
        for(int i=1;i<interval.size();i++){
            int tempL=interval.get(i).left;
            int tempR=interval.get(i).right;
            if(tempL<=nowR)nowR=Math.max(nowR,tempR);
            else {
                result[point][0]=nowL;
                result[point][1]=nowR;
                nowL=tempL;
                nowR=tempR;
                point++;

            }

        }
        result[point][0]=nowL;
        result[point][1]=nowR;
        int[][] theRes=new int[point+1][2];
        for(int i=0;i<=point;i++){
            theRes[i][0]=result[i][0];
            theRes[i][1]=result[i][1];
        }


        return theRes;

    }
}