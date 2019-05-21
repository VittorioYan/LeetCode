import java.util.ArrayList;
import java.util.List;

class Solution93 {
    List<String> result;
    void dp(String s,int len,int point,String route,int number){
        if(number==4){
            if(point==len)result.add(route.substring(0,route.length()-1));
            return;
        }
        if(point>=len)return;

        if(s.charAt(point)=='2'){
            if(point+3<=len&&(s.charAt(point+1)<'5'||(s.charAt(point+1)=='5'&&s.charAt(point+2)<='5')))
                    dp(s,len,point+3,route+s.substring(point,point+3)+'.',number+1);

        }
        if(s.charAt(point)=='1'){
            if(point+3<=len) {
                dp(s,len,point+3,route+s.substring(point,point+3)+'.',number+1);
            }
        }
        if(s.charAt(point)!='0'&&point+2<=len)
        dp(s, len, point + 2, route + s.substring(point, point + 2)+'.', number + 1);
        dp(s, len, point + 1, route + s.substring(point, point + 1)+'.', number + 1);


    }

    public List<String> restoreIpAddresses(String s) {
        result=new ArrayList<>();
        dp(s,s.length(),0,"",0);
        return result;

    }
}