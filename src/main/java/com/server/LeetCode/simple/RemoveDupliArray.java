package com.server.LeetCode.simple;

/**
 * 删除数组中的重复项
 *
 *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDupliArray {

    public int removeDuplicates(int[] nums) {
        int length= nums.length;
        int i =0;
        while(i<length){
            int j = i+1;
            if(j<length&&nums[i]==nums[j]){
                while(j<nums.length-1){
                    nums[j]=nums[j+1];
                    j++;
                }
               length--;
                display(nums,length);
                continue;
            }
            i++;
        }
        return length;
    }

    public void display(int[] nums,int length){
        for(int i =0;i<length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
          RemoveDupliArray r = new RemoveDupliArray();
            int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
           System.out.println(r.removeDuplicates(nums));
    }

}
