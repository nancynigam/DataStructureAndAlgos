//Check if TopologicalSort is possible or not => checking if there is a cycle or not :

  public boolean canFinish(int numCourses, int[][] prerequisites){
        LinkedList<Integer> [] edges = new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++)
            edges[i] = new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++)
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
         
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isCyclicUtil(i,visited,recStack,edges))
                return false;
        }
        return true;
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
  
