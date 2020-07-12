class Solution {
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        
        int n = s.length();
        int res=0;
        for (int i=0; i<n; i++) {
            String a = String.valueOf(s.charAt(i));
            String b = "";
            if((i+1) < n) {
               b = String.valueOf(s.charAt(i+1));
                if(map.get(b) > map.get(a)) {
                    res=res+map.get(b)-map.get(a);
                    i=i+1;
                } 
                else {
                    res=res+map.get(a);
                    //System.out.println(res);
                }
            }
            else {
                res=res+map.get(a);
                //System.out.println(res);
            }

        }
        return res;
    }
}