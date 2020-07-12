
import java.util.Arrays;

public class DACBinarySearch {

    public static void main(String[] args){
        int arr[] = { 2, 3, 4, 10, 40 };
        Arrays.sort(arr);
        int l=0;
        int r=arr.length-1;
        System.out.println(binarySearch(arr,l,r,3));
    }

    public static boolean binarySearch(int[] arr, int l, int r, int key){
        if(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == key)
                return true;
            if(arr[mid] < key)
                return binarySearch(arr,mid+1,r,key);
            else
                return binarySearch(arr,l,mid-1,key);
        }
        return false;
    }
}
