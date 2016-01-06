package com.zju;

import java.util.Scanner;
import java.util.*;

public class Main2014 {
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t>0)
		{ 
			int ew,wt;
			int csum;
			ew=in.nextInt();
			wt=in.nextInt();
			csum=in.nextInt();
			int w[]=new int[csum];
			int v[]=new int[csum];
			int min=0;
			for(int i=0;i<csum;i++){
				v[i]=in.nextInt();
				w[i]=in.nextInt();
				if(i==0)min=w[i];
				else min=w[i]<min?w[i]:min;
			}
			int f[]=new int[wt-ew+1];
			//f[i][v]=max{f[i-1][v],f[i- 1][v-c[i]]+w[i]}
           //f[v]=min{f[v],f[v-c[i]]+w[i]};
		   //f[i][v]=min{f[i-1][v],f[i][v-c[i]]+w[i]}
			
			//initial
			for(int i=0;i<wt-ew+1;i++)
			f[i]=50001;
			
			for(int i=0;i<csum;i++)
				for(int j=w[i];j<=wt-ew;j++)
				{	
					f[j]=Math.min(f[j], f[j-w[i]]+v[i]);
				    System.out.println(f[j]+"d"+v[i]);
				}
			
			System.out.println(f[wt-ew]);
			
			t--;
			
		}
	}
	
}
