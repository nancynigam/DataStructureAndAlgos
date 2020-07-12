//longestCommonPrefix brutetforce 
class Solution {
      public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String sub_string = "";
        int smallest=smallest(strs);
        //System.out.println(smallest);
        for(int i=0;i<smallest;i++) {
            Character a = strs[0].charAt(i);
            int j=0;
            for(j=0;j<strs.length;j++) {
                if (strs[j].charAt(i)!=a)
                    break;
                }
                if (j==strs.length)
                    sub_string=sub_string+a;
                else
                    break;

            }
            return sub_string;
        }
        
        public static int smallest(String[] strs) {
            int smallest=strs[0].length();
            String smallest_string=strs[0];
            for(String i:strs) {
                if(i.length()<smallest)
                    smallest=i.length();
            }
            return smallest;
        }
    }