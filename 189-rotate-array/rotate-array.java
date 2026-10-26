class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;

        if (n == 0) return;

        k = k % n;
        int j = n-1;
        for(int i =0;i<j;i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        j = k -1;
        for(int i = 0;i<j;i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        j = n-1;
        for(int i = k;i<j;i++){
            int temp = arr[i];
            arr[i] =arr[j];
            arr[j] = temp;
            j--;
        }
    }
}