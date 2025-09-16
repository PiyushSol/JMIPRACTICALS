import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "piyush";
        System.out.println(getLongestSubstring(s));
    }

    public static List<String> getLongestSubstring(String str){
        Set<Character> set = new HashSet<>();
        List<String>ans = new ArrayList<>();
        int s=0;
        int e=0;
        int maxlen =Integer.MIN_VALUE;
        for(;e<str.length();e++){
            while(set.contains(str.charAt(e))){
                set.remove(str.charAt(s));
                s++;
            }
            set.add(str.charAt(e));
            int curlen = e-s+1;
            if(curlen>maxlen){
                maxlen = curlen;
                ans.clear();
                ans.add(str.substring(s,e+1));
            } else if (curlen == maxlen) {
                ans.add(str.substring(s,e+1));
            }
        }
        return ans;
    }
}
