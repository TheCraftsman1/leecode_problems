class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        boolean ans = false;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[count]==nums[i]) return true;
            count++;
        }
        return false;
    }
}