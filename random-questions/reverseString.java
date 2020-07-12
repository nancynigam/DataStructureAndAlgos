  // https://www.geeksforgeeks.org/reverse-words-in-a-given-string/
  // Complexity is O(n)
   public static void reverseString(String s){
        Stack<String> st = new Stack<>();
        //trim() takes care of leading & trailing spaces. 
        String[] arr = s.split(" ").trim();
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        while(!st.empty()){
            System.out.print(st.pop() + " ");
        }
    }
    
    
    //shorter solution to save space :
       String[] s = string.split(" ").trim();
       for (int i = s.length - 1; i >= 0; i--) { 
            ans += s[i] + " "; 
        } 
