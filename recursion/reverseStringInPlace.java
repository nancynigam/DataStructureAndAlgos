class Solution {
    public void reverseString(char[] s) {
        helper(0,s);
    }
    
    public void helper(int index,char[] str){
         if(str==null || index>=str.length)
            return;
        Character temp=str[index];
        helper(index+1,str);
        str[str.length-1-index]=temp;
     }
}
