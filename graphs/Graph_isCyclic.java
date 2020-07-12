package com.company;

import java.util.LinkedList;

public class Graph_isCyclic {
    private int V;
    private LinkedList<Integer> [] adjList;
    private static int gray=1,white=0,black=2;


    public Graph_isCyclic(int v) {
        V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
    }

    //1st method
    public boolean isCyclic(int v){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int i=0;i<V;i++){
            if(isCyclicUtil(i,visited,recStack))
                return true;
        }
        return false;
    }

    public boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack){
        //if it's coming up again and already in the stack => a cycle
        if(recStack[v])
            return true;
        //if it's already visited then for sure not a cycle. case : 1->0 and you start from 0
        if(visited[v])
            return false;

        visited[v]=true;
        recStack[v]=true;
        for(int k:adjList[v]){
            if(isCyclicUtil(k,visited,recStack))
                return true;
            }
        recStack[v]=false;
        return false;
        }

        //2nd method - color
        public boolean isCycle(int v){
            int[] color = new int[V];
            for(int i=0;i<V;i++){
                color[i]=white;
            }
            for(int i=0;i<V;i++){
                if(color[i] == white && DFSCycle(i,color)==true)
                    return true;
            }
            return false;
        }

    public boolean DFSCycle(int u, int[] color){
        color[u] = gray;
        for(int i:adjList[u]){
            if(color[i]==gray)
                return true;
            if(color[i]==white && DFSCycle(i,color)==true)
                return true;
        }
        color[u]=black;
        return false;
    }

}
