import java.util.ArrayList;
import java.util.List;

class Solution89 {
    List<Integer> result=new ArrayList<>();

    boolean DFS(int count,int lstN,boolean[] lastNum,int n){
        if(count==0)return true;
        int turns=1;
        int temp;
        for(int i=0;i<n;i++){
            if(!lastNum[n-i-1]){
                temp=lstN+turns;
                if(!result.contains(temp)){
                    result.add(temp);
                    lastNum[n-i-1]=true;
                    if(DFS(count-1,temp,lastNum,n))
                        return true;
                    lastNum[n-i-1]=false;
                    result.remove(temp);
                }
            }
            else {
                temp=lstN-turns;
                if(!result.contains(temp)){
                    result.add(temp);
                    lastNum[n-i-1]=false;
                    if(DFS(count-1,temp,lastNum,n))
                        return true;
                    lastNum[n-i-1]=true;
                    result.remove(temp);
                }

            }
            turns<<=1;

        }
        return false;

    }

    public List<Integer> grayCode(int n) {
        result.add(0);
        if(n==0)return result;
        int numSize=(int)Math.pow(2,n)-1;
        boolean[] lastNum=new boolean[n];
        DFS(numSize,0,lastNum,n);

        return result;

    }
}