import java.util.ArrayList;
import java.util.List;

class Solution68 {
    String justify(int left,int right,int wordLen,int maxWidth,String[] words){
        String temp="";
        if(left==right){
            temp=words[left];
            while(temp.length()<maxWidth)temp+=" ";
            return temp;
        }
        int spaceNum=(maxWidth-wordLen)/(right-left);
        int addSpaceNum=(maxWidth-wordLen)%(right-left);
        String spaces="";
        while(spaceNum>0){
            spaces+=" ";
            spaceNum--;
        }
        for(int i=left;i<right;i++){
            temp+=words[i]+spaces;
            if(addSpaceNum>0){
                temp+=" ";
                addSpaceNum--;
            }
        }
        temp+=words[right];

        return temp;

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        String temp="";
        int point=0;
        int left=0;
        int wordLen=0;
        int remainLen=maxWidth;
        List<String> result=new ArrayList<>();

        while (point<words.length){
            if(words[point].length()>remainLen){
                result.add(justify(left,point-1,wordLen,maxWidth,words));
                remainLen=maxWidth;
                wordLen=0;
                left=point;
                temp="";
            }
            else {
                temp+=words[point]+" ";
                wordLen+=words[point].length();
                remainLen-=words[point].length()+1;
                point++;
            }

        }
        while(temp.length()<maxWidth)temp+=" ";
        result.add(temp.substring(0,maxWidth));

        return result;

    }
}