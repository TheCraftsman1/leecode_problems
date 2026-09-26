class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0;
        int maxc = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                c++;
            } 
            if(nums[i]==0 || i==nums.length-1){
                if(c>maxc){maxc = c;} 
                c =0;
            }
        }
        return maxc;
    }
}