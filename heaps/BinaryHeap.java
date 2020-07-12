import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
    int[] heap;
    int heapSize;

    public BinaryHeap(int capacity){
        heapSize = 0;
        heap = new int[capacity+1];
        Arrays.fill(heap,-1);
    }

    public void insert(int item){
        heap[this.heapSize] = item;
        heapifyUp();
        heapSize++;
    }

    public void heapifyUp(){
        //System.out.println("Entering heapify of size = " + heapSize);
        int k=heapSize;
        while(k>0){
            int p = (k-1)/2;
            int item = heap[k];
            int parent = heap[p];
            if(item>parent){
                //System.out.println("Entering swap for item = "+item);
                swap(k,p);
                k=p;
            }
            else
                break;
        }
    }
    //you always delete only the max element
    public void delete() throws NoSuchElementException{
        if(heapSize<=0)
            throw new NoSuchElementException();
        else if(heapSize == 1){
            heap[--heapSize]=-1;
        }
        else{
            heap[0]=heap[heapSize-1];
            heapifyDown();
            heap[--heapSize]=-1;
        }

    }

    public void heapifyDown(){
        int k=0;
        int left = 2*k+1;
        while(left<heapSize){
            int right= 2*k+2;
            int max = left;
            if(right<heapSize){
                if(heap[right]>heap[max])
                    max=right;
            }

            if(heap[k]<heap[max]){
                swap(k,max);
                k=max;
                left = 2*k+1;
            }
            else
                break;
        }

    }

    public int getMax() throws NoSuchElementException {
        if(heapSize>0)
            return heap[0];
        else
            throw new NoSuchElementException();
    }

    public void swap(int k, int p){
        int tmp = heap[k];
        heap[k] = heap[p];
        heap[p] = tmp;
    }

    public void print(){
        for (int i : heap) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap(10);
        bh.insert(15);
        System.out.println(bh.heapSize);
        bh.insert(10);
        System.out.println(bh.heapSize);
        bh.insert(9);
        bh.insert(8);
        bh.insert(9);
        bh.insert(6);
        bh.insert(3);
        bh.insert(12);
        bh.print();
        System.out.println();
        System.out.println("max = " + bh.getMax());
        bh.insert(22);
        bh.print();
        System.out.println("max = " + bh.getMax());
        bh.delete();
        bh.print();

    }
}
