import java.util.PriorityQueue;
import java.util.Queue;

class KthLargestElement {
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargestElement(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

    public void print(){
        Queue<Integer> queue = new PriorityQueue<>(q);
        while(!queue.isEmpty())
            System.out.print(queue.poll() + " ");
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = {2,5,8,4};
        KthLargestElement kt = new KthLargestElement(3,nums);
        kt.add(3);
        kt.print();
        kt.add(5);
        kt.print();
        kt.add(10);
        kt.print();
        kt.add(9);
        kt.print();
        kt.add(4);
        kt.print();
    }
}
