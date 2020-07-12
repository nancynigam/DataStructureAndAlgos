
public class divideNconquer {

    public static void main(String[] args){
        int[] arr =  { 70, 250, 50, 80, 140, 12, 14 };
        System.out.println(DAC_Max(arr,0,7));
        System.out.println(DAC_Min(arr,0,7));
    }

    public static int DAC_Max(int[] arr, int index, int left){
        if(index>=left-2)
            return Math.max(arr[index],arr[index+1]);
        int max = DAC_Max(arr,index+1,left);
        return Math.max(max,arr[index]);
    }

    public static int DAC_Min(int[] arr, int index, int left){
        if(index>=left-2)
            return Math.min(arr[index],arr[index+1]);
        //System.out.print(" min = " + min);
        int min = DAC_Min(arr,index+1,left);
        return Math.min(min,arr[index]);
    }
}
