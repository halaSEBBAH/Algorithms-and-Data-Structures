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

    static int[] bubble2(int[] arr){

        boolean sorted = false;
        
        while(!sorted){
            sorted = true;
            for(int j = 0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]) {
                    sorted = false;
                    int buff =  arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = buff;
                }
            }
        }

        return arr;
    }

    // comp n²
    static int[] insertion(int[] arr){
        int n = arr.length;
        int i = 1;
        
        while(i<n){
            while(i<n && arr[i] >= arr[i-1]){
                i++;
            }
            int j = i;
            while(j > 0 && arr[j] <= arr[j-1]){
                int buffer = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = buffer;
                j--;
            }
            i++;
        }
        return arr;
    }


    static int[] insertion2(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i;
            while(j>0 && current < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current; 
        }
        return arr;
    }



    

    public static void main(String[] args) {
        
        int[] arr = new int[]{4,5,2,7,3};
        System.out.print(Arrays.toString(bubble2(arr)));

        int[] arr2 = new int[]{3,5 ,7 ,8 ,4 ,2 ,1 ,9 ,6};
        System.out.print(Arrays.toString(bubble2(arr2)));

        int[] arr3 = new int[]{5,4,7,2,1};
        System.out.print(Arrays.toString(bubble2(arr3)));

        int[] arr4 = new int[]{5,4,3,2,1}; 
        System.out.print(Arrays.toString(bubble2(arr4)));


    }

}
