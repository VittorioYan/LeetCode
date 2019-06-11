import java.util.ArrayList;
import java.util.List;

class Solution115 {
    List<Integer>[] sCharPos;
    int[][] dp;
    int dfs(String t,int sPoint,int tPoint){
        if(tPoint==t.length()){
            return 1;
        }
        if(sPoint>=0&&dp[sPoint][tPoint]>=0)return dp[sPoint][tPoint];
        int thisChar=t.charAt(tPoint);
        List<Integer> thisPos=sCharPos[thisChar];
        int temp=0;
        for(int i=0;i<thisPos.size();i++){
           if(thisPos.get(i)>sPoint)
               temp+=dfs(t,thisPos.get(i),tPoint+1);
        }
        if(sPoint>=0)dp[sPoint][tPoint]=temp;
        return temp;
    }

    public int numDistinct(String s, String t) {
        int lenS=s.length();
        int lenT=t.length();
        dp=new int[lenS+1][lenT+1];
        for(int i=0;i<lenS;i++){
            for(int j=0;j<lenT;j++)dp[i][j]=-1;
        }
        sCharPos=new ArrayList[128];
        for(int i=0;i<128;i++)sCharPos[i]=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            sCharPos[s.charAt(i)].add(i);
        }
        int a=dfs(t,-1,0);
        return dfs(t,-1,0);

    }
}