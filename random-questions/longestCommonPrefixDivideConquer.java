public Solutions {
    public static String longestCommonPrefixDNC(String[] strs) {
         if (strs == null || strs.length <1)
            return "";
         return  longestCommonPrefixDNC(strs,0,strs.length-1);
     }
     
     private static String longestCommonPrefixDNC(String[] strs,int l, int r) {
         if (l == r)
            return strs[l];
        int mid = (l+r)/2;
        String lcp_left = longestCommonPrefixDNC(strs,l,mid);
        String lcp_right = longestCommonPrefixDNC(strs,mid+1,r);
        return commonPrefix(lcp_left, lcp_right);
     }
     
     public static String commonPrefix(String left, String right) {
         int min = Math.min(left.length(),right.length());
         for (int i=0; i<min; i++) {
             if (left.charAt(i)!=right.charAt(i))
                return left.substring(0,i);
         }
         return left.substring(0,min);
         
     }
}
