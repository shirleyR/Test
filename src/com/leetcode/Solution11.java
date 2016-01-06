package com.leetcode;

//1.Container with most water

//2.Trapping rain water

// 水箱问题



public class Solution11 {
	
	// n non-negative integers a1,a2,...an, corresponding to(i,ai).
	// find two lines together with x-axis forms a container . 
	// such that the container contains the most water
	
	
	// max(min(height[i],height[j])*|i-j|)
	public int maxArea(int[] height) {
		
		// point 1: numbers of height may be same.
		
		int area=0;
		int len=height.length;
		int left[]=new int[len];
		int right[]=new int[len];
		if(len<=2)return 0;
		left[0]=0;
		left[len-1]=len-1;
		right[0]=0;
		right[len-1]=len-1;
		int total[]=new int[len];
		total[0]=height[0];
		for(int i=1;i<len;i++){
			if(height[i]>height[left[i-1]])
					left[i]=i;
			else left[i]=left[i-1];
			if(i>0)total[i]=total[i-1]+height[i];
		
			
		}
		
		for(int i=len-2;i>=0;i--){
			if(height[i]>height[right[i+1]]){
				right[i]=i;
			}else 
				right[i]=right[i+1];
		}
		
		
		for(int i=1;i<len;i++){
			int temp=Math.min(height[right[i]],height[left[i]])*(right[i]-left[i]-1)-(total[right[i]]-total[left[i]]-height[right[i]]);
			if(area<temp)area=temp;
		}
		return area;

	}
	public static void main(String args[]){
		Solution11 t=new Solution11();
		int height[]={5,4,1,2};
		System.out.println(t.maxArea(height));
		
	}
}
