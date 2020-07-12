//https://www.sanfoundry.com/java-program-priority-queue/
import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueueHeaps {
    Task[] heap;
    int heapSize;
    int capacity;

    public PriorityQueueHeaps(int capacity){
        heapSize = 0;
        this.capacity = capacity;
        heap = new Task[capacity+1];
    }

    public void clear()
    {
        heapSize = 0;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** function to check if full **/
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }

    public void insert(Task item){
        heap[this.heapSize] = item;
        heapifyUp();
        heapSize++;
    }

    public void heapifyUp(){
        //System.out.println("Entering heapify of size = " + heapSize);
        int k=heapSize;
        while(k>0){
            int p = (k-1)/2;
            int item = heap[k].priority;
            int parent = heap[p].priority;
            if(item<parent){
                //System.out.println("Entering swap for item = "+item);
                swap(k,p);
                k=p;
            }
            else
                break;
        }
    }
    //you always delete only the max element
    public void delete() throws NoSuchElementException {
        if(heapSize<=0)
            throw new NoSuchElementException();
        else if(heapSize == 1){
            heap[--heapSize]=new Task(-1,0);
        }
        else{
            heap[0]=heap[heapSize-1];
            heapifyDown();
            heap[--heapSize]=new Task(-1,0);
        }

    }

    public void heapifyDown(){
        int k=0;
        int left = 2*k+1;
        while(left<heapSize){
            int right= 2*k+2;
            int max = left;
            if(right<heapSize){
                if(heap[right].priority<heap[max].priority)
                    max=right;
            }

            if(heap[k].priority>heap[max].priority){
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
            return heap[0].num;
        else
            throw new NoSuchElementException();
    }

    public void swap(int k, int p){
        Task tmp = heap[k];
        heap[k] = heap[p];
        heap[p] = tmp;
    }

    public void print(){
        for (int j=0;j<heapSize;j++) {
            System.out.println("j.num = " + heap[j].num + " " + " j.priority " + heap[j].priority);
        }
    }
    public static void main(String[] args) {
        PriorityQueueHeaps bh = new PriorityQueueHeaps(4);
        bh.insert(new Task(15,4));
       // bh.print();
       // System.out.println("**********************************");
        bh.insert(new Task(25,1));
        bh.insert(new Task(2,3));
        bh.insert(new Task(6,2));
        bh.print();


    }
}

class Task{
    int num;
    int priority;

    public Task(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }
}
