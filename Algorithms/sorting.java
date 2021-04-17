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
    
    static int[] selection(int[] arr){
        
        for(int i= 0; i<arr.length; i++) {
            int min_index = i;
            for(int j = i; j<arr.length; j++){
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }

            }
            int buffer = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = buffer;
        }

        return arr;
    }




    static int[] callMergeSort(int[] arr){
        mergeSort(0,arr.length-1,arr);
        return arr;
    }

    static void mergeSort(int left,int right,int[] arr){
        if(left >= right) return;
        int mid = (right+left)/2;
        mergeSort(left, mid,arr);
        mergeSort(mid+1,right,arr);
        merge(left,mid ,right,arr);
    }

    static void merge(int left,int mid,int right,int[] arr){
        
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
    
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];
    
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = arr[left+i];

        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = arr[mid+i+1];

        int leftIndex = 0;
        int rightIndex = 0;

        for(int i = left; i< right+1; i++){

            if(rightIndex < lengthRight && leftIndex < lengthLeft ){
                if(leftArray[leftIndex] <= rightArray[rightIndex]) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else{
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }

            else if(rightIndex < lengthRight){
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
            
            else if(leftIndex < lengthLeft ){
                arr[i] = leftArray[leftIndex];
                leftIndex++;
            }

        }


    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{4,5,2,7,3};
        System.out.print(Arrays.toString(callMergeSort(arr)));

        int[] arr2 = new int[]{3,5 ,7 ,8 ,4 ,2 ,1 ,9 ,6};
        System.out.print(Arrays.toString(callMergeSort(arr2)));

        int[] arr3 = new int[]{5,4,7,2,1};
        System.out.print(Arrays.toString(callMergeSort(arr3)));

        int[] arr4 = new int[]{5,4,3,2,1}; 
        System.out.print(Arrays.toString(callMergeSort(arr4)));

    }

}
