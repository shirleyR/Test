package com.leetcode;

import java.lang.*;
/**
 *  reverse the string then find the LCS (Continue)  between reversed and original
 * @author rsl
 *   http://www.felix021.com/blog/read.php?2040
 */
public class Solution5 {

	//O(n)
	//从中间向两边展开的思路很好，Leetcode上很多题目都是从中间展开的
	public String longestPalindrome(String s) {

		String substr="";
		String revstr="";


		return substr;
	}


	public String preProcess(String s)
	{
		int n=s.length();
		if(n==0)return "^$";
		String ret="^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substring(i, 1);
		ret += "#$";
		return ret;
	}
	public String LongestPalindrome(String s){
		String T=this.preProcess(s);
		int n=T.length();
		int P[]=new int[n];
		int C=0,R=0;
		for(int i=1;i<n-1;i++){
			int i_mirror=2*C-i;
			P[i]=(R>i)?Math.min(R-i,P[i_mirror]):0; //??

			// attemp to expand palindrome centered at i

			while(T.charAt(i+1+P[i])==T.charAt(i-1-P[i])){
				P[i]++;

				// If palindrome centered at i expand past R
				// adjust center based on expanded palindrome 
				if(i+P[i]>R){
					C=i;
					R=i+P[i];
				}
			}
		}

		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n-1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}
		return s.substring((centerIndex - 1 - maxLen)/2, maxLen);
	}






















	//O(n^2)
	public String longestPalindrome2(String s) {

		String substr="";
		String revstr="";
		int len=s.length();
		for(int i=0;i<len;i++){
			revstr+=s.charAt(len-1-i);
		}

		int nTmpArray1[]=new int[len];
		int nTmpArray2[]=new int [len];

		// find the diagonal
		// ***
		//  ** 
		// method 1 :quick to get the longest    (TLE)


		int maxlen=0;
		int position=0;
		for(int i=0;i<len;i++){
			// O(n2)
			for(int j=0;j<len;j++){
				if(revstr.charAt(i)==s.charAt(j)){
					if(j>0){
						nTmpArray2[j]=nTmpArray1[j-1]+1;
					}else{
						nTmpArray2[j]=1;
					}
					if(nTmpArray2[j]>maxlen){
						maxlen=nTmpArray2[j];
						position=j;
					}
				}else{
					nTmpArray2[j]=0;

				} 
			}


			for(int k=0;k<len;k++){
				nTmpArray1[k]=nTmpArray2[k];
			}
		}

		substr=s.substring(position-maxlen+1,position+1);
		return substr;
	}
	public static void main(String args[]){

		Solution5 t=new Solution5();
		String s="adbd";
		System.out.println(t.longestPalindrome(s));
	}
}
