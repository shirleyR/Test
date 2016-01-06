package com.poj;

public class Main1080 {
	
	public static void main(String args[]){
		String a="";
		String b="";
		int alen=a.length();
		int blen=b.length();
		int cost[][]=new int [5][5];
		int dp[][]=new int [alen+10][blen+10];
		dp[0][0]=0;
		
		//  ---
		//  AGTC 
		//  -G-C
		for(int i=1;i<=alen;i++)
		{
			for(int j=1;j<=blen;j++){
				
				if(a.charAt(i-1)==b.charAt(j-1)){
				
					int t=dp[i-1][j-1]+5;
					
				}else {
					int a1=0;
					int b1=0;
					//  two choose  
					dp[i][j]=Math.max(dp[i-1][j]+a1, dp[i][j-1]+b1);
							
					
				}
			}
			
		}
	}

}
