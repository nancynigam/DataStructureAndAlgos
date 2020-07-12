class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0])
            return 0;
        int i=1;
        for(i=1;i<nums.length;i++) {
            if(nums[i] == target)
                break;
            if(nums[i-1] < target && target < nums[i]){
                break;
            }
        }
        return i;
    }
}
