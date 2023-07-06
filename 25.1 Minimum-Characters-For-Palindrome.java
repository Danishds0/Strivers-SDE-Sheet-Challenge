
public class Solution {

    public static int minCharsforPalindrome(String str) {
        //Write your code here
        int i = 0, j = str.length() - 1;
        int trim = j;
        int ans = 0;

        while(i < j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }
            else{
                ans++;
                i = 0;
                j = --trim;
            }
        }
        return ans;
    }

}
