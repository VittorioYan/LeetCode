import java.util.LinkedList;

class Solution71 {
    LinkedList<String> stack;
    void changeStack(String path){
        char[] chars=path.toCharArray();
        int len=chars.length;
        if(len==0)return;
        int point=0;
        if(chars[point]=='.'){
            if(point+1==len-1&&chars[point+1]=='.'){
                if(!stack.isEmpty())stack.pop();
            }
            if(len<3) return;
        }
        stack.push(path);

    }


    public String simplifyPath(String path) {
        stack=new LinkedList<>();
        int point=0;
        int len=path.length();
        int left;
        while(point<len){
            while (point<len&&path.charAt(point)=='/') {
                point++;
            }
            left=point;
            while(point<len&&path.charAt(point)!='/')point++;
            String temp=path.substring(left,point);
            changeStack(temp);

        }
        String result="";
        String temp=stack.pollLast();
        if(temp==null)return "/";
        while (temp!=null){
            result+="/"+temp;
            temp=stack.pollLast();
        }

        return result;

    }
}