package com.leetcode;

/**
 *  O(log(n+m))
 *  two sorted Arrays find the median
 *  
 *  !!!  empty arrays
 * @author rsl
 *
 */

public class Solution4 {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        double median=0;
	        int len1=nums1.length;
	        int len2=nums2.length;
	     
	       
	        if((len1+len2)%2==0){
	        	// even
	        	if(len1==0){
		        	if(len2==0)return 0;
		        	else
		        		return (nums2[len2/2]+nums2[len2/2-1])/2.0;
		        }
		        if(len2==0){
		        	return (nums1[len1/2]+nums1[len1/2-1])/2.0;
		        }
	        	double sum=0;
	        	int l=0;
	        	int p1=0,p2=0;
	        	int fin=(len1+len2)/2+1;
	        	while(l<=fin){
	        		if(p1<len1&&p2<len2&&nums1[p1]<nums2[p2]){
	        			p1++;
	        			l++;
	        			if(l==fin-1){
	        				sum+=nums1[p1-1];
	        			}else
	        			if(l==fin){
	        				
	        				return (sum+nums1[p1-1])/2.0;
	        			}
	        			
	        		}else if(p1<len1&&p2<len2&&nums1[p1]==nums2[p2]){
	        			p2++;
	        			p1++;
	        			l=l+2;
	        			if(l==fin){
	        				return nums2[p2-1];
	      
	        			}else if(l==fin-1) sum=nums2[p2-1];
	        			else if(l>fin) return (nums2[p2-1]+sum)/2;
	        			
	        		}else if(p1<len1&&p2<len2&&nums1[p1]>nums2[p2]){
	        			p2++;
	        			l++;
	        			if(l==fin-1){
	        				sum=nums2[p2-1];
	        			}else
	        			if(l==fin){
	        				return (sum+nums2[p2-1])/2.0;
	        			}
	        			
	        		}else if(p1==len1){
	        			int temp=fin-l+p2-1;
	        			l++;
	        			
	        			
	        			if(l==fin){
	        				return (sum+nums2[temp])/2.0;
	        			}else return (nums2[temp]+nums2[temp-1])/2.0;
	        		}else if(p2==len2){
	        			int temp=fin-l+p1-1;

	        			l++;
	        			
	        			if(l==fin){
	        				return (sum+nums1[temp])/2.0;
	        			}else return (nums1[temp]+nums1[temp-1])/2.0;
	        		}
	        		
	        	}
	        }else {
	        	
	        	if(len1==0){
		        	if(len2==0)return 0;
		        	else
		        		return nums2[len2/2];
		        }
		        if(len2==0){
		        	return nums1[len1/2];
		        }
	        	int l=0;
	        	int p1=0,p2=0;
	        	int fin=(len1+len2)/2+1;
	        	while(l!=fin){
	        		if(p1<len1&&p2<len2&&nums1[p1]<nums2[p2]){
	        			p1++;
	        			l++;
	        			if(l==fin){
	        				return nums1[p1-1];
	        			}
	        			
	        		}else if(p1<len1&&p2<len2&&nums1[p1]==nums2[p2]){
	        			p2++;
	        			p1++;
	        			l=l+2;
	        			if(l>=fin){
	        				return nums1[p1-1];
	        			}
	        			
	        		}else if(p1<len1&&p2<len2){
	        			p2++;
	        			l++;
	        			if(l==fin){
	        				return nums2[p2-1];
	        			}
	        			
	        		}else if(p1==len1){
	        			
	        			int temp=fin-l+p2-1;
	        			return nums2[temp];
	        		}else if(p2==len2){
	        			int temp=fin-l+p1-1;
	        			return nums1[temp];
	        		}
	        		
	        	}
	        	
	        }
	        return median;
	 }
	 
	 public static void main(String args[]){
		 Solution4 t=new Solution4();
		 int nums1[]={1};
		 int nums2[]={2,3,4,5,6};
		 System.out.println(t.findMedianSortedArrays(nums1,nums2));
	 }
}
