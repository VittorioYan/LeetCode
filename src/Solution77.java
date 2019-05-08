import java.util.ArrayList;
import java.util.List;

class Solution77 {
    List<List<Integer>> result;

    void DFS(int n,int k,List<Integer> route){
        if(k==0){
            result.add(route);
            return;
        }
        if(n==0)return;
        List<Integer> temp=new ArrayList<>(route);
        temp.add(n);
        DFS(n-1,k-1,temp);
        DFS(n-1,k,route);

    }

    public List<List<Integer>> combine(int n, int k) {
        result=new ArrayList<>();
        if(n==0||k==0||k>n)return result;

        DFS(n,k,new ArrayList<>());
        return result;

    }
}