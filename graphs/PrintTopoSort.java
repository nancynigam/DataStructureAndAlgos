class PrintTopoSort {
    LinkedList<Integer> [] edges;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++)
            edges[i] = new LinkedList<>();
            
        //extra step since edges were given and not adjacency list
        for(int i=0;i<prerequisites.length;i++)
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack(); 
        for (int i = 0; i < numCourses; i++) 
            visited[i] = false; 
            
        for(int i=0;i<numCourses;i++){
          if(isCyclic(i,numCourses)){
              return new int[0];
          }
        }  
        
         for (int i = 0; i < numCourses; i++) 
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
  
        // Print contents of stack 
        int k=0;
        int[] arr = new int[numCourses];
        while (stack.empty()==false) {
            arr[k]=stack.pop();
            k++;
        }
        return arr;
    }
    
    void topologicalSortUtil(int v, boolean visited[], 
                             Stack stack) 
    { 
        // Mark the current node as visited. 
        visited[v] = true; 
        for(int k:edges[v]){
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
        }
        // Push current vertex to stack which stores result 
        stack.push(new Integer(v)); 
    } 
    
    public boolean isCyclic(int v, int numCourses){
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
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
}
