import java.util.LinkedList;
import java.util.List;

class Solution22 {

    public static void generate(List<String> result,int leftNum,int rightNum,String nowStr){
        if(leftNum<0||rightNum<0)return;
        if(leftNum>rightNum)return;

        if(leftNum==0&&rightNum==0){
            result.add(nowStr);
            return;
        }
        if(leftNum>0) generate(result,leftNum-1,rightNum,nowStr+"(");
        if(rightNum>0)generate(result,leftNum,rightNum-1,nowStr+")");

    }

    public List<String> generateParenthesis(int n) {


        List<String> result=new LinkedList<>();
        if (n==0)return result;
        generate(result,n,n,"");

        return result;

    }
}