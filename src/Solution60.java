import java.util.Arrays;

class Solution60 {
    int position;
    int whichNum(int n){
        int sum=1;
        for(int i=1;i<n;i++)
            sum*=i;
        int point=1;
        int uni=sum;
        while(uni<position){
            uni+=sum;
            point++;
        }
        uni-=sum;
        position-=uni;
        return point;

    }

    public String getPermutation(int n, int k) {
        String result="";
        int[] allNum=new int[n+1];
        allNum[0]=-1;
        for(int i=1;i<=n;i++){
            allNum[i]=i;
        }
        position=k;
        while(n>0){
            int theNum=whichNum(n);
            result+=allNum[theNum]+"";
            allNum[theNum]=20;
            Arrays.sort(allNum);
            n--;
        }
        return result;

    }
}