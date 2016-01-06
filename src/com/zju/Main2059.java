package com.zju;

import java.util.Scanner;

//twin tower
public class Main2059 {

	public static void main(String args[]){
		
		// dp[i][v]---> higher of tower when consider number i and difference is v
		//   dp[i][j+h[i]] 
		//dp[i][j+h[i]] = max(dp[i][j+h[i], dp[i-1][j] + h[i]); //向高塔上添加此数。  
	  //  if ( h[i] > j ) //h[i]比高度差j大，所以添加h[i]后就比dp[i-1][j]里的最高塔还高了。 
	  //      dp[i][h[i]-j] = max(dp[i][h[i]-j], dp[i-1][j] + h[i]-j); 
	 //   else           //h[i]比高度差j小 ，所以添加h[i]后较高的塔还较高，  
	  //      dp[i][j-h[i]] = max(dp[i][j-h[i]], dp[i-1][j] );  
		
		//  做的时候运用循环数组，节省空间，注意初始化，在j高度差下，没有数字时要初始化成一个状态。  
		Scanner in=new Scanner(System.in);
		while(true){
			int n=in.nextInt();
			int high[]=new int[n];
			for(int i=0;i<n;i++)
				high[i]=in.nextInt();
			
			
			
			
		}
		
	}
}
