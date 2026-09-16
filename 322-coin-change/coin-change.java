class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int [] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            dp[i] = amount +1;
            for(int c : coins){
                if(c<=i && dp[i-c]!=amount+1){
                    dp[i] = Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        if(dp[amount] == amount+1) return -1;
        return dp[amount];



    }
}