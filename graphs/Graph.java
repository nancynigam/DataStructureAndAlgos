import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;

    public Graph(int v){
        V=v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++)
            adjList[i] = new LinkedList<Integer>();
    }

    //Adding edge to undirected graph
    public void addEdge(int src, int des){
        adjList[src].add(des);
    }

    //Printing normal graph
    public void print(){
        for(int i=0;i<V;i++){
            System.out.println("adjacency list of vertex " + i);
            System.out.print("head ");
            for(Integer j : adjList[i])
                System.out.print("  -> " + j);
            System.out.println();
        }
    }
