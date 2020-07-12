
public class Queue {
    int front,rear;
    int[] A;
    int size;

    Queue(int n){
      A = new int[n];
      front=rear=-1;
      size=n;
    }

    public static void main(String[] args){
        Queue queue = new Queue(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        System.out.println("front = "+ queue.front + " rear = "+queue.rear);
        queue.Enqueue(4);
        queue.print();
        queue.DeQueue();
        queue.print();
        queue.DeQueue();
        queue.print();
        queue.DeQueue();
        queue.print();


    }

    public void print(){
        for(int i=this.front;i<=this.rear&&rear>=0;i++)
            System.out.print(this.A[i] + " ");
        System.out.println();
    }
    public void Enqueue(int dt){
        if(isFull()){
            System.out.println("can't enqueue a full list");
            return;
        }
        else if(isEmpty()){
            rear=front=0;
        }
        else
            rear=rear+1;
        A[rear]=dt;
    }

    public void DeQueue(){
        if(isEmpty()){
            System.out.println("can't deque an empty list");
            return;
        }
        //On 1st element
        else if(front==rear){
            System.out.println("Removing the only element");
            front=rear=-1;
            return;
        }
        else{
            front++;
        }
    }

    public boolean isFull(){
        if(rear>=size-1)
            return true;
        else
            return false;
    }

    public boolean isEmpty(){
        if(front==rear && front==-1)
            return true;
        else
            return false;
    }
}
