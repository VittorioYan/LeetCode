import java.util.ArrayList;
import java.util.List;

class Solution52 {
    boolean[] horIsExist;
    boolean[] verIsExist;
    boolean[] sumIsExist;
    boolean[] minusIsExist;
    int result;
//    List<List<String>> results;
//    int[] route;
    char[] tempChar;


    boolean notExist(int i,int j,int n){
        if(horIsExist[i])return false;
        if(verIsExist[j])return false;
        if(sumIsExist[i+j])return false;
        if(minusIsExist[i-j+n])return false;
        return true;
    }

    void dp(int line,int n){
        if(line==n){
//            List<String> result=new ArrayList<>();
//            for(int i=0;i<n;i++){
//                tempChar[route[i]]='Q';
//                result.add(String.valueOf(tempChar));
//                tempChar[route[i]]='.';
//                System.out.println(route[i]);
//            }
//            results.add(result);
            result++;
            return;
        }
        for(int j=0;j<n;j++){
            if(notExist(line,j,n)){
                horIsExist[line]=true;
                verIsExist[j]=true;
                sumIsExist[line+j]=true;
                minusIsExist[line-j+n]=true;
//                route[line]=j;
                dp(line+1,n);
                horIsExist[line]=false;
                verIsExist[j]=false;
                sumIsExist[line+j]=false;
                minusIsExist[line-j+n]=false;
            }
        }


    }

    public int totalNQueens(int n) {
        result=0;
        horIsExist=new boolean[n];
        verIsExist=new boolean[n];
        sumIsExist=new boolean[n*2];
        minusIsExist=new boolean[n*2];
//        route=new int[n];
//        results=new ArrayList<>();

        tempChar=new char[n];
        for(int i=0;i<n;i++)tempChar[i]='.';
        dp(0,n);

        return result;

    }
}