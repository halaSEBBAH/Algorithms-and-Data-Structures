import java.util.*;
import java.io.*;


public class sorting {
    

    static int[] bubble(int[] arr){

        boolean allGood = true;     
        for(int i = 0; i<arr.length; i++){
            allGood = true;
            for(int j = 0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]) {
                    allGood = false;
                    int buff =  arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = buff;
                }
            }
            if(allGood) break;    
        }

        return arr;
    }


    


    public static void main(String[] args) {
        
        int[] arr = new int[]{4,5,2,7,3};
        System.out.print(Arrays.toString(bubble(arr)));

    }

}
