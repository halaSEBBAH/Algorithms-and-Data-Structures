import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {		
        String s = "leetcode";
        int[] alpha = new int[26];
        Arrays.fill(alpha,0);
        int n = s.length();

        for(int i = 0; i<n ; i++){
            alpha[s.charAt(i)-'a']++;
        }

    }    

}
