import java.util.ArrayList;
import java.util.List;

public class Main {
    // d is the number of characters in the input alphabet
    /* Driver program to test above function */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String txt = scan.next();
        String pat = scan.next();
        List<Integer> ans = Rabin_Karp.search(pat, txt);
        System.out.println("ans = " + ans);
    }
}


public class Rabin_Karp {
    public final static int BASE = 256;
    public final static int PRIME = 101;
    /* pat -> pattern
        txt -> text
    */
    static List<Integer> search(String pat, String txt)
    {
        List<Integer> list = new ArrayList<>();
        int patSize = pat.length();
        int txtSize = txt.length();
        int patHash = hashCode(pat, patSize);
        int txtHash = hashCode(txt, patSize);

        for (int i = 0; i <= txtSize - patSize; i++) {
            if(patHash == txtHash && pat.equals(txt.substring(i, i + patSize))){
                list.add(i);
            }
            if(i < txtSize - patSize){
                txtHash = reCalculateHashCode(txtHash, txt.charAt(i), txt.charAt(i + patSize), patSize);
                if(txtHash < 0) txtHash += PRIME;
            }

        }
        return list;
    }
    public static int pow(int patSize){
        int patHashMultiplier = 1;
        for (int i = 0; i < patSize - 1; i++) {
            patHashMultiplier = (patHashMultiplier * BASE) % PRIME;
        }
        return patHashMultiplier;
    }
    private static int reCalculateHashCode(int oldHash, char oldChar, char newChar, int length){
        return (BASE * (oldHash - oldChar * pow(length))
                + newChar) % PRIME;
    }
    private static int hashCode(String s, int length){
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (BASE * hash + s.charAt(i)) % PRIME;
        }
        return hash;
    }
}
