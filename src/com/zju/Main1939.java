package com.zju;


import java.util.Scanner;
import java.lang.String;
import java.util.Vector;
import java.util.Iterator;

public class Main1939 {
	
	// LCS  with path
	 static int dp[][];
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=0;
		String s1=new String();

		String s2=new String();
		while(n<2){
			String stemp=in.next();
			
			if(stemp.equals("#")){
			 	n++;
			}else {
				if(n==0){
						s1+=stemp;
				}else {
						s2+=stemp;
				}
				
			}
		}
		
		String st1[]=s1.split(" ");
		String st2[]=s2.split(" ");
		
		dp=new int[st1.length+1][st2.length+1];
		
		for(int i=1;i<st1.length+1;i++){
			String str=st1[i];
			
			for(int j=1;j<st2.length+1;j++)
			{
				String str2=st2[j];
				if(str.equals(str2)){
				  dp[i][j]=dp[i-1][j-1]+1;	
				}else 
				{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		//reverse the path 
		// recursive to get the true path 
		
		
		
		
		
	}
}
