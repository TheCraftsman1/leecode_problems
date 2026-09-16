class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array to optimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int halfLength = (totalLength + 1) / 2; // Number of elements in the left partition

        int low = 0;
        int high = m; // Binary search range for partition point in nums1

        while (low <= high) {
            int partitionX = low + (high - low) / 2; // Partition point in nums1
            int partitionY = halfLength - partitionX; // Partition point in nums2

            // Calculate elements at the boundaries of the partitions
            // If partitionX is 0, there are no elements from nums1 in the left partition, so maxLeftX is -infinity
            // If partitionX is m, all elements from nums1 are in the left partition, so minRightX is +infinity
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if the partition is correct
            // A correct partition satisfies:
            // 1. maxLeftX <= minRightY
            // 2. maxLeftY <= minRightX
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We found the correct partition
                if (totalLength % 2 == 0) {
                    // Even total length, median is average of two middle elements
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // Odd total length, median is the single middle element (the largest in the left partition)
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // We are too far right in nums1, need to move left
                high = partitionX - 1;
            } else { // maxLeftY > minRightX
                // We are too far left in nums1, need to move right
                low = partitionX + 1;
            }
        }
        // This line should theoretically not be reached if inputs are valid sorted arrays
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}