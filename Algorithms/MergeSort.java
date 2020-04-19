import java.util.Arrays;

public class MergeSort {

    static void divideandmerge(int[] arr , int deb , int fin){
        if(deb >= fin ) return ;
        int m = (deb+fin)/2;
        divideandmerge(arr, deb, m);
        divideandmerge(arr, m+1, fin);
        merge(arr , deb , fin );
    }

    static void merge(int[] arr, int deb , int fin){
        int[] copy = new int[fin-deb+1];
        int m = (deb+fin)/2;

        int i = deb;
        int j = m+1;
        int ind = 0;

        while(i<=m && j<=fin){
            if(arr[i] <= arr[j]) {
                copy[ind] = arr[i];
                ind++;
                i++;
            }else{
                copy[ind] = arr[j];
                ind++;
                j++;

            }

        }

        while(i<=m){
            copy[ind] = arr[i];
            ind++;
            i++;
        }

        while(j<=fin){
            copy[ind] = arr[j];
            ind++;
            j++;
        }

        for(int l = deb; l<=fin ; l++) arr[l] = copy[l-deb];

    }



    public static void main(String[] args){
        int[] arr = {5,1,6,2,4,78,3};
        int deb = 0;
        int fin = arr.length-1;
        divideandmerge(arr,deb,fin);
        System.out.println(Arrays.toString(arr));
    }


}
