public class StringMatching{
    public static void main(String args[]) {
        String T = "abcabaabcabac";
        String P = "abaa";
        naive_String_Matching(T, P);
    }
    
    //Naive Pattern Matching Algorithm
    public static void naive_String_Matching(String T, String P) {
        int n = T.length();
        int m = P.length();
        for (int s = 0; s <= n - m; s++) {
            int i;
            for (i = 0; i < m; i++) {
                if (P.charAt(i) != T.charAt(i + s)) {
                    break;
                }
            }
            if (i == m ) {
                    System.out.println("Pattern occurs at shift = "+s);
                }
        }
    }
}