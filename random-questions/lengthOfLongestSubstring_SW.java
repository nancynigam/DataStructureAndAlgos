//https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
//Remember it's a substring and not a subarray
public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans=0;
        if(s==null || n==0)
            return 0;
        else if(n==1)
            return 1;
        Map<Character, Integer> hm = new HashMap<>();
        
        for(int j=0,i=0;j<n;j++){
            if(hm.containsKey(s.charAt(j))){
                i=Math.max(i,hm.get(s.charAt(j)));
            }
            ans = Math.max(ans, j-i+1);
            //here j+1 is imp bcz string is indexed from 0 and since for i we do hm.get(), we need i to reach the next element after the repeated one.
            hm.put(s.charAt(j),j+1);
        }
        return ans;
    }
