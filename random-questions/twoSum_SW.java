//https://leetcode.com/problems/two-sum/
class Solution {
    //This solution works because when you put {2,2,3} in map with values as keys :: 2:1,3:2
    //when you iterate the first 2 will be checked first
   public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(hm.containsKey(complement))
                return new int[]{hm.get(complement),i};
            else
                hm.put(nums[i],i);
        }
       throw new IllegalArgumentException("No two sum solution");
}
}


// 2 pointer solution
// this approach is for sorted arrays & doesn't work when array contains repeated number : {2,2,3}
//     public int[] twoSum(int[] arr, int target) {       
//         int i=0;
//         int j=arr.length-1;
//         while(i<j){
//             if (arr[i]+arr[j]==target)
//                 return new int[] {i,j};
//             else if(arr[i]+arr[j]<target)
//                 i++;
//             else
//                 j--;
//         }
//         throw new IllegalArgumentException("No two sum solution");
//     }
