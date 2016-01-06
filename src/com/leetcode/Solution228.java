package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution228 {
	public int[] mergeSort(int[] nums){
		for(int i=0;i<nums.length;i++)
		{
			
		}
		return  nums;
	}
	public List<String> summaryRanges(int[] nums) {
		List<String> str=new ArrayList<String>();
		
		Arrays.sort(nums);
		int l=nums.length;

		if(l>0){
			int temp=nums[0];
			for(int i=1;i<l;i++){
				if(nums[i]!=nums[i-1]+1){
					String s="";
					if(temp==nums[i-1])
						s=temp+"";
					else 
			   	    s= temp+"->"+nums[i-1];
					str.add(s);
					temp=nums[i];
				}
			}
			if(temp!=nums[l-1]){
			String  s=temp+"->"+nums[l-1];
				str.add(s);}
			else str.add(""+temp);
			
		}
		return str;

	}
	public static void main(String args[]){
		List<String> str=new ArrayList<String>();
		Solution228 t=new Solution228();
		//int nums[]=new int [6];
		int []nums={0,1,2,4,5,7};
		str=t.summaryRanges(nums);
		for(int i=0;i<str.size();i++)
			System.out.println(str.get(i));
	}

}
