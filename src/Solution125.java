class Solution125 {
    public boolean isPalindrome(String s) {
        String result=s.toLowerCase();
        int left=0;
        int right=result.length()-1;
        while(right>left){
            if(!((result.charAt(left)>='a'&&result.charAt(left)<='z')||(result.charAt(left)>='0'&&result.charAt(left)<='9'))){
                left++;
                continue;
            }
            if(!((result.charAt(right)>='a'&&result.charAt(right)<='z')||(result.charAt(right)>='0'&&result.charAt(right)<='9'))){
                right--;
                continue;
            }
            if(result.charAt(right)!=result.charAt(left))return false;
            left++;
            right--;
        }
        return true;
    }
}