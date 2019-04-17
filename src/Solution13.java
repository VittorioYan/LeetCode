class Solution13 {
    public int romanToInt(String s) {
        int result=0;
        int n=s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='M'){
                result+=1000;
                i++;
                continue;
            }
            if(s.charAt(i)=='D'){
                result+=500;
                i++;
                continue;
            }
            if(s.charAt(i)=='C'){
                if(i+1<n&&s.charAt(i+1)=='D'){
                    result+=400;
                    i+=2;
                    continue;
                }
                if(i+1<n&&s.charAt(i+1)=='M'){
                    result+=900;
                    i+=2;
                    continue;
                }
                result+=100;
                i++;
                continue;
            }
            if(s.charAt(i)=='L'){
                result+=50;
                i++;
                continue;
            }
            if(s.charAt(i)=='X'){
                if(i+1<n&&s.charAt(i+1)=='C'){
                    result+=90;
                    i+=2;
                    continue;
                }
                if(i+1<n&&s.charAt(i+1)=='L'){
                    result+=40;
                    i+=2;
                    continue;
                }
                result+=10;
                i++;
                continue;
            }
            if(s.charAt(i)=='V'){
                result+=5;
                i++;
                continue;
            }
            if(s.charAt(i)=='I'){
                if(i+1<n&&s.charAt(i+1)=='V'){
                    result+=4;
                    i+=2;
                    continue;
                }
                if(i+1<n&&s.charAt(i+1)=='X'){
                    result+=9;
                    i+=2;
                    continue;
                }
                result+=1;
                i++;
                continue;
            }


        }

        return result;
    }
}