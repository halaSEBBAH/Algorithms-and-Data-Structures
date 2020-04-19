import java.util.*;
public class KMP {

    static int[] lps(char[] txt){
        int m = txt.length;
        int[] lps = new int[m];
        lps[0] = 0;
        int len = 0;
        int i = 1;

        while(i<m){
            if(txt[i] == txt[len]){
                lps[i] = len +1;
                len++;
                i++;
            }else{
                if(len != 0) len = lps[len-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }


    static void KMPalgo(char[] txt , char[] pat){
        int m = pat.length , n = txt.length;
        int i = 0, j = 0;
        int[] lps = lps(pat);
        while(i<n){
            if(j < m && pat[j] == txt[i]){
                i++;
                j++;
            }
            else if (i<n) {
                if(j == m) {
                    // we have a match do what u want
                    int start = i - m;
                    System.out.println("match at"+ start);
                    j = lps[j-1];
                }
                else if(j != 0) j = lps[j-1];
                else i++;
            }

        }


    }



    public static void main(String[] args){

        int[] res = lps("abxababxab".toCharArray());
        System.out.println(Arrays.toString(res));

        KMPalgo("abxababxab".toCharArray(), "abx".toCharArray());

    }



}
