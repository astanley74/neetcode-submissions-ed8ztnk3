class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length, nums2Len = nums2.length;
        int totalLen = nums1Len + nums2Len;
        if (totalLen % 2 == 1) {
            return getMed(nums1, nums2, totalLen / 2, 0, nums1Len - 1, 0, nums2Len - 1);
        } else {
            return (getMed(nums1, nums2, totalLen / 2 - 1, 0, nums1Len - 1, 0, nums2Len - 1) + getMed(nums1, nums2, totalLen / 2, 0, nums1Len - 1, 0, nums2Len - 1)) / 2.0;
        }
    }

    private double getMed(int[] nums1, int[] nums2, int k, int start1, int end1, int start2, int end2) {
        if (start1 > end1) {
            return nums2[k - start1];
        }
        if (start2 > end2) {
            return nums1[k - start2];
        }

        int mid1 = (start1 + end1) / 2, mid2 = (start2 + end2) / 2;
        int val1 = nums1[mid1], val2 = nums2[mid2];

        if (mid1 + mid2 < k) {
            if (val1 > val2) {
                return getMed(nums1, nums2, k, start1, end1, mid2 + 1, end2);
            } else {
                return getMed(nums1, nums2, k, mid1 + 1, end1, start2, end2);
            }
        } else {
            if (val1 > val2) {
                return getMed(nums1, nums2, k, start1, mid1 - 1, start2, end2);
            } else {
                return getMed(nums1, nums2, k, start1, end1, start2, mid2 - 1);
            }
        }
    }
}
