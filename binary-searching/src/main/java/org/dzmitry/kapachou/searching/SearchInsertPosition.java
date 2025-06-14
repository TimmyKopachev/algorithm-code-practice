package org.dzmitry.kapachou.searching;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
        System.out.println(searchInsert(new int[]{1, 3}, 4)); // 2

    }

    public static int searchInsert(int[] nums, int target) {
        return biSearcher(0, nums.length - 1, nums, target);
    }

    private static int biSearcher(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
