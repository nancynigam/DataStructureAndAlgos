public class Graph_dfs {
    private int V;
    private LinkedList<Integer>[] adjList;
    private static int gray=1,white=0,black=2;

    public Graph_dfs(int v){
        V=v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++)
            adjList[i] = new LinkedList<Integer>();
    }

    //Adding edge to directed graph
    public void addEdge(int src, int des){
        adjList[src].add(des);
        //for undirected graph : graph.adjList[des].add(src);
    }
     
       public void DFSUtilR(int v, boolean[] visited){
        visited[v]=true;
        System.out.print(v+" -> ");
        Iterator<Integer> iterator = adjList[v].iterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            //System.out.print(n + " ");
                if(!visited[n]){
                    DFSUtilR(n,visited);
            }
        }
        System.out.println();
    }

    public void DFS(int v){
        boolean[] visited = new boolean[V];
        //DFSUtil(v,visited);
        for(int i=0;i<V;i++){
            if(!visited[i]){
                System.out.println("***");
                DFSUtilR(i,visited);
            }

        }
    }
    
        //DFS iterative
    public void DFSI(int n){
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        st.push(n);
        while(!st.empty()) {
            n = st.pop();
            //System.out.println("popped element = "+ n);

            if (!visited[n]) {
                visited[n] = true;
                System.out.print(n + " ");
                Iterator<Integer> itr = adjList[n].iterator();
                while (itr.hasNext()) {
                    int k = itr.next();
                    if (!visited[k])
                        st.push(k);
                }
//                System.out.print(" stack = ");
//                print_stack(st);
//                System.out.println();
            }
        }
    }
}
