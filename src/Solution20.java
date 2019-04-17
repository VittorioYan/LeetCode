import java.util.LinkedList;

class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> theStack=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(temp=='('||temp=='{'||temp=='['){
                theStack.push(temp);
            }
            else {
                if(theStack.isEmpty())return false;
                char tempPop=theStack.pop();
                if(s.charAt(i)==')'&&tempPop!='(')return false;
                if(s.charAt(i)=='}'&&tempPop!='{')return false;
                if(s.charAt(i)==']'&&tempPop!='[')return false;
            }
        }
        if(!theStack.isEmpty())return false;
        return true;


    }
}